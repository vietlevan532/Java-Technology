package com.tdtu.Lab04_2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");

        // Get query parameter
        String file = req.getParameter("file");
        if (file == null) {
            PrintWriter out = res.getWriter();
            out.println("File not found");
            return;
        }

        // Get input & output stream
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        OutputStream out = res.getOutputStream();

        // Get MIME type of the file
        String mimeType = getServletContext().getMimeType(file);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // Modifies response
        res.setContentType(mimeType);
        res.setContentLength(is.available());

        // Forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", file);
        res.setHeader(headerKey, headerValue);

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = is.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        is.close();
        out.close();
    }
}
