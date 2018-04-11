package BKEncyclopedia;

import java.util.*;

public class word extends TheLoai{
	Scanner inputWord = new Scanner(System.in);
	
	private String tu;
	private String[] giaTriTruong = new String[100];



	public String getTu() {
		return tu;
	}


	public void setTu(String tu) {
		this.tu = tu;
	}

	public String[] getGiaTriTruong() {
		return giaTriTruong;
	}


	public void setGiaTriTruong(String[] giaTriTruong) {
		this.giaTriTruong = giaTriTruong;
	}


	public void setSoTruong(int soTruong) {
		this.soTruong = soTruong;
	}

	public void nhapTT() {
		System.out.println("nhap vao tu:");
		tu = inputWord.nextLine();
		System.out.println("Nhap vao ma the loai");
		this.maTheLoai = inputWord.nextLine();
		System.out.println("Nhap vao gia tri cac truong");
		for(int i = 0; i <= this.soTruong; i++)
			giaTriTruong[i] = inputWord.nextLine();
	}
	
	public void hienThiTT() {
		System.out.println(tu);
		System.out.println(maTheLoai);
		for(int i = 0; i <= this.soTruong; i++)
			System.out.println(this.giaTriTruong[i]);
	}
	
	
}
