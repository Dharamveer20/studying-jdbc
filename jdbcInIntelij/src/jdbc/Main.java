package jdbc;
import java.sql.*;
public class Main {
    public static void main(String[] args){

        try {
            // Step 1: Load the JDBC driver (Not neccessary after MySQL version 8)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            String jdbcUrl = "jdbc:mysql://localhost:3306/dharam"; // dharam is the name of database. We can enter your desired database present in MySQL
            String username = "root";
            String password = "anappleaday.?@20";
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3: Create a statement/preparedStatement ya something which is needed.
            Statement statement = connection.createStatement();

            // Step 4: Execute a query. Execution part me CRUDE operation perform kr sakte h.

            // Step 5: Close resources
//                    resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

