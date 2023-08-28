package controllers;

import entities.User;

import java.util.Date;

public class UserController {

    private Sql sql;

    public void registerUser(String firstName, String lastName, String email, String password, long mobile, String dob, String address) {
        Sql sql = Sql.getInstance();
        sql.openConnection();
        String query = String.format (
                "INSERT INTO users (first_name, last_name, email, password, mobile, dob, address) values ('%s', '%s', '%s', '%s', %d, '%s', '%s')",
                firstName, lastName, email, password, mobile, dob, address
        );
        sql.executeUpdate(query);
        sql.closeConnection();
    }
}
