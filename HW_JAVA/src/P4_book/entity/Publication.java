package P4_book.entity;

public class Publication {
	protected String title;
	protected String publishDate;
	protected int page;
	protected int price;
	
	public Publication() {}
	
	public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String changeTitle) {
		this.title = changeTitle;
	}
	
	public String getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(String changePublishDate) {
		this.publishDate = changePublishDate;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int changePage) {
		this.page = changePage;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int changePrice) {
		this.price = changePrice;
	}
	
	public String toString() {
		return "entity.magazine.java";
	}
}
