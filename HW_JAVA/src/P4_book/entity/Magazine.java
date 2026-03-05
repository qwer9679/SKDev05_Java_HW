package P4_book.entity;

public class Magazine extends Publication {
	protected String publishPeriod;
	
	public Magazine() {}
	
	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		
	}
	
	public String getPublishPeriod() {
		return publishPeriod;
	}
	
	public void setPublishPeriod(String changePublishPeriod) {
		this.publishPeriod = changePublishPeriod;
	}
	
	public String toString() {
		return "entity.Magazine.java";
	}
}
