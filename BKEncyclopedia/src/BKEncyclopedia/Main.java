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
		
		readFileCategory();
		readFileWord();
		
		int choice;
		do {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
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
		System.out.println("1: Tra tu");
		System.out.println("2: Them tu");
		System.out.println("3: Them the loai");
		System.out.println("4: Liet ke tu trong the loai");
		System.out.println("5: Sua tu");
		System.out.println("6: Xoa tu");
		System.out.println("7: Sua the loai");
		System.out.println("8: Xoa the loai");
		System.out.println("9: Thoat");
	}
	
	public static void searchWord() {
		System.out.println("Nhap vao tu can tra:");
		String sw = sc.nextLine();
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(sw)) {
				word[i].showInfo();
				return;
			}
		}
		
		System.out.println("Khong tim thay trong tu dien!");
		return;
	}
	
	public static void addWord() {	
		System.out.println("Nhap vao ma the loai:");
		String categoryID = sc.nextLine();
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getcategoryID().equals(categoryID)) {
				System.out.println("Nhap vao tu:");
				String wordTemp = sc.nextLine();
				System.out.println("Nhap vao gia tri cac truong:");
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
		
		System.out.println("Khong ton tai the loai nay!");
		return;
	}
	
	public static void addCategory() throws Exception {
		System.out.println("Nhap vao ma the loai:");
		String categoryID = sc.nextLine();
		System.out.println("Nhap vao ten the loai:");
		String categoryName = sc.nextLine();
		System.out.println("Nhap vao so truong cua the loai:");
		int n = sc.nextInt();sc.nextLine();
		System.out.println("Nhap vao ten cac truong:");
		String[] fields = new String[n];
		for(int i = 0; i < n; i++) {
			fields[i] = sc.nextLine();
		}
		
		category[categoryCounter] = new Category(categoryID, categoryName, fields);
		categoryCounter++;
		return;
	}
	
	public static void listWord() {
		System.out.println("Nhap vao ma the loai:");
		String gc = new String();
		gc = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategory().categoryID.equals(gc)) {
				word[i].showInfo();
			}
		}
		return;
	}
	
	public static void editWord(int addr) {
		
	}
	
	public static void editWord() {	
		System.out.println("Nhap vao tu va ma the loai cua tu can sua:");
		String ew = sc.nextLine();
		String ec = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(ew) && word[i].getCategory().categoryID.equals(ec)) {
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
		return;
	}
	
	public static void deleteWord(int addr) {
		for(int i = addr; i < wordCounter; i++) {
			word[i] = word[i+1];
		}
		wordCounter--;
	}
	
	public static void deleteWord() {
		System.out.println("Nhap vao tu va the loai cua tu can xoa:");
		String dw = sc.nextLine();
		String dIDw = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(dw) && word[i].getCategory().categoryID.equals(dIDw)) {
				deleteWord(i);
				return;
			}
		}
		System.out.println("khong co tu " +dw + " trong tu dien");
		return;
	}
	
	public static void editCategory() throws Exception {		
		System.out.println("Nhap vao ten the loai va ma the loai can sua: ");
		String ec = sc.nextLine();
		String eIDc = sc.nextLine();
		
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(ec) && category[i].getcategoryID().equals(eIDc)) {
				System.out.println("Nhap vao ma the loai:");
				String categoryID = sc.nextLine();
				System.out.println("Nhap vao ten the loai:");
				String categoryName = sc.nextLine();
				System.out.println("Nhap vao so truong cua the loai:");
				int n = sc.nextInt();sc.nextLine();
				System.out.println("Nhap vao ten cac truong:");
				String[] fields = new String[n];
				for(int j = 0; j < n; j++) {
					fields[j] = sc.nextLine();
				}
				
				category[i].setcategoryID(categoryID);
				category[i].setCategoryName(categoryName);
				category[i].setnField(n);
				category[i].setFields(fields);
				
				System.out.println("Ban can sua cac tu trong the loai " + ec);
				
				for(int j = 0; j < wordCounter; j++) {
					System.out.println(word[j].getCategory().categoryID);
					if(word[j].getCategory().categoryID.equals(eIDc)) {
						System.out.println("Sua tu " +word[i].getWord());
						
						System.out.println("Nhap vao tu:");
						String tempWord = sc.nextLine();
						System.out.println("Nhap vao gia tri cac truong:");
						String[] fieldsValue = new String[category[i].getnFields()];
						String[] tempArr = category[i].getFields();
						
						for(int k = 0; k < category[i].getnFields(); k++) {
							System.out.print(tempArr[k] + ": ");
							fieldsValue[k] = sc.nextLine();
						}
						
						word[j].setWord(tempWord);
						word[j].setCategory(category[i]);
						word[j].setFieldsValue(fieldsValue);
						return;
					}
				}
				break;
			}
		}
		return;
	}
	
	public static void deleteCategory() {
		System.out.println("Nhap vao ten the loai va ma the loai can xoa: ");
		String dc = sc.nextLine();
		String IDdc = sc.nextLine();
		
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(dc) && category[i].getcategoryID().equals(IDdc)) {
				for(int j = i; j < categoryCounter; j++) {
					category[j] = category[j+1];
				}
				categoryCounter--;
				System.out.println("Da xoa the loai " +dc);
			}
		}
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategory().categoryID.equals(IDdc)) {
				deleteWord(i);
			}
		}
		return;
	}

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
	
	public static void updateFileWord() throws IOException {
		File file = new File("Word.txt");
		FileWriter fw = new FileWriter(file);
		for(int i = 0; i < wordCounter; i++) {
			fw.write(word[i].getWord()+ "\r\n");
			fw.write(word[i].getCategory().categoryID + "\r\n");
			String[] tempArr = word[i].getFieldsValue();
			for(int j = 0; j < word[i].getCategory().nFields; j++) {
				fw.write(tempArr[j]);
				fw.write("\r\n");
			}
			fw.write("\r\n");
		}
		fw.close();
		return;
	}
	
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
			    	
			    	for(int j = 0; j < categoryCounter; j++) {
			    		if(category[j].getcategoryID().equals(tempLine[1])) {
			    			word[wordCounter] = new Word(tempLine[0], category[j], tempFieldsValue);
			    			word[wordCounter].showInfo();
					    	wordCounter++;
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
