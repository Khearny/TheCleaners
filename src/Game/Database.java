package Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    
    private static final String DB_URL = "jdbc:derby:gameDB;create=true";

    // Initialize the database and create tables if they don't exist
    public static void init() {
        try {
            // Load Derby embedded driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            try (Connection conn = DriverManager.getConnection(DB_URL);
                 Statement stmt = conn.createStatement()) {

                // Create user table if it doesn't exist
                stmt.executeUpdate(
                    "CREATE TABLE users (" +
                    "username VARCHAR(50) PRIMARY KEY, " +
                    "password VARCHAR(50))"
                );
                System.out.println("User table created or already exists.");
            } catch (SQLException e) {
                // Table already exists — SQLState X0Y32 for Derby
                if (!"X0Y32".equals(e.getSQLState())) {
                    e.printStackTrace();
                } else {
                    System.out.println("User table already exists.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Derby driver not found!");
            e.printStackTrace();
        }
    }

    // Return a fresh connection for each call
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

}
