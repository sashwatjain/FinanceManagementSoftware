package com.fms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        ProductDAO productDAO = new ProductDAOImplementation();
        List<Product> purchasedProducts = productDAO.getProductsByUserId(user.getId());

        request.setAttribute("user", user);
        request.setAttribute("purchasedProducts", purchasedProducts);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("pay".equals(action)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            double paymentAmount = Double.parseDouble(request.getParameter("paymentAmount"));

            // Update user's balance
            user.setBalance(user.getBalance() - paymentAmount);

            // Simulate successful payment and update user's balance in the session
            session.setAttribute("user", user);
        }

        response.sendRedirect("dashboard");
    }
}
