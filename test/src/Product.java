public class Product {
	private String name;
	private int id;
	private double price;
	private String vendor;
	private double tax;
	private double weight;
        private double numberSold;
        private double revenue;
      

	public Product() {
		name = "";
		id = 0;
		price = 0.0;
		vendor = "";
		tax = 0.0;
		weight = 0.0;
	}

	public Product(String _name, int _id, double _price, String _vendor, double _tax,  
		double _weight) {
		name = _name;
		id = _id;
		price = _price;
		vendor = _vendor;
		tax = _tax;
		weight = _weight;
	}
        
        public Product(String _name, int _id, double _price, String _vendor, double _tax,  
		double _weight, double _numberSold, double _revenue) {
		name = _name;
		id = _id;
		price = _price;
		vendor = _vendor;
		tax = _tax;
		weight = _weight;
                numberSold = _numberSold;
                revenue = _revenue;
	}

	public String getInfo() {
		return name + "" + id + "" + price;
	}

	public int getID() {return id;}
        public String getName() {return name;}
        public double getPrice() {return price;}
        public String getVendor() {return vendor;}
        public double getTax() {return tax;}
        public double getWeight() {return weight;}
        public double getNumberSold() {return numberSold;}
        public double getRevenue() {return revenue;}
        
        public void setProductValues(String _name, int _id, double _price, String _vendor, double _tax,  
		double _weight) {
		name = _name;
		id = _id;
		price = _price;
		vendor = _vendor;
		tax = _tax;
		weight = _weight;
	}
        
        
		
	

}