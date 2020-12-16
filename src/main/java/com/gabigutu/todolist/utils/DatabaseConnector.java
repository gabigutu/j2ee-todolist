package com.gabigutu.todolist.utils;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnector {

    private static DatabaseConnector instance;
    private Connection connection;

    private DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
            connection = DriverManager.getConnection(applicationProperties.getProperty("J2EE_DB_URI"), applicationProperties.getProperties());
            this.selectDatabase();
        } catch (ClassNotFoundException exception) {
            System.err.println("ClassNotFoundException: " + exception.getMessage());
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        }
    }

    private void selectDatabase() {
        try {
            Statement statement = connection.createStatement();
            String queryString = "USE jee_database ";
            ResultSet resultSet = statement.executeQuery(queryString);
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        }
    }

    public Object selectAll(String tableName) {
//        connection.prepareStatement();
        try {
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(queryString);
            System.out.println("Executing: " + queryString);
            if (resultSet == null) throw new SQLException("SQLException: Cannot select entries from " + tableName);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                boolean done = resultSet.getBoolean("done");
                Date date = resultSet.getDate("created");
                System.out.println("Extracted " + id + ", " + title);
            }
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        }
        return null;
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }


}
