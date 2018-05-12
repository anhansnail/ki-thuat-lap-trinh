package BKEncyclopedia;

import java.util.*;

public class Word {
	Scanner sc = new Scanner(System.in);
	
	private Category category;
	private String word;                                    									
	private String[] fieldsValue = new String[261];			 

	public Word() {
		
	}

	public Word(String word, Category category, String[] fieldsValue) {
		this.word = word;
		this.category = category;
		this.fieldsValue = fieldsValue;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String[] getFieldsValue() {
		return fieldsValue;
	}

	public void setFieldsValue(String[] fieldsValue) {
		this.fieldsValue = fieldsValue;
	}
	
	public void showInfo() {
		System.out.println(word);
		System.out.println(category.categoryID);
		for(int i = 0; i < category.nFields; i++)
			System.out.println(this.fieldsValue[i]);
		System.out.println();
	}
}
