package com.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) //if there is a connection already return it, otherwise establish one 
        {
            return conn;
        } else {

            try {
//EmployeeManagement    Password=strongPassw0rd
                java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(
                        // "jdbc:sqlserver://192.168.88.130:1433;databaseName=EmployeeManagement;Encrypt=False", "sa", "Passw0rd"
                        "jdbc:sqlserver://localhost:1433;databaseName=EmployeeManagement;Encrypt=False", "sa", "strongPassw0rd"
                        );

                
                System.out.println("Connected!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return conn;
        }

    }
}
