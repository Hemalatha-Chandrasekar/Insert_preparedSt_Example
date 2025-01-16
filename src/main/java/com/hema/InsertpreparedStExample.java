package com.hema;

import java.sql.*;

public class InsertpreparedStExample {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "welcome#1";

        try {
            // Establish connection
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully!");

            // Insert data
            String sqlInsert = "INSERT INTO employees (officeCode, firstName, lastName, email, extension, reportsTo, VacationHours, employeeNumber, jobTitle) VALUES (?,?,?,?,?,?,?,?,?)";
            prepStmt = con.prepareStatement(sqlInsert);
            prepStmt.setInt(1, 6);
            prepStmt.setString(2, "Jamil");
            prepStmt.setString(3, "Fink");
            prepStmt.setString(4, "JJ@gmail.com");
            prepStmt.setString(5, "2759");
            prepStmt.setInt(6, 1143);
            prepStmt.setInt(7, 9);
            prepStmt.setInt(8, 3);
            prepStmt.setString(9, "Manager");

            int affectedRows = prepStmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected!");

            // Select data
            String sqlSelect = "SELECT * FROM employees WHERE employeeNumber = ?";
            prepStmt = con.prepareStatement(sqlSelect);
            prepStmt.setInt(1, 3);

            rs = prepStmt.executeQuery();

            // Display results
            while (rs.next()) {
                System.out.println("First Name: " + rs.getString("firstName"));
                System.out.println("Last Name: " + rs.getString("lastName"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Office Code: " + rs.getString("officeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepStmt != null) prepStmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
