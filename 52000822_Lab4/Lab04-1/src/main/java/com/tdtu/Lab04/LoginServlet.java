package com.tdtu.Lab04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    Map<String, String> accounts;

    @Override
    public void init() throws ServletException {
        accounts = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            accounts.put("username" + (i + 1), "123456");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = res.getWriter();
        if (isValidUser(username, password)) {
            out.println("<b>Name/Password match</b>");
        } else {
            out.println("<b>Name/Password does not match</b>");
        }

    }

    private boolean isValidUser(String username, String password) {
        if (!accounts.containsKey(username)) return false;
        return accounts.get(username).equals(password);
    }
}
