package org.platform.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataSource {

    public static final String URL = "jdbc:mysql://localhost:3306/room-9";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "091451692root++12@";

    public static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                }
        } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return connection;
        }
    }
