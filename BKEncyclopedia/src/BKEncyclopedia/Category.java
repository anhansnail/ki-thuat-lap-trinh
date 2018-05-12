package BKEncyclopedia;

import java.util.*;

public class Category {
	Scanner sc = new Scanner(System.in);
	
	protected String categoryID;       			 
	protected String categoryName;     			 
	protected int nFields;                        
	protected String[] fields = null;   

	public Category() {
		
	}
	
	public Category(String categoryID, String categoryName, String[] fields) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.nFields = fields.length;
		this.fields = fields;
	}
	
	
	public String getcategoryID() {
		return categoryID;
	}
	public void setcategoryID(String categoryID) {
		this.categoryID = categoryID;
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
	
	public void showInfo() {
		System.out.println(categoryID);
		System.out.println(categoryName);
		for(int i = 0; i < this.nFields; i++)
			System.out.print(fields[i] + "; ");
		System.out.println("\n");
	}
}
