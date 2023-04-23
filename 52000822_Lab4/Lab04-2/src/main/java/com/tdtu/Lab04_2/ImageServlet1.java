package com.tdtu.Lab04_2;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // File path from resources folder
        String file = "sample-image.jpg";

        // Get MIME type of the file
        String mimeType = getServletContext().getMimeType(file);
        if (mimeType == null) {
            // Set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // Modifies response
        res.setContentType(mimeType);

        // Init input & output stream
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        OutputStream out = res.getOutputStream();

        // Get image in BufferedInputStream
        BufferedInputStream bin = new BufferedInputStream(is);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        // Display image
        int ch = 0;
        while ((ch = bin.read()) != -1) {
            bout.write(ch);
        }

        // Close all classes
        bin.close();
        is.close();
        bout.close();
        out.close();
    }
}
