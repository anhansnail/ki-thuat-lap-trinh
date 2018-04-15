package BKEncyclopedia;

import java.util.*;

public class Category {
	Scanner sc = new Scanner(System.in);
	
	private String categoryCode;
	private String categoryName;
	private int nFields;
	private String[] fields = new String[261];

	public Category() {
		
	}
	
	public Category(String categoryCode, String categoryName, String[] fields) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		for(int i = 0; i <= this.nFields; i++)
			this.fields[i] = fields[i];
	}
	
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getnFields() {
		return nFields;
	}
	public void setnField(int nField) {
		this.nFields = nField;
	}
	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	public void getInfo() {
		System.out.println("Nhap vao ma the Loai:");
		this.categoryCode = sc.nextLine();
		
		System.out.println("Nhap vao ten the loai:");
		this.categoryName = sc.nextLine();
		
		System.out.println("Nhap vao so luong cac truong trong the loai:");
		this.nFields = sc.nextInt();
		
		System.out.println("Nhap vao ten cac truong:");
		for(int i = 0; i <= this.nFields; i++) 
			this.fields[i] = sc.nextLine();
	}
	
	public void showInfo() {
		System.out.println(categoryCode);
		System.out.println(categoryName);
		for(int i = 1; i <= this.nFields; i++)
			System.out.print(fields[i] + "; ");
	}
}
