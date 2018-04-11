package BKEncyclopedia;

import java.util.*;

public class Main {
	private static Scanner inputMain;

	public static void main(String[] args) {
		
		inputMain = new Scanner(System.in);
		System.out.println("1: Tra tu");
		System.out.println("2: Them tu");
		System.out.println("3: Them the loai");
		System.out.println("4: Liet ke cac tu trong the loai");
		System.out.println("5: Sua, xoa tu");
		System.out.println("6: Sua, xoa the loai");
		System.out.println("7: Thoat");
		
		/*
		System.out.println("Ban muon lam gi:");
		int LuaChon = inputMain.nextInt();
		switch(LuaChon) {
			case 1:
				// Tra tu
				break;
			case 2:
				// Them tu
				break;
			case 3:
				// Them the loai
				break;
			case 4:
				// Thong ke tat ca cac tu trong the loai
				break;
			case 5:
				// Sua, xoa tu
				break;
			case 6:
				// Sua xoa the loai
				break;
			case 7:
				// Thoat chuong trinh
				
		}
		*/
		TheLoai t1 = new TheLoai();
		t1.nhapTT();
		t1.HienThiTT();
	}

}
