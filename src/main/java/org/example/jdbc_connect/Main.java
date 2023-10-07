package org.example.jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        final String url = "jdbc:postgresql://217.107.219.154:49307/bonch_test";
        final String user = "bonch_test";
        final String password = "1234";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}