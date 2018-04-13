package BKEncyclopedia;

import java.util.*;


public class Main {
	private static Scanner inputMain;
	
	static TheLoai[] theloai = new TheLoai[100];
	static word[] tu = null;
	public static int demTheLoai = 0;
	
	public static void main(String[] args) {		
		inputMain = new Scanner(System.in);
	
		int luaChon = 0;
		
		do {
			HienThiMenu();
			luaChon = inputMain.nextInt();
			switch(luaChon) {
				case 1: // tra tu
					traTu();
					break;
				case 2: // Them tu
					themTu();
					break;
				case 3: // Them the loai
					themTheLoai();
					break;
				case 4: // Thong ke tat ca cac tu trong the loai
					lietKeTuTrongTheLoai();
					break;
				case 5:  // Sua, xoa tu
					suaTu();
					break;
				case 6:  // Sua xoa the loai
					suaTheLoai();
					break;
				case 7:  // Thoat chuong trinh
					break;
			}
		} while( luaChon != 7);
		
		inputMain.close();
	}
	public static void HienThiMenu() {
		System.out.println("MENU:  ");
		System.out.println("1: Tra tu");
		System.out.println("2: Them tu");
		System.out.println("3: Them the loai");
		System.out.println("4: Liet ke cac tu trong the loai");
		System.out.println("5: Sua, xoa tu");
		System.out.println("6: Sua, xoa the loai");
		System.out.println("7: Thoat");
		
		System.out.println("Ban muon lam gi:");
	}
	
	public static void traTu() {
		
		return;
	}

	public static void themTu() {
		
		return;
	}
	
	public static void themTheLoai() {
		theloai[demTheLoai] = new TheLoai();
		theloai[demTheLoai].NhapTT();
		demTheLoai++;
		return;
	}
	
	public static void lietKeTuTrongTheLoai() {
		return;
	}
	public static void suaTu() {
		return;
	}
	
	public static void suaTheLoai() {
		return;
	}
	
}
