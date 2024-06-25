import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBCcon {
    public static void main(String[] args) throws Exception{
        // database credentials
        String url = "jdbc:mysql://localhost:3306/oop_demo";
        String user = "root";
        String pass = "password";
        
        Connection conn = DriverManager.getConnection(url, user, pass);
        
        Statement s = conn.createStatement();
        String query =  "SELECT * FROM students";

        ResultSet rs = s.executeQuery(query);
        
        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getString("last_name"));
        }

        // inserting data using execute update
        String query2 = "INSERT INTO students(first_name, last_name) VALUES ('Myrone', 'Tipaklong')";
        s.executeUpdate(query2);

        // using preparestatement with parameters
        String query3 = "INSERT INTO students(first_name, last_name) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query3);

        ps.setString(1, "Alain");
        ps.setString(2, "Tipaklong");

        ps.executeUpdate();

        // if (conn != null){
        //     System.out.println("this is working");
        // } else {
        //     System.out.println("not working");
        // }
    }
}
