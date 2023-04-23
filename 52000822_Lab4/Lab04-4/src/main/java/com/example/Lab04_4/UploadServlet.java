package com.example.Lab04_4.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Display content of upload.jsp
        req.getRequestDispatcher("/upload.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");

        String fileName = "";
        boolean isOverride = false;
        String uploadsPath = getServletContext().getRealPath("/uploads") + "\\";
        String invalidExtensions[] = {"jpg", "jpeg", "png", "doc", "docx", "pdf", "rar", "zip"};
        PrintWriter out = res.getWriter();
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            File file = null;
            List<FileItem> files = servletFileUpload.parseRequest(req);
            for (FileItem f : files) {
                if (!f.isFormField()) {
                    // Get extension of the file
                    String ext = FilenameUtils.getExtension(f.getName());
                    // Check whether extension is supported or not
                    boolean isValidExt = Arrays.stream(invalidExtensions).anyMatch(e -> e.equals(ext));
                    if (!isValidExt) {
                        out.println("Unsupported file extension");
                        return;
                    }

                    // Assign extension of the file to the new file name
                    fileName = fileName.isEmpty() ? f.getName() : fileName + "." + ext;

                    // Check file already exist in the uploads folder or not
                    file = new File(uploadsPath + "\\" + fileName);
                    if (file.isFile()) {
                        continue;
                    } else {
                        // Write file to src/target/Lab04-4-1.0-SNAPSHOT/uploads/
                        f.write(file);
                    }
                } else {
                    if (f.getFieldName().equals("name")) {
                        fileName = f.getString();
                    }
                    if (f.getFieldName().equals("override")) {
                        f.write(file);
                        out.println("File has been overridden");
                        out.println(String.format("<p>File uploaded. Click <a href=\"file:///%s\">here</a> to visit the file</p>", file.getAbsolutePath()));
                        out.close();
                        return;
                    }
                }
            }

            if (file.isFile()) {
                out.println("<p>File already exists</p>");
                out.println(String.format("<p>File uploaded. Click <a href=\"file:///%s\">here</a> to visit the file</p>", file.getAbsolutePath()));
                out.close();
                return;
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("File has been uploaded");
        out.println(String.format("<p>File uploaded. Click <a href=\"file:///%s\">here</a> to visit the file</p>", file.getAbsolutePath()));
        out.close();
    }

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }
}
