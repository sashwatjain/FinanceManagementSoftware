<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
    <meta charset="UTF-8">
    <title>User Dashboard</title>
</head>
<body>
    <h1>Welcome to Your Dashboard, ${user.name}!</h1>
    
    <p>Card Number: ${user.cardNumber}</p>
    <p>Card Type: ${user.cardType}</p>
    <p>Remaining Balance: ${user.balance}</p>
    
    <h2>Purchased Products</h2>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Cost</th>
        </tr>
        <c:forEach var="product" items="${purchasedProducts}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.cost}</td>
            </tr>
        </c:forEach>
    </table>
    
    <br>
    <a href="buy_product.jsp">Buy New Product</a>
    <br>
    <a href="index.jsp">Logout</a>
</body>
</html>
