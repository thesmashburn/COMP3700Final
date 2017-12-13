public class CheckoutItem extends Product {

	private int quantity;

	public CheckoutItem() {
		super();
		quantity = 0;
	}

	public CheckoutItem(String _name, int _id, double _price, String _vendor, double _tax,  
		double _weight, int _quantity) {
		super(_name, _id, _price, _vendor, _tax, _weight);
		quantity =  _quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int _quantity) {
		quantity = _quantity;
	}



}