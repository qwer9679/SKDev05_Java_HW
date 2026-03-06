package P4_book.control;

import java.util.List;
import java.util.ArrayList;
import P4_book.entity.*;

public class ShoppingCart {
	protected List<Publication> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Publication item) {
		items.add(item);
		System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}
	
	public boolean removeItem(String Title) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getTitle().equals(Title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되엇습니다.");
				return true;
			}
		}
		System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
		return false;
	}
	
	public void displayCart() {
		for(Publication item : items) {
			System.out.println(item);
		}
	}
	
	public int claculateTitalPrice() {
		int sum = 0;
		for(Publication item : items) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public int claculateDiscountedPrice() {
		int total = 0;
		for (Publication item : items) {
			if (item instanceof Magazine) {
				total += item.getPrice() * 0.9;
			}else if (item instanceof Novel) {
				total += item.getPrice() * 0.85;
			}else if (item instanceof ReferenceBook) {
				total += item.getPrice() * 0.8;
			}else {
				total += item.getPrice();
			}
		}
		return total;
	}
}
