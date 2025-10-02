package task7;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        sp3();
    }

    public static void readrecords() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "root@123";
        String query = "select * from employee";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();
        ResultSet set = stat.executeQuery(query);
        while (set.next()) {
            System.out.println("id is" + set.getInt(1));
            System.out.println("name is " + set.getString(2));
            System.out.println("salary is " + set.getInt(3));
        }
        con.close();

    }

    public static void insertrecords() throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "root@123";
        String query = "insert into employee values (3,'Nawin',50000)";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();
        int rows = stat.executeUpdate(query);

        System.out.println("No of rows affected:" + " " + rows);
        con.close();

    }


    public static void insertvar() throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "root@123";
        int id = 4;
        String name = "Ramprasath";
        int salary = 50000;
        String query = "insert into employee values (" + id + ",'" + name + "'," + salary + " )";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();
        int rows = stat.executeUpdate(query);

        System.out.println("No of rows affected:" + " " + rows);
        con.close();

    }

    public static void insertpst() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    String query ="insert into employee values (?,?,?);";
    int id= 5;
    String name ="Raju";
    int salary = 20000;
    Connection con = DriverManager.getConnection(url, username, password);
    PreparedStatement prep= con.prepareStatement(query);
    prep.setInt(1,id);
    prep.setString(2,name);
    prep.setInt(3,salary);
    int rows = prep.executeUpdate();

        System.out.println("No of rows affected:"+" "+rows);
        con.close();
}

public static void deletequery() throws Exception{

    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    int id =5;
    String query = "Delete from employee where emp_id="+id;
    Connection con = DriverManager.getConnection(url, username, password);
    Statement stat = con.createStatement();
    int rows = stat.executeUpdate(query);

    System.out.println("No of rows affected:" + " " + rows);
    con.close();

}
public static void updatequery() throws Exception{
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    String query = "update employee set salary=20000 where emp_id=1";
    Connection con = DriverManager.getConnection(url, username, password);
    Statement stat = con.createStatement();
    int rows = stat.executeUpdate(query);

    System.out.println("No of rows affected:" + " " + rows);
    con.close();
}

public static  void sp() throws Exception{
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    Connection con = DriverManager.getConnection(url,username,password);
   CallableStatement cst= con.prepareCall("{call getemp()}");
   ResultSet set = cst.executeQuery();
   while(set.next()){
       System.out.println("Id is"+set.getInt(1));
       System.out.println("name is "+set.getString(2));
       System.out.println("salary is "+set.getInt(3));
   }

   con.close();
}

public static void sp2() throws Exception {
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    int id =2;
    Connection con = DriverManager.getConnection(url,username,password);
    CallableStatement cst= con.prepareCall("{call getempbyid(?)}");
    cst.setInt(1,id);
    ResultSet set = cst.executeQuery();

    con.close();

}
public static void sp3() throws Exception{
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String password = "root@123";
    int id =3;
    Connection con = DriverManager.getConnection(url,username,password);
    CallableStatement cst= con.prepareCall("{call getnamebyid(?,?)}");
    cst.setInt(1,id);
    cst.registerOutParameter(2,Types.VARCHAR);
    cst.executeUpdate();

    con.close();

}
 public static void commitdemo() throws Exception{
     String url = "jdbc:mysql://localhost:3306/jdbcdemo";
     String username = "root";
     String password = "root@123";
     String query1 = "update employee set salary=60000 where emp_id=1";
     String query2="update employee set salary = 70000 where emp_id=2";
     Connection con = DriverManager.getConnection(url,username,password);
     con.setAutoCommit(false);
     Statement st = con.createStatement();
     int rows1=st.executeUpdate(query1);
     System.out.println("Rows affected"+" "+rows1);
     int rows2=st.executeUpdate(query2);
     System.out.println("Rows affected"+" "+rows2);
     if(rows1>0&&rows2>0){
         con.commit();
     }

 }
 public static void rollback() throws Exception{

     String url = "jdbc:mysql://localhost:3306/jdbcdemo";
     String username = "root";
     String password = "root@123";
     String query1 = "update employee set salary=60000 where emp_id=1";
     String query2="update employee set salary = 70000 where emp_id=2";
     String query3 ="update employee set salary=80000 where emp_id=3";
     Connection con = DriverManager.getConnection(url,username,password);
     con.setAutoCommit(false);
     Statement st = con.createStatement();
     st.addBatch(query1);
     st.addBatch(query2);
     st.addBatch(query3);
     int[]res=st.executeBatch();
     for(int i :res){
         if(i>0){
             continue;
         }
         else{
             con.rollback();
         }
     }
     con.commit();
     con.close();
    }
}
    