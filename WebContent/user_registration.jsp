<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    
    <form action="UserRegistrationServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required>
        <br>
        
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required>
        <br>
        
        <label for="phone">Phone Number:</label>
        <input type="text" name="phone" id="phone" required>
        <br>
        
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required>
        <br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required>
        <br>
        
        <label for="address">Address:</label>
        <textarea name="address" id="address" rows="4" required></textarea>
        <br>
        
        <label for="cardType">Card Type:</label>
        <select name="cardType" id="cardType" required>
            <option value="Gold">Gold</option>
            <option value="Titanium">Titanium</option>
        </select>
        <br>
        
        <label for="savingsAccount">Savings Account Number:</label>
        <input type="text" name="savingsAccount" id="savingsAccount" required>
        <br>
        
        <label for="ifscCode">IFSC Code:</label>
        <input type="text" name="ifscCode" id="ifscCode" required>
        <br>
        
        <input type="submit" value="Register">
    </form>
    
    <br>
    <a href="index.jsp">Back to Login</a>
</body>
</html>
