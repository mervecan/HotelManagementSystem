package hotelmanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class DAL {
	
	
	   public static Connection getConnection() throws SQLException{
		  Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagement?useSSL=false","root","Turkan*94");
	      return myConn;
	   }
	  public void searchToStatus() throws SQLException{
		 
		  Connection conn=getConnection();
		  Statement stmt=conn.createStatement();
		  ResultSet rs=stmt.executeQuery("SELECT no,type,capacity FROM Room WHERE status = 'Empty' ");
		 
		  while (rs.next()) {
				String no = rs.getString("no");
				String type = rs.getString("type");
				String capacity = rs.getString("capacity");
				System.out.println("NO: " + no + ", TYPE: " + type
						+ ", CAPACITY: " + capacity);
			}
		  conn.close();
		  rs.close();
	  }
	     
      /* public void addingEmployee(){
    	   Employee emp=new Employee();
    	  
    	   System.out.println("enter SSN");
    	   Scanner input=new Scanner(System.in);
    	   emp.SSN=input.nextInt();
    	   
    	   System.out.println("enter employee name");
    	   Scanner input1=new Scanner(System.in);
    	   emp.empName=input1.nextLine();
    	   
    	   System.out.println("enter gender");
    	   Scanner input2=new Scanner(System.in);
    	   emp.empGender=input2.nextLine();
    	   
    	   System.out.println("enter age");
    	   Scanner input3=new Scanner(System.in);
    	   emp.empAge=input3.nextInt();
    	   
    	   System.out.println("enter hiredate");
    	   Scanner input4=new Scanner(System.in);
    	   emp.empHireDate=input4.nextLine();
    	   
    	   System.out.println("enter salary");
    	   Scanner input5=new Scanner(System.in);
    	   emp.empSalary=input5.nextDouble();
    	   input.close();
    	   input1.close();
    	   input2.close();
    	   input3.close();
    	   input4.close();
    	   input5.close();
    	  
    	   try{
    		  Connection myCon=getConnection();
    		  PreparedStatement ps=myCon.prepareStatement("INSERT INTO Employee(id,SSN,name,gender,age,hiredate,salary) VALUES(?,?,?,?,?,?,?)");
    		  ps.setInt(1, emp.empId);
    		  ps.setInt(2, emp.SSN);
    		  ps.setString(3, emp.empName);
    		  ps.setString(4, emp.empGender);
    		  ps.setInt(5, emp.empAge);
    		  ps.setString(6,  emp.empHireDate);
    		  ps.setDouble(7, emp.empSalary);
    		   
    		  ps.executeUpdate();
    		  System.out.println("successful");
    		  
    		  myCon.close();
    		  ps.close();
    		  
    	   }
    	   catch(Exception e ){
    		   System.out.println(e);
    	   }
    	
       }
       public void removeEmployee(){};
       public void addingGuest(){
    	   Guest guest=new Guest();
    	   System.out.println("enter SSN");
    	   Scanner input=new Scanner(System.in);
    	   guest.SSN=input.nextInt();
    	   
    	   System.out.println("enter  name");
    	   Scanner input1=new Scanner(System.in);
    	   guest.name=input1.nextLine();
    	   
    	   System.out.println("enter gender");
    	   Scanner input2=new Scanner(System.in);
    	   guest.gender=input2.nextLine();
    	   
    	   System.out.println("enter phone");
    	   Scanner input3=new Scanner(System.in);
    	   guest.phone=input3.nextLine();
    	   
    	   System.out.println("enter age");
    	   Scanner input4=new Scanner(System.in);
    	   guest.age=input4.nextInt();
    	   
    	   input.close();
    	   input1.close();
    	   input2.close();
    	   input3.close();
    	   input4.close();
    	   
    	   try{
     		  Connection myCon=getConnection();
     		  PreparedStatement ps=myCon.prepareStatement("INSERT INTO Guest(id,SSN,name,gender,phone,age) VALUES(?,?,?,?,?,?)");
     		  ps.setInt(1, guest.guestId);
     		  ps.setInt(2, guest.SSN);
     		  ps.setString(3, guest.name);
     		  ps.setString(4, guest.gender);
     		  ps.setString(5, guest.phone);
     		  ps.setInt(6, guest.age);
     		  
     		   
     		  ps.executeUpdate();
     		  System.out.println("successful");
     		  
     		  myCon.close();
     		  ps.close();
     		  
     	   }
     	   catch(Exception e ){
     		   System.out.println(e);
     	   }
    	  
       }*/
       
}
