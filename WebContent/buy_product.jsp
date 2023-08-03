<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
    <meta charset="UTF-8">
    <title>Buy Product</title>
</head>
<body>
    <h1>Buy Product</h1>
    
    <form action="BuyProductServlet" method="post">
        <label for="product">Select a Product:</label>
        <select name="product" id="product">
            <c:forEach var="product" items="${availableProducts}">
                <option value="${product.id}">${product.name} - ${product.description}</option>
            </c:forEach>
        </select>
        
        <br>
        
        <label for="emiOption">Select EMI Option:</label>
        <select name="emiOption" id="emiOption">
            <option value="3">3 months</option>
            <option value="6">6 months</option>
            <option value="9">9 months</option>
            <option value="12">12 months</option>
        </select>
        
        <br>
        
        <input type="submit" value="Buy Now">
    </form>
    
    <br>
    <a href="dashboard">Back to Dashboard</a>
</body>
</html>
