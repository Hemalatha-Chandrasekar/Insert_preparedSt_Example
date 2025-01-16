package com.hema;
import java.sql.*;

public class Update_preparedSt_Example {
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

            // Update data
            String sqlUpdate = "UPDATE employees SET firstName = ?, lastName = ? WHERE employeeNumber = ?";
            prepStmt = con.prepareStatement(sqlUpdate);
            prepStmt.setString(1, "Gary");
            prepStmt.setString(2, "Larson");
            prepStmt.setInt(3, 3);

            int rowsAffected = prepStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected!");

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