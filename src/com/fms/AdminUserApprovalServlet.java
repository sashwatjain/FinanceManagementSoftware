package com.fms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUserApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        
        // Call your UserDAO method to approve the user
        UserDAO userDAO = new UserDAOImplementation(); // Replace with your implementation
        userDAO.approveUser(userId);
        List<User> userList = userDAO.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("admindashboard.jsp").forward(request, response);
        // Redirect back to the admin dashboard
        response.sendRedirect("admin_dashboard.jsp");
    }
}
