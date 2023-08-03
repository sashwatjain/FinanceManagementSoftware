package com.fms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplementation implements ProductDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finance_management";
    private static final String DB_USER = "root@localhost";
    private static final String DB_PASSWORD = "root";
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement
            String sql = "SELECT * FROM products";
            stmt = conn.prepareStatement(sql);

            // Execute the SQL statement
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("cost")
                );
                products.add(product);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }
	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	

		
	 public List<Product> getProductsByUserId(int userId) {
	        List<Product> purchasedProducts = new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Establish the database connection
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

	            // Prepare the SQL statement
	            String sql = "SELECT p.* FROM products p "
	                       + "INNER JOIN user_purchases up ON p.id = up.product_id "
	                       + "WHERE up.user_id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, userId);

	            // Execute the SQL statement
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                Product product = new Product(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("description"),
	                    rs.getDouble("cost")
	                );
	                purchasedProducts.add(product);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return purchasedProducts;
	    }
	
}
