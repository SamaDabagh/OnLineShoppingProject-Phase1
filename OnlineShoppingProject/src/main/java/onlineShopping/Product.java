package onlineShopping;

import java.util.Objects;

public class Product {
    private String name;
    private int group;
    private String price;
    private String reducedPrice;
    private int minOrder;
    private boolean canBeSold;
    private String pricePreFix;
    private String imageUrl;
    


	public Product(String name, String price, String reducedPrice,String pricePreFix, String imageUrl) {
        this.name = name;
        this.price = price;
        this.reducedPrice = reducedPrice;
        this.pricePreFix = pricePreFix;
        this.imageUrl = imageUrl;
    }



	public Product(String name, int group, String price, String reducedPrice, int minOrder, boolean canBeSold,
			String pricePreFix, String imageUrl) {
		super();
		this.name = name;
		this.group = group;
		this.price = price;
		this.reducedPrice = reducedPrice;
		this.minOrder = minOrder;
		this.canBeSold = canBeSold;
		this.pricePreFix = pricePreFix;
		this.imageUrl = imageUrl;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getGroup() {
		return group;
	}



	public void setGroup(int group) {
		this.group = group;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getReducedPrice() {
		return reducedPrice;
	}



	public void setReducedPrice(String reducedPrice) {
		this.reducedPrice = reducedPrice;
	}



	public int getMinOrder() {
		return minOrder;
	}



	public void setMinOrder(int minOrder) {
		this.minOrder = minOrder;
	}



	public boolean isCanBeSold() {
		return canBeSold;
	}



	public void setCanBeSold(boolean canBeSold) {
		this.canBeSold = canBeSold;
	}



	public String getPricePreFix() {
		return pricePreFix;
	}



	public void setPricePreFix(String pricePreFix) {
		this.pricePreFix = pricePreFix;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	@Override
	public int hashCode() {
		return Objects.hash(canBeSold, group, imageUrl, minOrder, name, price, pricePreFix, reducedPrice);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return canBeSold == other.canBeSold && group == other.group && Objects.equals(imageUrl, other.imageUrl)
				&& minOrder == other.minOrder && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(pricePreFix, other.pricePreFix) && Objects.equals(reducedPrice, other.reducedPrice);
	}



	@Override
	public String toString() {
		return "Product [name=" + name + ", group=" + group + ", price=" + price + ", reducedPrice=" + reducedPrice
				+ ", minOrder=" + minOrder + ", canBeSold=" + canBeSold + ", pricePreFix=" + pricePreFix + ", imageUrl="
				+ imageUrl + "]";
	}





}
