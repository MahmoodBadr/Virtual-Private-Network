package main.java.client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VPNClientGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f4f4f4;");

        // Create a text field for entering the server address
        TextField serverAddressField = new TextField();
        serverAddressField.setPromptText("Enter server address");
        serverAddressField.setStyle("-fx-background-color: white; -fx-border-color: #ccc; -fx-font-size: 14px;");

        // Create the connect button
        Button connectButton = new Button("Connect");
        connectButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px;");
        
        // Connect button action
        connectButton.setOnAction(event -> {
            String serverAddress = serverAddressField.getText();
            if (serverAddress.isEmpty()) {
                System.out.println("Please enter a server address.");
            } else {
                // Handle the connection logic here
                System.out.println("Connecting to server: " + serverAddress);
            }
        });

        // Add the components to the layout
        vbox.getChildren().addAll(serverAddressField, connectButton);

        // Create and set the scene
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Modern VPN Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}