package BKEncyclopedia;

public class Category {
	
	private String categoryID;                          // Mã thể loại
	private String categoryName;						// Tên thể loại
	private int nFields;                        		// Số trường trong thể loại
	private String[] fields = null;   					// Tên các trường

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
	
	// Hiện thông tin thể loại
	public void showInfo() {
		System.out.println(categoryID);
		System.out.println(categoryName);
		for(int i = 0; i < this.nFields; i++)
			System.out.print(fields[i] + "; ");
		System.out.println("\n");
	}
}
