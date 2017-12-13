import java.io.IOException;
import java.util.ArrayList; 

public class Order {
	private int id;
	private String date;
	private String payMethod;
	private double total;
	private String items;
	private String quantities;
	private ArrayList<CheckoutItem> checkoutItems;
        private double subtotal = 0;

	Order() {
		id = 0;
		date = "";
		payMethod = "";
		total = 0.0;
		items = "";
		quantities = "";
                checkoutItems = new ArrayList<CheckoutItem>();
                

	}

	Order(int _id, String _date, String _payMethod, double _total, String _items, String _quantities) {
		id = _id;
		date = _date;
		payMethod = _payMethod;
		total = _total;
		items = _items;
		quantities = _quantities;
                checkoutItems = new ArrayList<CheckoutItem>();
                
	}
        
        public int getID() {
            return id; 
        }
        
        public void setID(int idIN) {id = idIN;}
        public void setDate(String dateIn) {date = dateIn;}
        public void setPay(String payIn) {payMethod = payIn;}
        public void setTotal(double totalIn) {total = totalIn;}
        public double getTotal() {return total;}
        public void setSubTotal(double subTotalIn) {subtotal = subTotalIn;}
        public double getSubTotal() {return subtotal;}
        public ArrayList<CheckoutItem> getItemList() {return checkoutItems;}
        public void setItemQuantity(String itemsIn, String quantitiesIn) {
            items = itemsIn;
            quantities = quantitiesIn;
        }
        public void addCheckoutItem(CheckoutItem itemIn) {checkoutItems.add(itemIn);}
        public Boolean pushOrder() {
            Boolean attempt = DataBaseManager.addOrder(id, date, payMethod, total, items, quantities);
            System.out.println(attempt);
            return attempt;
        }
        public int getCount() {return checkoutItems.size();}
    }
        






