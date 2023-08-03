package com.fms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplementation implements UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "root@localhost";
    private static final String DB_PASSWORD = "root";

    
    public User getUserById(int userId) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        user = populateUserFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return user;
    }

    public void addUser(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (name, email, username, password, address, cardType, savingsAccount, ifscCode, activated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                populatePreparedStatement(preparedStatement, user);
                preparedStatement.setBoolean(9, user.isActivated());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        user = populateUserFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE users SET name = ?, email = ?, username = ?, password = ?, address = ?, cardType = ?, savingsAccount = ?, ifscCode = ?, activated = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                populatePreparedStatement(preparedStatement, user);
                preparedStatement.setBoolean(9, user.isActivated());
                preparedStatement.setInt(10, user.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @Override
    public void activateUser(int userId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE users SET activated = true WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    private User populateUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setAddress(resultSet.getString("address"));
        user.setCardType(resultSet.getString("cardType"));
        user.setAccountNumber(resultSet.getString("savingsAccount"));
        user.setIfscCode(resultSet.getString("ifscCode"));
        user.setActivated(resultSet.getBoolean("activated"));
        return user;
    }

    private void populatePreparedStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getAddress());
        preparedStatement.setString(6, user.getCardType());
        preparedStatement.setString(7, user.getAccountNumber());
        preparedStatement.setString(8, user.getIfscCode());
    }

	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	


    // Add implementations for other methods as needed
}
