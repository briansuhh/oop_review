import java.sql.*;

public class MySQLConnectionExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/oop_demo";
        String username = "root";
        String password = "password";

        Connection connection = null;

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed!");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}