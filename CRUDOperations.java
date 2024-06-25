import java.sql.*;
import java.util.Scanner;

public class CRUDOperations {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/oop_demo";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "password";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Add Record");
                System.out.println("2. Delete Records");
                System.out.println("3. Update Record");
                System.out.println("4. View Records");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addRecord(con, scanner);
                        break;
                    case 2:
                        deleteRecords(con);
                        break;
                    case 3:
                        updateRecord(con);
                        break;
                    case 4:
                        viewRecords(con);
                        break;
                    case 5:
                        scanner.close();
                        con.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            // System.err.println("SQL Exception: " + e.getMessage());
            System.out.println(e);
        }
    }

    private static void addRecord(Connection con, Scanner scanner) throws SQLException {
        System.out.println("Enter Account Number:");
        int accNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter First Name:");
        String fName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lName = scanner.nextLine();

        String insertSQL = "INSERT INTO tableone (Accnum, Fname, Lname) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, accNum);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            int count = preparedStatement.executeUpdate();
            System.out.println(count + " row(s) inserted.");
        }
    }

    private static void deleteRecords(Connection con) throws SQLException {
        String deleteSQL = "DELETE FROM tableone WHERE Accnum > ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, 1111);
            int count = preparedStatement.executeUpdate();
            System.out.println(count + " record(s) deleted.");
        }
    }

    private static void updateRecord(Connection con) throws SQLException {
        String updateSQL = "UPDATE tableone SET Fname = ? WHERE Accnum = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, "Adonis");
            preparedStatement.setInt(2, 7777);
            int count = preparedStatement.executeUpdate();
            System.out.println(count + " record(s) updated.");
        }
    }

    private static void viewRecords(Connection con) throws SQLException {
        String selectSQL = "SELECT * FROM tableone";
        try (Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectSQL)) {
            while (rs.next()) {
                System.out.println("\nAccount No: " + rs.getInt(1));
                System.out.println("Last Name: " + rs.getString(2));
                System.out.println("First Name: " + rs.getString(3));
            }
        }
    }
}
