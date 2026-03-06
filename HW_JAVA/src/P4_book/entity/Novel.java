package P4_book.entity;

public class Novel extends Publication {
	protected String author;
	protected String genre;
	
	public Novel() {}
	public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String changeAuthorName) {
		this.author = changeAuthorName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String changeGenre) { 
		this.genre = changeGenre;
	}
	
	@Override
	public String toString() {
		return "[소설] 저자명 : " + author + ", 장르 : " + getGenre() + ", " + getPage() + "쪽, " + 
	getPrice() + "원 출판일 : " + getPublishDate();
	}
}
