package com.si.database;

import java.sql.*;

/**
 * Created by Saranda Ilazi on 19/09/2016.
 */
public class DBConnection {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/atm-java";

    //  Database credentials
    private static final String username = "root";
    private static final String password = "";

    public Connection dbConnection = null;

    public DBConnection() {
        connectDB();
    }

    private boolean connectDB() {
        try {
            // Register JDBC driver
            Class.forName(driver);
            // Open a dbConnection
            dbConnection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException cn) {
            System.out.println("Problem with driver\n" + cn.getMessage());
            return false;
        } catch (SQLException sq) {
            System.out.println("Problem to connect in db\n" + sq.getMessage());
            return false;
        }
        return true;
    }
}
