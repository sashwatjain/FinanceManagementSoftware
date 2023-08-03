package com.fms;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    void addUser(User user);
    User getUserByUsername(String username);
    void updateUser(User user);
    // Add other methods as needed
    void activateUser(int userId); // Add this method for user activation
	void approveUser(int userId);
}
