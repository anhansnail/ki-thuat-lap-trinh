package BKEncyclopedia;

import java.util.*;


public class TheLoai {
	private String MaTheLoai;
	private String TenTheLoai;
	private int SoTruong;
	private String[] Truong = new String[100];

	Scanner inputTheLoai = new Scanner(System.in);
	
	public String getMaTheLoai() {
		return MaTheLoai;
	}
	
	public void setMaTheLoai(String maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	
	public String[] getTruong() {
		return Truong;
	}
	
	public void setTruong(String[] truong) {
		Truong = truong;
	}

	public void setSoTruong(int SoTruong){
		this.SoTruong = SoTruong;
	}
	
	
	public void Nhap() {
		System.out.println("Nhap vao the loai");
		System.out.println("Nhap vao ma the loai:");
		MaTheLoai = inputTheLoai.nextLine();
		System.out.println("Nhap vao ten the loai:");
		TenTheLoai = inputTheLoai.nextLine();
		try {
			System.out.println("Nhap vao so truong cua the loai:");
			SoTruong = inputTheLoai.nextInt();
		} catch(Exception e) {
			System.out.println("ban phai nhap vao mot so nguyen!");
		}
		System.out.println("Nhap vao danh sach cac truong cua the loai: ");
		for(int i = 0; i <= this.SoTruong; i++) {
			Truong[i] = inputTheLoai.nextLine();
		}
		
	}
	
	public void show(){
		System.out.println("ma the loai: " + this.MaTheLoai);
		System.out.println("ten the loai: " + this.TenTheLoai);
		System.out.println("danh sach cac truong:");
		for(int i = 0; i <= this.SoTruong; i++) {
			System.out.println(this.Truong[i]);
		}
	}
	
}
