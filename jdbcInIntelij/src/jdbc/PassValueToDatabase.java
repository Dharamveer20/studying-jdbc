package jdbc;

import java.sql.*;
public class PassValueToDatabase {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharam","root","anappleaday.?@20");

            String q = "Insert into tabThroughJava (id, name, salary) values (?,?,?);";
            PreparedStatement prSt = con.prepareStatement(q);
            // Tuple 1;
            prSt.setInt(1,1); // para -> 1. Column no  2. Value
            prSt.setString(2, "Dhano");
            prSt.setInt(3, 50000);

            // tuple 2
            prSt.setInt(1,2);
            prSt.setString(2,"Bano");
            prSt.setInt(3, 25000);

            prSt.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
