package com.fms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finance_management";
    private static final String DB_USER = "root@localhost";
    private static final String DB_PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String cardType = request.getParameter("cardType");
        String bank = request.getParameter("bank");
        String accountNumber = request.getParameter("accountNumber");
        String ifscCode = request.getParameter("ifscCode");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establish the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement
            String sql = "INSERT INTO users (name, phone, email, username, password, address, card_type, bank, account_number, ifsc_code) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, address);
            stmt.setString(7, cardType);
            stmt.setString(8, bank);
            stmt.setString(9, accountNumber);
            stmt.setString(10, ifscCode);

            // Execute the SQL statement
            stmt.executeUpdate();

            response.sendRedirect("success.jsp"); // Redirect to a success page
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception, maybe redirect to an error page
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
