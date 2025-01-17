package dao;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import model.Student;


public class StudentDao {

	
	public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static int registerStudent(Student student) throws ClassNotFoundException{
		
     String INSERT_STUDENT_SQL = "INSERT INTO StudentSimple(userName,pass,address,phone)"+
     " VALUES (?,?,?,?);";
	

		int result = 0;
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database students");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
System.out.println(student.toString());
		preparedStatement.setString(1,student.getUserName());
		preparedStatement.setString(2,student.getPassword());
		preparedStatement.setString(3,student.getAddress());
		preparedStatement.setString(4,student.getPhoneNum());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
				
	}
	
	public static boolean checkExistStudent(Student student ) throws ClassNotFoundException {
		String SQL="select * from studentsimple where userName like '"+student.getUserName()+"' and pass like '"+student.getPassword()+"'" ;
		System.out.println(student.getUserName());
		System.out.println(student.getPassword());
		Statement stmt;
		
//		where userName=? and pass=?"
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
//			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(SQL);

          if(rs.next() && !rs.getString("userName").equals(null)) {
        	  return true;
          }
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("1!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return false;

}
	
	public static Student returnExistStudent(Student student) throws ClassNotFoundException {
		String SQL="select * from studentsimple where userName like '"+student.getUserName()+"' and pass like '"+student.getPassword()+"'" ;
		Statement stmt;

		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(SQL);

          if(rs.next() && !rs.getString("userName").equals(null)) {
        	  Student s=new Student();
        	  s.setId(rs.getInt("id"));
        	  s.setIdBook(rs.getInt("idBook"));
        	  s.setUserName(rs.getString("userName"));
        	  s.setPassword(rs.getString("pass"));
        	  return s;
          }
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("1!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return null;
}
	
	public static List getListOfStudents() throws ClassNotFoundException{
	List dataList = new ArrayList();
		
		String SQL = "select * from StudentSimple";
    	Statement stmt;
							
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database teachers");
	        }
			stmt = connection.createStatement();
		       
			ResultSet rs = stmt.executeQuery(SQL);
			System.out.println("rs rttttt"+rs);
		

        // Iterate through the data in the result set and display it.
       
			while (rs.next()) {
			    System.out.println(rs.getString("userName") + " - " + rs.getString("pass"));
			    dataList.add(rs.getInt("id"));
			    dataList.add(rs.getString("userName"));
			    dataList.add(rs.getString("pass"));
  
			}
			rs.close();
			stmt.close();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return dataList;
	}
	public static void deleteStudent(int idUser) throws ClassNotFoundException {
		System.out.println("aaa");
		String SQL="DELETE FROM studentsimple WHERE (id = "+idUser+")";
		System.out.println("delete"+SQL);
		
		Statement stmt;

		Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			if (connection != null) {
	            System.out.println("Connected to the database books");

			stmt = connection.createStatement();

		    stmt.executeUpdate(SQL);

			stmt.close();}

			}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 	}		
			return;
		}

}