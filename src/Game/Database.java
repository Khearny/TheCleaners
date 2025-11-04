package Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    
    private static final String DB_URL = "jdbc:derby:" + System.getProperty("user.home") + "/gameDB;create=true";
    
    // Initialize the database and create tables if they don't exist
    public static void init() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("✅ Derby driver loaded");

            try (Connection conn = DriverManager.getConnection(DB_URL);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(
                    "CREATE TABLE users (" +
                    "username VARCHAR(50) PRIMARY KEY, " +
                    "password VARCHAR(50))"
                );
                System.out.println("✅ users table created");
            } catch (SQLException e) {
                if (!"X0Y32".equals(e.getSQLState())) { 
                    e.printStackTrace();
                } else {
                    System.out.println("ℹ️ users table already exists");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Return a fresh connection for each call
    public static Connection getConnection() throws SQLException {
        System.out.println("🔹 Database.getConnection() çağrıldı");
        Connection conn = DriverManager.getConnection(DB_URL);
        System.out.println("✅ Connection alındı");
        return conn;
    }

}
