package com.javatechnology.practice.lab5.Servlet;

import com.javatechnology.practice.lab5.DAO.UserDAO;
import com.javatechnology.practice.lab5.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    private final UserDAO userDAO;

    public Register(UserDAO userDAO) {
        this.userDAO = userDAO;
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
        req.getRequestDispatcher("/view.register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        try {
            User user = new User(username, email, password);
            userDAO.add(user);
            System.out.println("User " + username + " success registered!!!");
            resp.sendRedirect("/lab5/Login");
        }catch (Exception ex) {
            System.out.println("Failed to register!!");
            System.out.println(ex.getMessage());
        }
    }
}
