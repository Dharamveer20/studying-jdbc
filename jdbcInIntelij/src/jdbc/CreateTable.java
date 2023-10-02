package jdbc;
import java.sql.*;
public class CreateTable {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharam","root","anappleaday.?@20");

            Statement st = con.createStatement();
            String q = "create table tabThroughJava(id int primary key,name varchar(50), salary int not null);";
            st.executeUpdate(q);
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
