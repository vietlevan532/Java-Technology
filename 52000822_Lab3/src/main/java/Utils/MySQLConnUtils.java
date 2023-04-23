package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnUtils {
    public static Connection getConnection() {
        Connection con = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


            String url = "jdbc:mySQL://localhost:3306/Manufacture?createDatabaseIfNotExist=true";
            String url1 = "jdbc:mySQL://localhost:3306/Phone?createDatabaseIfNotExist=true";
            String username = "root";
            String password = "";

//            create Manufacture table
            con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Manufacture (\n" +
                    "    id int(9) NOT NULL AUTO_INCREMENT, \n" +
                    "    name nvarchar(50) DEFAULT NULL, \n" +
                    "    location nvarchar(10) DEFAULT NULL, \n" +
                    "    employee int(9),\n" +
                    "    PRIMARY KEY(id)\n" +
                    ")  ENGINE = InnoDB DEFAULT CHARSET = latin1";
            st.execute(sql);

//            create Phone table
            con = DriverManager.getConnection(url1, username, password);
            Statement st1 = con.createStatement();
            String sql1 = "CREATE TABLE IF NOT EXISTS Phone (\n" +
                    "    id int(9) NOT NULL AUTO_INCREMENT, \n" +
                    "    name nvarchar(50) DEFAULT NULL, \n" +
                    "    color nvarchar(20) DEFAULT NULL, \n" +
                    "    country nvarchar(50) DEFAULT NULL, \n" +
                    "    price int(9),\n" +
                    "    quantity int(9),\n" +
                    "    PRIMARY KEY(id)\n" +
                    ")  ENGINE = InnoDB DEFAULT CHARSET = latin1";
            st1.execute(sql1);

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
            System.out.println(e);
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
