package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

<<<<<<< HEAD
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_conges";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn;
=======
    private String url = "jdbc:mysql://localhost:3306/3a20";
    private String user = "root";
    private String password = "";
    private Connection conn;
>>>>>>> 42e9c0798d0afb05be78fba88231941ec556e699
    private static DBConnection instance;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connection established successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("✅ Connection closed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error closing connection: " + e.getMessage());
        }
    }
}
