import java.util.Scanner;
import java.sql.*;

public class DBConnect {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_demo", "root", "password");
            st = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getData() {
        try {
            String query = "SELECT * FROM students";
            rs = st.executeQuery(query);
            
            System.out.println("Records From Database");
            System.out.println("ID\tFirst Name\tLast Name");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                System.out.println(id + "\t" + first_name + "\t\t" + last_name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addData(String firstName, String lastName) {
        try {
            String query = "INSERT INTO students (first_name, last_name) VALUES ('" + firstName + "', '" + lastName
                    + "')";
            st.executeUpdate(query);
            System.out.println("Record added successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateData(int id, String firstName, String lastName) {
        try {
            String query = "UPDATE students SET first_name = '" + firstName + "', last_name = '" + lastName
                    + "' WHERE id = " + id;
            st.executeUpdate(query);
            System.out.println("Record updated successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteData(int id) {
        try {
            String query = "DELETE FROM students WHERE id = " + id;
            st.executeUpdate(query);
            System.out.println("Record deleted successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnect connect = new DBConnect();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Record");
            System.out.println("2. View Records");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter First Name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter Last Name:");
                    String lastName = scanner.nextLine();
                    connect.addData(firstName, lastName);
                    break;
                case 2:
                    connect.getData();
                    break;
                case 3:
                    System.out.println("Enter ID to update:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter New First Name:");
                    String newFirstName = scanner.nextLine();
                    System.out.println("Enter New Last Name:");
                    String newLastName = scanner.nextLine();
                    connect.updateData(idToUpdate, newFirstName, newLastName);
                    break;
                case 4:
                    System.out.println("Enter ID to delete:");
                    int idToDelete = scanner.nextInt();
                    connect.deleteData(idToDelete);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
