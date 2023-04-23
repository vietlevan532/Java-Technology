package com.javatechnology.practice.lab5.Servlet;

import com.javatechnology.practice.lab5.DAO.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Products")
public class Product extends HttpServlet {

    private final ProductDAO productDAO;

    public Product(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<com.javatechnology.practice.lab5.Model.Product> products = productDAO.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/view/products.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if ("delete".equals(req.getParameter("action"))) {
            Long productId = Long.valueOf(req.getParameter("productId"));
            productDAO.removeByID(productId);
            resp.sendRedirect("/Lab5/Products");
            return;
        }
        resp.setContentType("text/html");
        String productName = req.getParameter("productName");
        String productPrice = req.getParameter("productPrice");
        try {
            com.javatechnology
                    .practice
                    .lab5
                    .Model
                    .Product product = new com.javatechnology
                    .practice
                    .lab5
                    .Model
                    .Product(productName, Double.valueOf(productPrice));
            productDAO.add(product);
            System.out.println("Product " + productName + " is success added!!!");
            resp.sendRedirect("/lab5/Products");
        }catch (Exception ex) {
            System.out.println("Failed to add a product!!");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}