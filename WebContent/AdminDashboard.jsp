<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.fms.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Admin Dashboard</h1>
    </header>
    <nav>
        <a href="admindashboard.jsp">Dashboard</a>
        <a href="adminuserapproval.jsp">User Approval</a>
        <!-- Add more navigation links as needed -->
    </nav>
    <div class="container">
        <div class="dashboard">
            <h2>Welcome, Admin!</h2>
            <h3>Recently Registered Users</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the list of users and display their information -->
                    <% for (User user : userList) { %>
                        <tr>
                            <td><%= user.getId() %></td>
                            <td><%= user.getName() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getUsername() %></td>
                            <td><a href="AdminUserApprovalServlet?id=<%= user.getId() %>">Approve</a></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <footer>
        <p>&copy; 2023 Your Company. All rights reserved.</p>
    </footer>
</body>
</html>
