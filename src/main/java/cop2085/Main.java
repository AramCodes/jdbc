package cop2085;

import java.sql.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cop2805");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Employees");

            while (results.next()) {
                int employeeId = results.getInt("employeeId");
                String employeeName = results.getString("firstName") + " " + results.getString("lastName");
                System.out.println( employeeId + " " + employeeName);
            }

            connection.close();

        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }


    }
}
