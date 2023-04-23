package dao;

import database.MySQLConnUtils;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Repository<Product, Integer> {

    @Override
    public Integer add(Product t) {
        // TODO Auto-generated method stub
        int ketqua;
        try {

            Connection connection = MySQLConnUtils.getConnection();

            String sql = "INSERT INTO product( name, price, color)"
                    + "VALUES(?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, t.name);
            pst.setFloat(2, t.price);
            pst.setString(3, t.color);

            ketqua = pst.executeUpdate();
            System.out.println("Add successful " + sql);
            System.out.println("Product add " + ketqua);

            MySQLConnUtils.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }

        return ketqua;
    }

    @Override
    public List<Product> readAll() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.id = resultSet.getInt("id");
                product.name = resultSet.getString("name");
                product.color = resultSet.getString("color");
                product.price = resultSet.getFloat("price");
                products.add(product);
            }
            MySQLConnUtils.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            String sql = "SELECT * FROM product WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.id = resultSet.getInt("id");
                product.name = resultSet.getString("name");
                product.color = resultSet.getString("color");
                product.price = resultSet.getFloat("price");
            }
            MySQLConnUtils.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public boolean update(Product item) {
        if (read(item.id) == null) {
            return false;
        }
        try {
            Connection connection = MySQLConnUtils.getConnection();

            String sql = "UPDATE product SET name=?, price=?, color=? WHERE id=?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, item.name);
            ptm.setFloat(2, item.price);
            ptm.setString(3, item.color);

            ptm.setInt(4, item.id);

            ptm.execute();

            MySQLConnUtils.closeConnection(connection);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            Connection connection = MySQLConnUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();

            System.out.println("Bạn đã thực thi : " + pst.toString());
            System.out.println("So dong vua xoa : " + rowsAffected);

            MySQLConnUtils.closeConnection(connection);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }
}
