package BKEncyclopedia;

import java.util.*;


public class TheLoai {
	public String maTheLoai;
	private String tenTheLoai;
	public int soTruong;
	public String[] truong = new String[100];

	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	Scanner inputTheLoai = new Scanner(System.in);
	
	
	public void NhapTT() {
		System.out.println("Nhap vao the loai");
		System.out.println("Nhap vao ma the loai:");
		maTheLoai = inputTheLoai.nextLine();
		System.out.println("Nhap vao ten the loai:");
		tenTheLoai = inputTheLoai.nextLine();
		try {
			System.out.println("Nhap vao so truong cua the loai:");
			soTruong = inputTheLoai.nextInt();
		} catch(Exception e) {
			System.out.println("ban phai nhap vao mot so nguyen!");
		}
		System.out.println("Nhap vao danh sach cac truong cua the loai: ");
		for(int i = 0; i <= this.soTruong; i++) {
			truong[i] = inputTheLoai.nextLine();
		}
		
	}
	
	public void HienThiTT(){
		System.out.println("ma the loai: " + this.maTheLoai);
		System.out.println("ten the loai: " + this.tenTheLoai);
		System.out.println("danh sach cac truong:");
		for(int i = 0; i <= this.soTruong; i++) {
			System.out.println(this.truong[i]);
		}
	}
	
}
