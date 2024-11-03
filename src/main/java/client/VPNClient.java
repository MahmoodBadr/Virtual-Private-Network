package main.java.client;

import java.io.*;
import java.net.*;

public class VPNClient {
    private static final String SERVER_ADDRESS = "localhost"; // Change to your server address
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            System.out.println("Connected to VPN Server");

            // Example data to send to the server
            String message = "Hello from VPN Client";
            output.write(message.getBytes());
            output.flush();

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead != -1) {
                System.out.println("Received from server: " + new String(buffer, 0, bytesRead));
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}