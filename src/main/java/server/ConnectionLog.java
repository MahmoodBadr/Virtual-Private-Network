package main.java.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionLog {
    private Connection connection;

    public ConnectionLog(Connection connection) {
        this.connection = connection;
    }

    public void logConnection(String clientAddress) {
        String query = "INSERT INTO connections (client_address) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, clientAddress);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error logging connection: " + e.getMessage());
        }
    }
}