import java.sql.*; 
import java.io.IOException;
import java.util.ArrayList; 

class DataBaseManager {  
	private static String jbdc = "com.mysql.jdbc.Driver";
	private static String user = "smashburn";
	private static String pass = "helloworld";
	private static String hostDB = "jdbc:mysql://maindbinstance.cn7ucsyosm9y.us-east-2.rds.amazonaws.com/smashburnMain";



	//This is a function to get a product item by ID
	public static Product getProductByID(int _id) {
		try {
			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM product_table WHERE ID = " + _id;
			ResultSet product = stmt.executeQuery(query);
			
			if (product != null) {
				return new Product(product.getString(1), product.getInt(2), product.getDouble(3), product.getString(4), product.getDouble(5), product.getDouble(6), product.getDouble(7), product.getDouble(8));
			}
                        con.close();
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}

	//This is a function to get an order by ID
	public static Order getOrderByID(int _id) {
		try {

			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM order_table WHERE ID = " + _id;
			ResultSet order = stmt.executeQuery(query);
			
			if (order != null) {
				return new Order(order.getInt(1), order.getString(2), order.getString(3), order.getDouble(4), order.getString(5), order.getString(6));
			}
                        con.close();
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
        
        public static User checkLoginCredentials(String _user, String _pass) {
            try {

			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM user_table WHERE username = " + _user + "AND password = " + _pass;
			ResultSet user = stmt.executeQuery(query);
			
			if (user != null) {
				return new User(user.getInt(1), user.getString(2), user.getString(3), user.getString(4), user.getInt(5));
			}
                        con.close();
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
        }
        
        //This is a function to get all users
	public static ArrayList<User> getUsers() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM user_table";
			ResultSet user = stmt.executeQuery(query);
			
			
			if (user != null) {
				while (user.next()) {
					result.add(new User(user.getInt(1), user.getString(2), user.getString(3), user.getString(4), user.getInt(5)));
				}
			}
			con.close();
		} catch (Exception e) {System.out.println(e);}

		return result;
	}
        //The function used to update user information
        public static Boolean updateUser(String nameIn, String profileIn, String passwordIn) {
		try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "UPDATE user_table set password = ?, profile_pic = ? WHERE username = ? ";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, passwordIn);
                    preparedStmt.setString(2, profileIn);
                    preparedStmt.setString(3, nameIn);
                    

                    if (preparedStmt.executeUpdate() != 0) {
                            return true;
                    }
                    con.close();
			
		} catch (Exception e) {System.out.println(e);}

		return false;
	}
        
        //This is the function for adding a new user
        public static Boolean addUser(String _name, String _pass, String _pic, int _type) {
		try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "INSERT INTO user_table(username, password, profile_pic, user_type) " +
                    "VALUES(?, ?, ?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, _name);
      		    preparedStmt.setString(2, _pass);
     	            preparedStmt.setString(3, _pic);
      		    preparedStmt.setInt(4, _type);
     	            

                    if (preparedStmt.executeUpdate() != 0) {
                        return true;
                    }
                    con.close();
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
        
        

	//This is a function to get a product item by ID
	public static ArrayList<Product> getProducts() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM product_table";
			ResultSet product = stmt.executeQuery(query);
			
			
			if (product != null) {
				while (product.next()) {
					result.add(new Product(product.getString(1), product.getInt(2), product.getDouble(3), product.getString(4), product.getDouble(5), product.getDouble(6), product.getDouble(7), product.getDouble(8)));
				}
			}
			con.close();
		} catch (Exception e) {System.out.println(e);}

		return result;
	}

	//This is a function to get an order by ID
	public static ArrayList<Order> getOrders() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {

			Class.forName(jbdc);
			Connection con = DriverManager.getConnection(hostDB, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM order_table";
			ResultSet order = stmt.executeQuery(query);
			
			if (order != null) {
				while (order.next()) {
					result.add(new Order(order.getInt(1), order.getString(2), order.getString(3), order.getDouble(4), order.getString(5), order.getString(6)));
				}
			}
			con.close();
		} catch (Exception e) {System.out.println(e);}

		return result;
	}




	public static Boolean updateProduct(String _name, int _id, double _price, String _vendor, double _tax,  
		double _weight) {
		try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "UPDATE product_table set Name = ?, Price = ?, Vendor = ?, Tax = ?, Weight = ?" +
                    " WHERE ID = ?";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, _name);
                    preparedStmt.setDouble(2, _price);
                    preparedStmt.setString(3, _vendor);
                    preparedStmt.setDouble(4, _tax);
                    preparedStmt.setDouble(5, _weight);
                    preparedStmt.setInt(6, _id);

                    if (preparedStmt.executeUpdate() != 0) {
                            return true;
                    }
                    con.close();
			
		} catch (Exception e) {System.out.println(e);}

		return false;
	}
        
        public static Boolean updateProductBusinessInfo(int _id, double _numberSold, double _revenue) {
            try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "UPDATE product_table set Number_Sold = Number_Sold + ?, Revenue = Revenue + ?" +
                    " WHERE ID = ?";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setDouble(1, _numberSold);
                    preparedStmt.setDouble(2, _revenue);
                    preparedStmt.setInt(3, _id);
                    
                    if (preparedStmt.executeUpdate() != 0) {
                            return true;
                    }
                    con.close();
			
		} catch (Exception e) {System.out.println(e);}

		return false;
        }

	public static Boolean addProduct(String _name, double _price, String _vendor, double _tax,  
		double _weight) {
		try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "INSERT INTO product_table(Name, Price, Vendor, Tax, Weight) " +
                    "VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, _name);
      		    
     	            preparedStmt.setDouble(2, _price);
      		    preparedStmt.setString(3, _vendor);
     	            preparedStmt.setDouble(4, _tax);
     	            preparedStmt.setDouble(5, _weight);

                    if (preparedStmt.executeUpdate() != 0) {
                        return true;
                    }
                    con.close();
		} catch (Exception e) {System.out.println(e);}
		return false;
	}

	public static Boolean addOrder(int _id, String _date, String _payMethod, double _total, String _items, String _quantities) {
		try {
                    Class.forName(jbdc);
                    Connection con = DriverManager.getConnection(hostDB, user, pass);
			
                    String query = "INSERT INTO order_table(ID, Date, PaymentMethod, Total, Items, Quantities) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, _id);
                    preparedStmt.setString(2, _date);
                    preparedStmt.setString(3, _payMethod);
                    preparedStmt.setDouble(4, _total);
                    preparedStmt.setString(5, _items);
                    preparedStmt.setString(6, _quantities);

                    if (preparedStmt.executeUpdate() > 0) {
                        System.out.println("hellomoto");
                        return true;
                    }

                    con.close();
		} catch (Exception e) {System.out.println(e);}

		return false;
	}

	public static void main(String args[]){  
		System.out.println("booty");
		ArrayList<Product> test = DataBaseManager.getProducts();
		for (Product i : test) {
			System.out.println(i.getInfo());
		}


	}

}  



