package controllers;

import javax.swing.*;
import java.sql.*;

public class Sql {

    private Connection connection;
    private Statement statement;

    private static Sql instance = null;

    public static Sql getInstance() {
        if (Sql.instance == null) {
            Sql.instance = new Sql();
        }
        return Sql.instance;
    }

    private Sql() {

    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezstay", "root", "access");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            // System.out.println("openConnection()");
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
