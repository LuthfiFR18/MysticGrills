package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Products {

	private int ProductID;
	private String ProductName;
	private int ProductPrice;
	private int ProductQuantity;

	public Products(int productID, String productName, int productPrice) {
		ProductID = productID;
		ProductName = productName;
		ProductPrice = productPrice;
	}

	public static ArrayList<Products> loadProducts() {
		ArrayList<Products> products = new ArrayList<>();
		String query = "SELECT * FROM product";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				int productID = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);

				products.add(new Products(productID, productName, productPrice));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return products;
	}

	public static void insertProduct(String productName, int productPrice) {
	    String query = String.format(
	            "INSERT INTO product (menuItemName, menuItemPrice) VALUES ('%s', %d)", productName, productPrice);
	    Connect.getConnection().executeUpdate(query);
	}


	public static void deleteProduct(int productID) {
		String query = "DELETE FROM product WHERE menuItemId = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);

		try {
			ps.setInt(1, productID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateProduct(int productID, String productName, int productPrice) {
	    String query = "UPDATE product SET menuItemName = ?, menuItemPrice = ? WHERE menuItemId = ?";

	    try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
	        ps.setString(1, productName);
	        ps.setInt(2, productPrice);
	        ps.setInt(3, productID); 
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int menuItemId) {
		ProductID = menuItemId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String menuItemName) {
		ProductName = menuItemName;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int menuItemPrice) {
		ProductPrice = menuItemPrice;
	}



}
