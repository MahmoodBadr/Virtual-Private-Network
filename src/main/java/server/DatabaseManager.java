package main.java.server;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        connect();
    }

    private void connect() {
        try {
            String url = "jdbc:mysql://db:3306/vpn_db"; // 'db' is the service name in Docker
            String user = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, user, password);
            initializeDatabase();
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    private void initializeDatabase() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS connections (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "client_address VARCHAR(255) NOT NULL, " +
                    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }
}