package main.java.server;

import java.io.IOException; // Required for IOException
import java.net.ServerSocket; // Required for ServerSocket
import java.net.Socket; // Required for Socket
import java.sql.Connection; // Required for Connection
import java.sql.DriverManager; // Required for DriverManager
import java.sql.SQLException; // Required for SQLException

public class VPNServer {
    private ServerSocket serverSocket;
    private Connection connection;

    // Constructor accepting port and connection
    public VPNServer(int port, Connection connection) {
        this.connection = connection; // Store the database connection
        try {
            serverSocket = new ServerSocket(port); // Initialize the server socket
            System.out.println("Server started on port: " + port);
        } catch (IOException e) {
            System.out.println("Error setting up server socket: " + e.getMessage());
        }
    }

    // Method to start the server
    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                // Correctly instantiate ClientHandler with both parameters
                ClientHandler clientHandler = new ClientHandler(clientSocket, connection);
                new Thread(clientHandler).start(); // Start a new thread for the client
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    // Main method to start the server
    public static void main(String[] args) {
        Connection connection = null; // Initialize the connection variable
        try {
            // Establish the connection
            String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase"; // Update with your database details
            String USER = "yourusername"; // Update with your username
            String PASS = "yourpassword"; // Update with your password
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return; // Exit if the connection fails
        }

        // Create the VPNServer instance with the desired port
        VPNServer server = new VPNServer(12345, connection);
        server.start(); // Start the server

        // Ensure connection is closed when the server stops (not reached in infinite loop)
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}