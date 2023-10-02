package jdbc;

import javax.swing.*;
import java.io.FileInputStream;
import java.sql.*;

public class InsertImageInDB {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharam","root","anappleaday.?@20");

            String q = "insert into images(pic) values (?)";
            PreparedStatement pSt = con.prepareStatement(q);

            FileInputStream fis = new FileInputStream("C:\\Users\\Ganesh\\OneDrive\\Documents\\Dharam\\JDBC\\jdbcInIntelij\\out\\production\\jdbcInIntelij\\logo.jpg"); //para -> image path (if in same folder just the name. If not in same folder specify the complete path)
            pSt.setBinaryStream(1,fis,fis.available()); // 1st para -> column no, 2nd -> FileInputStream object name, 3rd -> fis me kitne byte ka memory available h ye bata do
            pSt.executeUpdate();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
