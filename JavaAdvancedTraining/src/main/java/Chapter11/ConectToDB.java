package Chapter11;

import java.sql.*;

public class ConectToDB {
    public static void main(String[] args) {
        String strConnection = "jdbc:sqlserver://DESKTOP-FQLSSQR:1433;databaseName=Northwind;integratedSecurity=true;";

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            Connection myConnection = DriverManager.getConnection(strConnection);

            // Create statement and execute query
            Statement stm = myConnection.createStatement();
            String cmdSelect = "SELECT * FROM Employees";
            ResultSet results = stm.executeQuery(cmdSelect);

            // Move cursor and read results
            while (results.next()) {
                String lastname = results.getString("LastName");
                System.out.println(lastname);
            }

            // Close connection
            myConnection.close();
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        }
    }
}