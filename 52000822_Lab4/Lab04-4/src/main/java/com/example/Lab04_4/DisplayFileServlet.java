package com.example.Lab04_4.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String query = req.getParameter("path");
        System.out.println(query);
        PrintWriter out = res.getWriter();
        out.println("Hello from DisplayFileServlet");
        out.close();
    }
}
