package main.java.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientHandler implements Runnable {
    private Socket socket;
    private Connection connection; // Add this line

    public ClientHandler(Socket socket, Connection connection) { // Modify constructor
        this.socket = socket;
        this.connection = connection; // Assign connection
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                // Process the packet and log it to the database
                logConnection(socket.getInetAddress().toString());
                output.write(buffer, 0, bytesRead);
                output.flush();
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket closing error: " + e.getMessage());
            }
        }
    }

    private void logConnection(String clientAddress) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO connections (client_address) VALUES (?)")) {
            stmt.setString(1, clientAddress);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error logging connection: " + e.getMessage());
        }
    }
}