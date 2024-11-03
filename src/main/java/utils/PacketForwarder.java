package main.java.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PacketForwarder {
    private Socket socket;

    public PacketForwarder(Socket socket) {
        this.socket = socket;
    }

    public void forwardPackets() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                // Here you would process the packet as needed
                output.write(buffer, 0, bytesRead);
                output.flush();
            }
        } catch (Exception e) {
            System.out.println("Packet forwarding error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Socket closing error: " + e.getMessage());
            }
        }
    }
}