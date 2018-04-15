package BKEncyclopedia;

import java.util.*;


public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	static Category[] category = new Category[261];
	static Word[] word = new Word[261];
	
	private static int categoryCounter = 0;
	private static int wordCounter = 0;
	
	public static void main(String[] args) {
		
		int choice;
		do {
			showMenu();
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					searchWord();
					break;
				case 2:
					addWord();
					break;
				case 3:
					addCategory();
					break;
				case 4:
					listWord();
					break;
				case 5:
					editWord();
					break;
				case 6:
					//editCategory();
					break;
			}
			
		} while (choice != 7);
	System.out.println("BYE BYE!");
	sc.close();
}
	
	public static void showMenu() {
		System.out.println("\t MENU");
		System.out.println("1: Tra tu");
		System.out.println("2: Them tu");
		System.out.println("3: Them the loai");
		System.out.println("4: Liet ke tu trong the loai");
		System.out.println("5: Sua, xoa tu");
		System.out.println("6: Sua, xoa the loai");
		System.out.println("7: Thoat");
	}
	
	public static void searchWord() {
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Nhap vao tu can tra:");
		String w = new String();
		w = sc2.nextLine();
		
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
		Scanner sc2 = new Scanner(System.in);
		
		String gc = new String();
		gc = sc2.nextLine();
		for(int i = 0; i < wordCounter; i++) {
			if(word[i].getCategoryCode().equals(gc)) {
				word[i].showInfo();
			}
		}
		return;
	}
	
	public static void editWord() {
		return;
	}
	
	public static void editCategory() {
		return;
	}
	
}
