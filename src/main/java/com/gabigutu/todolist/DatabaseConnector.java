package com.gabigutu.todolist;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DatabaseConnector {

    private static DatabaseConnector instance;
    private Connection connection;

    private DatabaseConnector() {
        try {
//            Context ctx = new InitialContext();
//            DataSource dataSource = (DataSource) ctx.lookup("jdbc:mysql://127.0.0.1:3306/jee_database");
//            connection = dataSource.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jee_database?" +
                    "user=root&password=root");
        } catch (ClassNotFoundException exception) {
            System.err.println("ClassNotFoundException: " + exception.getMessage());
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        }
    }

    public Object selectAll(String tableName) {
//        connection.prepareStatement();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            if (resultSet == null) throw new SQLException("SQLException: Cannot select entries from " + tableName);
            do {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                boolean done = resultSet.getBoolean("done");
                Date date = resultSet.getDate("date_time");
                System.out.println("Extracted " + id + ", " + title);
            } while (resultSet.next());
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
