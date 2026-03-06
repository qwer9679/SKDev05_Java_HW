package P4_book.entity;

public class ReferenceBook extends Publication {
	protected String field;
	
	public ReferenceBook() {
		
	}
	
	public ReferenceBook(String title, String PublishDate, int page, int price, String field) {
        super(title, PublishDate, page, price);
        this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String changefield) {
		this.field = changefield;
	}
	
	public String toString() {
        return "[참고서] 전문분야 : " + field +
                ", " + getPage() + "쪽, " +
                getPrice() + "원, 출판일 : " + getPublishDate();
	}
}
