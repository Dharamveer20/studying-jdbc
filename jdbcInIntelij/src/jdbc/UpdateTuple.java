package jdbc;
import java.sql.*;
import java.util.*;
public class UpdateTuple {
    public static void main(String[] args) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharam", "root", "anappleaday.?@20");
            String q = "update tabThroughJava set name = ?, salary = ? where id = ?";
            PreparedStatement pSt = cn.prepareStatement(q);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter which Id Info you want to change : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new salary: ");
            int salary = sc.nextInt();


            pSt.setString(1,name);
            pSt.setInt(2,salary);
            pSt.setInt(3,id);
            pSt.executeUpdate();
            cn.close();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
