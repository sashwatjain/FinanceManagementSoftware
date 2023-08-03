package com.fms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buy-product")
public class BuyProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAOImplementation productDAO = new ProductDAOImplementation();
        List<Product> products = productDAO.getAllProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher("buy_product.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int productId = Integer.parseInt(request.getParameter("product"));
        String emiOption = request.getParameter("emiOption");

        // Implement the logic to process the purchase
        ProductDAOImplementation productDAO = new ProductDAOImplementation();
        Product selectedProduct = productDAO.getProductById(productId);

        double totalCost = selectedProduct.getCost();
        int emiPeriod = Integer.parseInt(emiOption);

        double emiAmount = totalCost / emiPeriod;

        // Update user's balance or perform necessary actions based on your project's logic
        user.setBalance(user.getBalance() - emiAmount);

        // Once the purchase is complete, you can redirect the user to their dashboard
        response.sendRedirect("dashboard");
    }

}
