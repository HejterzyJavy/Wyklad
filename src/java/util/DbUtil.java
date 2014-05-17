package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection connection = null;
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException e) {
                    System.out.println("Prpblem z strownikiem JDBC?");
                    e.printStackTrace();
                }
                System.out.println("\n MySQL JDBC Driver Zarejestrowany");

                try {
                    connection = DriverManager
                            .getConnection(url, user, password);

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
