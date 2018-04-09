package BKEncyclopedia;

import java.util.*;

public class Main {
	private static Scanner inputMain;

	public static void main(String[] args) {
		
		inputMain = new Scanner(System.in);
		
		System.out.println("Ban muon lam gi:");
		int LuaChon = inputMain.nextInt();
		switch(LuaChon) {
			case 1:
				// Tra tu
				System.out.println("nhap vao tu ban muon tra:");
				String word = inputMain.nextLine();
			case 2:
				// Them tu
			case 3:
				// Them the loai
			case 4:
				// Thong ke tat ca cac tu trong the loai
			case 5:
				// Sua, xoa tu
			case 6:
				// Sua xoa the loai
			case 7:
				// Thoat chuong trinh
				
		}
		
		TheLoai t1 = new TheLoai();
		t1.Nhap();
		t1.show();
	}

}
