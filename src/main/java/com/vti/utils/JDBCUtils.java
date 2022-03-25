package com.vti.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private Properties properties;
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/database.properties"));

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");

            // Step 1* register the driver class with DriverManager
            Class.forName(driver);

            // Step 2: get a Database Connection

            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}
