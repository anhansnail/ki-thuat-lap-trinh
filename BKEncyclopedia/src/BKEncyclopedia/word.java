package BKEncyclopedia;

import java.util.*;

public class word {
	Scanner inputWord = new Scanner(System.in);
	
	private String Tu;
	
	private String[] GiaTriTruong = new String[100];
	
	
	public void nhap() {
		System.out.println("nhap vao tu:");
		Tu = inputWord.nextLine();
		System.out.println("Nhap vao ma the loai");
	}
	
	
}
