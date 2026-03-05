package P4_book.entity;

public class ReferenceBook extends Publication {
	protected String field;
	
	public ReferenceBook() {
		
	}
	
	public ReferenceBook(String title, String PublishDate, int page, int price) {
		
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String changefield) {
		this.field = changefield;
	}
	
	public String toString() {
		return "entity.referencebook.java";
	}
}
