package BKEncyclopedia;

import java.io.*;
import java.util.*;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	static Category[] category = new Category[261];
	static Word[] word = new Word[261];
	
	private static int categoryCounter = 0;
	private static int wordCounter = 0;
	
	public static void main(String[] args) throws Exception {
		
		// Đọc dữ liệu có sẵn trong các file dữ liệu
		readFileCategory();
		readFileWord();
		
		int choice = 0;
		do {
			showMenu();
			try {
				choice = sc.nextInt();
				if(choice <= 0 || choice > 9) {
					Exception errorNumber = new Exception();
					throw errorNumber;
				}
			} catch(Exception e) {
				System.out.println("Bạn phải nhập vào một số nguyên dương từ 1 - 9");
			}
			sc.nextLine();                               // Tránh lỗi khi nhập số
			switch(choice) {
				case 1:
					searchWord();
					break;
				case 2:
					addWord();
					updateFileWord();
					break;
				case 3:
					addCategory();
					updateFileCategory();
					break;
				case 4:
					listWord();
					break;
				case 5:
					editWord();
					updateFileWord();
					break;
				case 6:
					deleteWord();
					updateFileWord();
					break;
				case 7:
					editCategory();
					updateFileCategory();
					updateFileWord();
					break;
				case 8:
					deleteCategory();
					updateFileCategory();
					updateFileWord();
					break;
			}
			
		} while (choice != 9);
		
		
	System.out.println("BYE BYE!");
	sc.close();
}
	
	public static void showMenu() {
		System.out.println("\t MENU");
		System.out.println("1: Tra từ");
		System.out.println("2: Thêm từ");
		System.out.println("3: Thêm thể loại");
		System.out.println("4: Liệt kê tất cả các từ trong thể loại");
		System.out.println("5: Sửa từ");
		System.out.println("6: Xóa từ");
		System.out.println("7: Sửa thể loại");
		System.out.println("8: Xóa thể loại");
		System.out.println("9: Thoát");
	}
	
	// tra từ được nhập vào
	public static void searchWord() {
		System.out.println("Nhập vào từ cần tra:");
		String sw = sc.nextLine();
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(sw)) {
				word[i].showInfo();
				return;
			}
		}
		
		System.out.println("Không tìm thấy từ trong từ điển!");
		return;
	}
	
	// Thêm 1 từ
	public static void addWord() {	
		System.out.println("Nhập vào mã thể loại:");
		String categoryID = sc.nextLine();
		
		// Kiểm tra thể loại có tồn tại không
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getcategoryID().equals(categoryID)) {
				System.out.println("Nhập vào từ:");
				String wordTemp = sc.nextLine();
				System.out.println("Nhập vào giá trị các trường:");
				String[] fieldsvalue = new String[category[i].getnFields()];
				
				String[] tempArr = category[i].getFields();
				for(int j = 0; j < category[i].getnFields(); j++) {
					System.out.print(tempArr[j] + ": ");
					fieldsvalue[j] = sc.nextLine();
				}
				word[wordCounter] = new Word(wordTemp, category[i], fieldsvalue);
				wordCounter++;
				return;
			}
		}
		
		System.out.println("Không tồn tại thể loại này!");
		return;
	}
	
	// Thêm 1 thể loại
	public static void addCategory() throws Exception {
		System.out.println("Nhập vào mã thể loại:");
		String categoryID = sc.nextLine();
		
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getcategoryID().equals(categoryID)) {
				System.out.println("Đã tồn tại thể loại này!");
				return;
			}
		}
		System.out.println("Nhập vào tên thể loại:");
		String categoryName = sc.nextLine();
		System.out.println("Nhập vào số trường của thế loại:");
		int n = 0;
		try {
			n = sc.nextInt();
			if( n < 0) {
				Exception errorNumber = new Exception();
				throw errorNumber;
			}
		}catch(Exception e) {
			System.out.println("Bạn cần nhập vào một số nguyên dương!");
		}
		sc.nextLine();
		System.out.println("Nhập vào tên các trường:");
		String[] fields = new String[n];
		for(int i = 0; i < n; i++) {
			fields[i] = sc.nextLine();
		}
		
		category[categoryCounter] = new Category(categoryID, categoryName, fields);
		categoryCounter++;
		return;
	}
	
	// Liệt kê các từ trong thể loại
	public static void listWord() {
		System.out.println("Nhập vào tên và mã thể loại:");
		String gc = sc.nextLine();
		String IDgc = sc.nextLine();
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategory().getcategoryID().equals(IDgc) && word[i].getCategory().getCategoryName().equals(gc)) {
				word[i].showInfo();
			}
		}
		return;
	}
	
	// Sửa từ
	public static void editWord() {	
		System.out.println("Nhập vào từ và mã thể loại của từ cần sửa:");
		String ew = sc.nextLine();
		String ec = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(ew) && word[i].getCategory().getcategoryID().equals(ec)) {
				System.out.println("Nhap vao ma the loai:");
				String categoryID = sc.nextLine();
				for(int j = 0; j < categoryCounter; j++) {
					if(category[j].getcategoryID().equals(categoryID)) {
						System.out.println("Nhap vao tu:");
						String tempWord = sc.nextLine();
						System.out.println("Nhap vao gia tri cac truong:");
						String[] fieldsValue = new String[category[j].getnFields()];
						
						String[] tempArr = category[j].getFields();
						for(int k = 0; k < category[j].getnFields(); k++) {
							System.out.print(tempArr[k] + ": ");
							fieldsValue[k] = sc.nextLine();
						}
						
						word[i].setWord(tempWord);
						word[i].setCategory(category[j]);
						word[i].setFieldsValue(fieldsValue);
						return;
					}
				}
			}
		}
		
		System.out.println("Không tồn tại từ này!");
		return;
	}
	
	// Xóa 1 từ tại vị trí xác định
	public static void deleteWord(int addr) {
		for(int i = addr; i < wordCounter; i++) {
			word[i] = word[i+1];
		}
		wordCounter--;
	}
	
	// Xóa 1 từ
	public static void deleteWord() {
		System.out.println("Nhập vào từ và mã thể loại của từ cần xóa:");
		String dw = sc.nextLine();
		String dIDw = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(dw) && word[i].getCategory().getcategoryID().equals(dIDw)) {
				deleteWord(i);
				return;
			}
		}
		System.out.println("Không tồn tại từ này!");
		return;
	}
	
	// Sửa 1 thể loại
	public static void editCategory() throws Exception {		
		System.out.println("Nhập vào tên thể loại và mã thể loại cần sửa: ");
		String ec = sc.nextLine();
		String IDec = sc.nextLine();
		
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(ec) && category[i].getcategoryID().equals(IDec)) {
				System.out.println("Nhập vào mã thể loại:");
				String categoryID = sc.nextLine();
				System.out.println("Nhập vào tên thể loại:");
				String categoryName = sc.nextLine();
				System.out.println("Nhập vào số trường của thể loại:");
				int n = 0;
				try {
					n = sc.nextInt();
					if(n < 1 ) {
						Exception errorNumber = new Exception();
						throw errorNumber;
					}
				}catch(Exception e) {
					System.out.println("Bạn phải nhập vào một số nguyên dương!");
				}
				sc.nextLine();
				System.out.println("Nhập vào tên các trường:");
				String[] fields = new String[n];
				for(int j = 0; j < n; j++) {
					fields[j] = sc.nextLine();
				}
				
				category[i].setcategoryID(categoryID);
				category[i].setCategoryName(categoryName);
				category[i].setnField(n);
				category[i].setFields(fields);
				
				System.out.println("Bạn cần sửa lại tất cả các từ trong thể loại " + ec);
				
				for(int j = 0; j < wordCounter; j++) {
					if(word[j].getCategory().getcategoryID().equals(IDec)) {
						System.out.println("Sửa từ " +word[i].getWord());
						
						System.out.println("Nhập vào từ:");
						String tempWord = sc.nextLine();
						System.out.println("Nhập vào giá trị các trường:");
						String[] fieldsValue = new String[category[i].getnFields()];
						String[] tempArr = category[i].getFields();
						
						for(int k = 0; k < category[i].getnFields(); k++) {
							System.out.print(tempArr[k] + ": ");
							fieldsValue[k] = sc.nextLine();
						}
						
						word[j].setWord(tempWord);
						word[j].setCategory(category[i]);
						word[j].setFieldsValue(fieldsValue);
					}
				}
				break;
			}
		}
		return;
	}
	
	// Xóa 1 thể loại và xóa tất cả từ trong thể loại
	public static void deleteCategory() {
		System.out.println("Nhập vào tên và mã thể loại cần xóa: ");
		String dc = sc.nextLine();
		String IDdc = sc.nextLine();
		
		// Xóa thể loại
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(dc) && category[i].getcategoryID().equals(IDdc)) {
				for(int j = i; j < categoryCounter; j++) {
					category[j] = category[j+1];
				}
				categoryCounter--;
				System.out.println("Đã xóa thể loại " +dc);
			}
		}
		
		// Xóa các từ trong thể loại
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategory().getcategoryID().equals(IDdc)) {
				deleteWord(i);
			}
		}
		return;
	}

	// Ghi các thể loại ra file
	public static void updateFileCategory() throws IOException {
		File file = new File("Category.txt");
		FileWriter fw = new FileWriter(file);
		for(int i = 0; i < categoryCounter; i++) {
			fw.write(category[i].getcategoryID() + "\r\n");
			fw.write(category[i].getCategoryName()+ "\r\n");
			String[] tempArr = category[i].getFields();
			for(int j = 0; j < category[i].getnFields(); j++) 
				fw.write(tempArr[j] + ";");
			fw.write("\r\n");fw.write("\r\n");
		}
		fw.close();
		return;
	}
	
	// Ghi các từ ra file
	public static void updateFileWord() throws IOException {
		File file = new File("Word.txt");
		FileWriter fw = new FileWriter(file);
		for(int i = 0; i < wordCounter; i++) {
			fw.write(word[i].getWord()+ "\r\n");
			fw.write(word[i].getCategory().getcategoryID() + "\r\n");
			String[] tempArr = word[i].getFieldsValue();
			for(int j = 0; j < word[i].getCategory().getnFields(); j++) {
				fw.write(tempArr[j]);
				fw.write("\r\n");
			}
			fw.write("\r\n");
		}
		fw.close();
		return;
	}
	
	// Đọc dữ liệu các thể loại từ file
	public static void readFileCategory() throws IOException {
		try {
			File file = new File("Category.txt");
		    FileReader fr = new FileReader(file);
		    
		    BufferedReader br = new BufferedReader(fr);
		    
		    String line = new String();
		    int tempCounter = 0;
		    String[] tempLine = new String[261];
		    
		    while ((line = br.readLine()) != null){
		    	tempLine[tempCounter] = line;
		    	tempCounter ++;
		    	
		    	/* tempLine[0] lưu mã thể loại
		    	 * tempLine[1] lưu tên thể loại
		    	 * tempLine[2] đọc 1 chuỗi là danh sách các trường, sau đó được tách ra lưu vào mảng tempFields[]
		    	 */
		    	
		    	if(tempCounter == 4) {
		    		String[] tempFields = tempLine[2].split(";");
		    		category[categoryCounter] = new Category(tempLine[0], tempLine[1], tempFields);
		    		category[categoryCounter].showInfo();
		    		tempCounter = 0;
		    		categoryCounter++;
		    	}
		    }
		    fr.close();
		    br.close();
		}catch(Exception e) {
			return;
		}
	}
	
	// Đọc dữ liệu các từ từ file
	public static void readFileWord() throws IOException {
		try {
			File file = new File("Word.txt");
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			
			String line = new String();
			int tempCounter = 0;
			String[] tempLine = new String[261];
			while ((line = br.readLine()) != null) {
			    tempLine[tempCounter] = line;
			    tempCounter++;
			    if(line.isEmpty() ) {
			    	String[] tempFieldsValue = new String[tempCounter - 3];
			    	for(int i = 0; i < tempCounter - 3; i++) {
			    		tempFieldsValue[i] = tempLine[i+2];
			    	}
			    	
			    	/* tempLine[0] lưu từ
			    	 * tempLine[1] lưu mã thể loại của từ
			    	 * từ tempLine[2] trở đi sẽ chuyển về mảng tempFieldsValue[] để lưu giá trị các trường
			    	*/
			    	
			    	// kiểm tra mã thể loại đã có trong danh sách chưa, nếu có thì thêm từ
			    	for(int j = 0; j < categoryCounter; j++) {
			    		if(category[j].getcategoryID().equals(tempLine[1])) {
			    			word[wordCounter] = new Word(tempLine[0], category[j], tempFieldsValue);
			    			word[wordCounter].showInfo();
					    	wordCounter++;
					    	break;
			    		}
			    		
			    		if(j == categoryCounter - 1) {
			    			System.out.println("Không tồn tại thể loại này!");
			    		}
			    	}
			    	tempCounter = 0;
			    }
			     
			}
			fr.close();
			br.close();
		}catch(Exception e) {
			return;
		}
	}
}
