# Virtual Private Network Client

## Overview

This VPN Project is a client-server application that allows users to connect securely to a remote server using virtual private network (VPN) technology. The project is built using Java, JavaFX for the graphical user interface, and MySQL for database management.

## Features

- **Secure Connection**: Establish a secure connection between the client and the server.
- **User Authentication**: Users can register and log in to access VPN services.
- **Modern GUI**: A visually appealing and user-friendly interface developed using JavaFX.
- **Multi-threaded Server**: Handles multiple client connections simultaneously.

## Technologies Used

- **Java**: Core programming language for server and client implementation.
- **JavaFX**: Framework for building the user interface.
- **MySQL**: Database for storing user credentials and connection logs.
- **Maven**: Dependency management and project build tool.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- JDK 11 or higher
- Maven
- MySQL Server
- JavaFX SDK

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YourUsername/Virtual-Private-Network.git
   cd Virtual-Private-Network

2. Set up your MySQL database:

Create a new database called vpn_db.

Import the SQL schema provided in the database folder (if applicable).

3. Update database connection settings in the source code:

   ```bash
   String DB_URL = "jdbc:mysql://localhost:3306/vpn_db";
   String USER = "your_username";
   String PASS = "your_password";

4. Build the project:

   ```bash
   mvn clean package

### Usage

1. Open the client application.
2. Enter the server address (e.g., localhost or the server's IP address).
3. Click the "Connect" button to establish a connection.

