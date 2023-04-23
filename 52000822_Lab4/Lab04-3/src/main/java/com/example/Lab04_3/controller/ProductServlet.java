package com.example.Lab04_3.controller;

import com.example.Lab04_3.model.Product;
import com.example.Lab04_3.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;


@WebServlet(urlPatterns = {"/products"}, name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductService();
    private List<Product> products;

    @Override
    public void init() throws ServletException {
        products = new ArrayList<>();
        products = productService.getProducts();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        String id = req.getParameter("id");
        if (id != null) {
            Product p = products.stream().filter(product -> product.getId() == Long.parseLong(id)).findFirst().orElse(null);
            if (p != null) {
                jsonObject.addProperty("code", 0);
                jsonObject.addProperty("message", "Read products success");
                jsonObject.add("data", gson.toJsonTree(p));
            } else {
                jsonObject.addProperty("code", -1);
                jsonObject.addProperty("message", "Products not found" + id);
            }
        } else {
            jsonObject.addProperty("code", 0);
            jsonObject.addProperty("message", "Read products success");
            jsonObject.add("data", gson.toJsonTree(products));
        }
        PrintWriter out = res.getWriter();
        out.println(jsonObject);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        String requestBody = getBody(req);

        Product newProduct = gson.fromJson(requestBody, Product.class);

        if (newProduct.getName().isEmpty() || newProduct.getPrice() == 0) {
            jsonObject.addProperty("code", -1);
            jsonObject.addProperty("message", "Name or price of product absent");
        } else {
            long newId = products.get(products.size() - 1).getId() + 1;
            newProduct.setId(newId);
            products.add(newProduct);
            jsonObject.addProperty("code", 0);
            jsonObject.addProperty("message", "Add product success");
            jsonObject.add("data", gson.toJsonTree(newProduct));
        }

        PrintWriter out = res.getWriter();
        out.println(jsonObject);
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        PrintWriter out = res.getWriter();

        String requestBody = getBody(req);
        if (requestBody.isEmpty()) {
            jsonObject.addProperty("code", -1);
            jsonObject.addProperty("message", "Not available to update");
            out.println(jsonObject);
            return;
        }

        String id = req.getParameter("id");
        if (id == null) {
            jsonObject.addProperty("code", -1);
            jsonObject.addProperty("message", "ID absent");
        } else {
            Product p = products.stream().filter(product -> product.getId() == Long.parseLong(id)).findFirst().orElse(null);
            if (p == null) {
                jsonObject.addProperty("code", -1);
                jsonObject.addProperty("message", "Product code not found" + id);
            } else {
                Product newProduct = gson.fromJson(requestBody, Product.class);
                boolean isUpdated = false;
                if (newProduct.getName() != null && !newProduct.getName().isEmpty()) {
                    System.out.println("Name updated");
                    p.setName(newProduct.getName());
                    isUpdated = true;
                }
                if (newProduct.getPrice() != 0) {
                    System.out.println("Price updated");
                    p.setPrice(newProduct.getPrice());
                    isUpdated = true;
                }

                jsonObject.addProperty("code", isUpdated ? 0 : -1);
                jsonObject.addProperty("message", isUpdated ? "Information update success" : "Not available to update");
                if (isUpdated) jsonObject.add("data", gson.toJsonTree(p));
            }
        }
        out.println(jsonObject);
        out.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        JsonObject jsonObject = new JsonObject();

        String id = req.getParameter("id");
        if (id == null) {
            jsonObject.addProperty("code", -1);
            jsonObject.addProperty("message", "ID absent");
        } else {
            Product temp = new Product();
            temp.setId(Long.parseLong(id));
            int index = products.indexOf(temp);
            if (index == -1) {
                jsonObject.addProperty("code", -1);
                jsonObject.addProperty("message", "Product not found with code " + id);
            } else {
                products.remove(index);
                jsonObject.addProperty("code", 0);
                jsonObject.addProperty("message", "Deleted");
            }
        }

        PrintWriter out = res.getWriter();
        out.println(jsonObject);
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
