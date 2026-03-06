package P4_book.entity;

public class Magazine extends Publication {
	protected String publishPeriod;
	
	public Magazine() {}
	
	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod = publishPeriod;
	}
	
	public String getPublishPeriod() {
		return publishPeriod;
	}
	
	public void setPublishPeriod(String changePublishPeriod) {
		this.publishPeriod = changePublishPeriod;
	}
	
	@Override
	public String toString() {
		return "[잡지] 발행주기 :" + publishPeriod + ", " + getPage() + "쪽, " + 
	getPrice() + "원, 출판일 : " + getPublishDate();
	}
}
