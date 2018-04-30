package BKEncyclopedia;

import java.io.*;
import java.util.*;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	
	static Category[] category = new Category[261];
	static Word[] word = new Word[261];
	
	private static int categoryCounter = 0;
	private static int wordCounter = 0;
	
	public static void main(String[] args) throws IOException {
		
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
					break;
				case 8:
					deleteCategory();
					updateFileCategory();
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
		System.out.println("7: Sua loai");
		System.out.println("8: Xoa");
		System.out.println("9: Thoat");
	}
	
	public static void searchWord() {
		System.out.println("Nhap vao tu can tra:");
		String w = new String();
		w = sc.nextLine();
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(w)) {
				word[i].showInfo();
				return;
			}
		}
		
		System.out.println("Khong tim thay trong tu dien!");
		return;
	}
	
	public static void addWord() {
		word[wordCounter] = new Word();
		word[wordCounter].getInfo();
		wordCounter++;
		return;
	}
	
	public static void addCategory() {
		category[categoryCounter] = new Category();
		category[categoryCounter].getInfo();
		categoryCounter++;
		return;
	}
	
	public static void listWord() {
		System.out.println("Nhap vao the loai:");
		String gc = new String();
		gc = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategoryID().equals(gc)) {
				word[i].showInfo();
			}
		}
		return;
	}
	
	public static void editWord() {	
		System.out.println("Nhap vao tu can sua:");
		String ew = new String();
		ew = sc.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(ew)) {
				word[i].getInfo();
			}
		}
		return;
	}
	
	
	public static void deleteWord() {
		System.out.println("Nhap vao tu can xoa:");
		String dw = new String();
		dw = sc.nextLine();
		
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getWord().equals(dw)) {
				for(int j = i; j < wordCounter; j++) {
					word[j] = word[j+1];
				}
				wordCounter--;
				return;
			}
		}
		return;
	}
	
	public static void editCategory() {
		System.out.println("Nhap vao the loai can sua: ");
		String ec = new String();
		ec = sc.nextLine();
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(ec)) {
				category[i].getInfo();
			}
		}
		return;
	}
	
	public static void deleteCategory() {
		System.out.println("Nhap vao the loai can xoa: ");
		String dc = new String();
		dc = sc.nextLine();
		for(int i = 0; i < categoryCounter; i++) {
			if(category[i].getCategoryName().equals(dc)) {
				for(int j = i; j < categoryCounter; j++) {
					category[j] = category[j+1];
				}
				categoryCounter--;
				return;
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
			fw.write(word[i].getCategoryID() + "\r\n");
			fw.write(word[i].getWord()+ "\r\n");
			String[] tempArr = word[i].getFieldsValue();
			for(int j = 0; j < word[i].getnFields(); j++) {
				fw.write(tempArr[j]);
				fw.write("\r\n");
			}
			fw.write("\r\n");
		}
		fw.close();
		return;
	}
	
	public static void readFileCategory() throws IOException {
		File file = new File("Category.txt");
	    FileReader fr = new FileReader(file);
	    
	    BufferedReader br = new BufferedReader(fr);
	    
	    String line = new String();
	    int temp = 0;
	    String[] tempLine = new String[261];
	    while ((line = br.readLine()) != null){
	    	tempLine[temp] = line;
	    	temp ++;
	    	if(temp == 4) {
	    		String[] tempFields = tempLine[2].split(";");
	    		category[categoryCounter] = new Category(tempLine[0], tempLine[1], tempFields);
	    		category[categoryCounter].showInfo();
	    		temp = 0;
	    		categoryCounter++;
	    	}
	    	
	    }
	    fr.close();
	    br.close(); 
		return;
	}
	
	public static void readFileWord() throws IOException {
		File file = new File("Word.txt");
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = new String();
		int temp = 0;
		String[] tempLine = new String[261];
		while (true) {
			 line = br.readLine();
			 if(line == null) {
				 temp++;
				 String[] tempFieldsValue = new String[temp - 3];
		    	 for(int i = 0; i < temp - 3; i++) {
		    		 tempFieldsValue[i] = tempLine[i+2];
		    	 }
		    	 word[wordCounter] = new Word(tempLine[0], tempLine[1], tempFieldsValue);
		    	 word[wordCounter].showInfo();
		    	 wordCounter++;
		    	 temp = 0;
				 break;
			 }
			 
		     tempLine[temp] = line;
		     temp++;
		     if(line.isEmpty() ) {
		    	 String[] tempFieldsValue = new String[temp - 3];
		    	 for(int i = 0; i < temp - 3; i++) {
		    		 tempFieldsValue[i] = tempLine[i+2];
		    	 }
		    	 word[wordCounter] = new Word(tempLine[0], tempLine[1], tempFieldsValue);
		    	 word[wordCounter].showInfo();
		    	 wordCounter++;
		    	 temp = 0;
		     }
		}
		fr.close();
		br.close(); 
		return;
	}
}
