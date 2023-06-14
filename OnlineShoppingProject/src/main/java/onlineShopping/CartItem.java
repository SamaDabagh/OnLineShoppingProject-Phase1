package onlineShopping;

public class CartItem extends Product{
	

	    private int quantity;
	    static final double QST  = 9.975;
	    static final double GST  = 5;

		public CartItem(String name, String price, String reducedPrice,String pricePreFix, String imageUrl, int quantity) {
			super(name , price , reducedPrice,pricePreFix,imageUrl);

			this.quantity = quantity;
		}



		public int getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}



		public double calculateTotalPay()
		{
			
			return (Integer.parseInt(super.getPrice()) * this.quantity)*(GST+QST) ;
		}
	
}
