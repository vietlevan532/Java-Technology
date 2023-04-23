package com.javatechnology.practice.lab5.Servlet;

import com.javatechnology.practice.lab5.DAO.UserDAO;
import com.javatechnology.practice.lab5.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDAO = new UserDAO();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberPassword = req.getParameter("rememberPassword");
        try {
            User user = userDAO.findByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("User " + username + " logged in success!!");
                HttpSession session = req.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("username", user.getUsername());
                if (rememberPassword != null) {
                    Cookie userId = new Cookie("userId", String.valueOf(user.getId()));
                    userId.setMaxAge(30 * 60 * 60 * 24);
                    resp.addCookie(userId);
                }
                resp.sendRedirect("/lab5/Products");
            } else {
                System.out.println("User " + username + " failed to logged in!!");
                resp.sendRedirect("/lab5/Register");
            }
        }catch (Exception ex) {
            System.out.println("User " + username + " failed to log in!!");
            System.out.println(ex.getMessage());
            resp.sendRedirect("/lab5/Register");
        }
    }
}
