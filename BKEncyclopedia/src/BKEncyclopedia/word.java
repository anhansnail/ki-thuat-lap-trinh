package BKEncyclopedia;

import java.util.*;

public class Word{
	
	Scanner sc = new Scanner(System.in);
	private String word;
	private String categoryCode;
	private int nFields;
	private String[] fieldValue = new String[261];

	public Word() {
		
	}

	public Word(String word, String categoryCode, String[] fieldsValue) {
		this.word = word;
		this.categoryCode = categoryCode;
		for(int i = 0; i <= nFields; i++)
			this.fieldValue[i] = fieldValue[i];
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String[] getFieldsValue() {
		return fieldValue;
	}

	public void setFieldsValue(String[] fieldsValue) {
		this.fieldValue = fieldsValue;
	}

	public void getInfo() {
		System.out.println("nhap vao tu:");
		this.word = sc.nextLine();
		
		System.out.println("Nhap vao ma the loai");
		this.categoryCode = sc.nextLine();
		
		System.out.println("Nhap vao so truong cac truong:");
		this.nFields = sc.nextInt();
		
		System.out.println("Nhap vao gia tri cac truong");
		for(int i = 0; i <= this.nFields; i++)
			fieldValue[i] = sc.nextLine();
	}
	
	public void showInfo() {
		System.out.println(word);
		System.out.println(categoryCode);
		for(int i = 1; i <= this.nFields; i++)
			System.out.println(this.fieldValue[i]);
	}
	
	
}
