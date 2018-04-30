package BKEncyclopedia;

import java.util.*;

public class Word{
	
	Scanner sc = new Scanner(System.in);
	private String word;
	private String categoryID;
	private int nFields;
	private String[] fieldValue = new String[261];

	public Word() {
		
	}

	public Word(String word, String categoryID, String[] fieldsValue) {
		this.word = word;
		this.categoryID = categoryID;
		this.nFields = fieldsValue.length;
		this.fieldValue = fieldsValue;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setcategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String[] getFieldsValue() {
		return fieldValue;
	}

	public int getnFields() {
		return nFields;
	}

	public void setnFields(int nFields) {
		this.nFields = nFields;
	}

	public void setFieldsValue(String[] fieldsValue) {
		this.fieldValue = fieldsValue;
	}

	public void getInfo() {
		System.out.println("nhap vao tu:");
		this.word = sc.nextLine();
		
		System.out.println("Nhap vao ma the loai");
		this.categoryID = sc.nextLine();
		
		System.out.println("Nhap vao so truong cac truong:");
		this.nFields = sc.nextInt();sc.nextLine();
		
		System.out.println("Nhap vao gia tri cac truong");
		for(int i = 0; i < this.nFields; i++)
			fieldValue[i] = sc.nextLine();
	}
	
	public void showInfo() {
		System.out.println(word);
		System.out.println(categoryID);
		for(int i = 0; i < this.nFields; i++)
			System.out.println(this.fieldValue[i]);
		System.out.println();
	}
	
	
}
