package BKEncyclopedia;

import java.util.*;


public class TheLoai {
	Scanner inputTheLoai = new Scanner(System.in);
	
	public String maTheLoai;
	private String tenTheLoai;
	public int soTruong;
	public String[] truong = new String[100];

	/*
	public TheLoai(String maTheLoai, String tenTheLoai, int soTruong, String[] truong) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
		for(int i = 0; i <= this.soTruong; i++) {
			this.truong[i] = truong[i];
		}
	}
	*/
	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public int getSoTruong() {
		return soTruong;
	}

	public void setSoTruong(int soTruong) {
		this.soTruong = soTruong;
	}
	
	public String[] getTruong() {
		return truong;
	}

	public void setTruong(String[] truong) {
		this.truong = truong;
	}
	
	public void NhapTT() {
		System.out.println("Nhap vao the loai");
		
		System.out.println("Nhap vao ma the loai:");
		maTheLoai = inputTheLoai.nextLine()
				;
		System.out.println("Nhap vao ten the loai:");
		tenTheLoai = inputTheLoai.nextLine();
		
		System.out.println("Nhap vao so truong cua the loai:");
		soTruong = inputTheLoai.nextInt();
		
		System.out.println("Nhap vao danh sach cac truong cua the loai: ");
		for(int i = 0; i <= this.soTruong; i++) {
			truong[i] = inputTheLoai.nextLine();
		}
		return;
	}
	
	public void HienThiTT(){
		System.out.println("ma the loai: " + this.maTheLoai);
		System.out.println("ten the loai: " + this.tenTheLoai);
		System.out.println("danh sach cac truong:");
		for(int i = 1; i <= this.soTruong; i++) {
			System.out.println(this.truong[i]);
		}
	}
	
}
