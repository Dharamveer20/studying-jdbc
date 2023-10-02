package jdbc;

import java.sql.*;
import java.util.*;
public class PassDynamicValueToDatabase {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharam","root","anappleaday.?@20");

            String q = "insert into tabThroughJava (id,name,salary) values(?,?,?);";
            PreparedStatement pSt = con.prepareStatement(q);

            Scanner sc = new Scanner(System.in);
            int i,id,salary;
            String name;
            while(true) {
                System.out.println("Press: 1. Insert, 2. No more Insertion");
                i = sc.nextInt();
                if (i != 1) break;
                else if (i == 1) {
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    sc.nextLine(); // why written this? Explaination below
                    // Assume we enter sc.nextInt = 1 and tap enter mtlb 1\n hamne input diya and 1 chala jayega id ke paas but \n reh jayega (in the buffer meomory). ab agar name = sc.nexInt direct kiya to \n jo bacha hua tha vo chala jayega name ko and name user se le hi nhi payenge. Therefore to avoid this we wrote this taaki \n ye khaa jaye.

                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    salary = sc.nextInt();

                    pSt.setInt(1, id);
                    pSt.setString(2,name);
                    pSt.setInt(3, salary);

                    pSt.executeUpdate();
                }
            }
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static class Main {

        public static void main(String[] args) {
            // JDBC connection parameters

            try {
                // Step 1: Load the JDBC driver (Not neccessary after MySQL version 8)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Step 2: Establish a connection
                String jdbcUrl = "jdbc:mysql://localhost:3306/dharam"; // Replace with your database URL
                String username = "root";
                String password = "anappleaday.?@20";
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

                // Step 3: Create a statement
                Statement statement = connection.createStatement();

                // Step 4: Execute a query
                String sqlQuery = "SELECT * FROM department";
                ResultSet resultSet = statement.executeQuery(sqlQuery); // It stores the mentioned table.

                // Step 5: Process the ResultSet
                while (resultSet.next()) { //.next() -> used to move to the next row of data in a result set
                    int dNo = resultSet.getInt("Dno"); // here we can either pass column name or column no
                    String dName = resultSet.getString("Dname");// here we can either pass column name or column no

                    // Print the retrieved data
                    System.out.println("ID: " + dNo + ", Name: " + dName);
                }

                // Step 6: Close resources
                resultSet.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
