package com.tdtu.Lab04_2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String file = "sample-image.jpg";

        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        OutputStream out = res.getOutputStream();

        String mimeType = getServletContext().getMimeType(file);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        res.setContentType(mimeType);
        res.setContentLength(is.available());

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
