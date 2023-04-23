package database;
//Su dung chung chung

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnUtils {
    public static Connection getConnection() {
        Connection con = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


            String url = "jdbc:mySQL://localhost:3306/ManagementProduct?createDatabaseIfNotExist=true";
            String username = "root";
            String password = "";

            con = DriverManager.getConnection(url, username, password);


            Statement st = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS PRODUCT (\n" +
                    "    id int(9) NOT NULL AUTO_INCREMENT, \n" +
                    "    name nvarchar(50) DEFAULT NULL, \n" +
                    "    price float  DEFAULT 0,\n" +
                    "    color nvarchar(10) DEFAULT NULL, \n" +
                    "    PRIMARY KEY(id)\n" +
                    ")  ENGINE = InnoDB DEFAULT CHARSET = latin1";
            st.execute(sql);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void printInfo(Connection con) {
        try {
            if (con != null) {
                System.out.println(con.getMetaData().getDatabaseProductName().toString());
                System.out.println(con.getMetaData().getDatabaseProductVersion().toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


