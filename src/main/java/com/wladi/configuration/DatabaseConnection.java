package com.wladi.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private Connection connection;

    public DatabaseConnection(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }

}