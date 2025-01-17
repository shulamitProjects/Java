package dao;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;


public class TeacherDao {

	
	public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static int registerTeacher(Teacher teacher) throws ClassNotFoundException{
		
     String INSERT_TEACHER_SQL = "INSERT INTO teacher(id,userName,pass,address,phone)"+
     " VALUES (?,?,?,?,?);";
	
    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     

		int result = 0;
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database teacher");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_SQL);
				
		preparedStatement.setInt(1,2);
		preparedStatement.setString(2,teacher.getUserName());
		preparedStatement.setString(3,teacher.getPassword());
		preparedStatement.setString(4,teacher.getAddress());
		preparedStatement.setString(5,teacher.getPhoneNum());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
				
	}
	 
	public static boolean checkExistTeacher(Teacher teacher ) throws ClassNotFoundException {
		String SQL="select * from teacher where userName like '"+teacher.getUserName()+"' and pass like '"+teacher.getPassword()+"'" ;
		System.out.println(teacher.getUserName());
		System.out.println(teacher.getPassword());
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
	
	public static Teacher returnExistTeacher(Teacher teacher) throws ClassNotFoundException {
		String SQL="select * from teacher where userName like '"+teacher.getUserName()+"' and pass like '"+teacher.getPassword()+"'" ;
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
        	  Teacher s=new Teacher();
        	  s.setId(rs.getInt("id"));
//        	  s.setIdBook(rs.getInt("idBook"));
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
	
	
	
	public static List getListOfTeachers() throws ClassNotFoundException{
	List dataList = new ArrayList();
		
		String SQL = "select * from teacher";
    	Statement stmt;
							
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database teacher");
	        }
			stmt = connection.createStatement();
		       
			ResultSet rs = stmt.executeQuery(SQL);
		

        // Iterate through the data in the result set and display it.
       
			while (rs.next()) {
			
			    System.out.println(rs.getString("userName") + " - " + rs.getString("pass"));
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
}