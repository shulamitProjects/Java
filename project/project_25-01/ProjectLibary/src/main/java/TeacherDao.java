//package dao;
//import java.sql.DriverManager;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import model.Teacher;
//
//
//public class TeacherDao {
//
//	
//	public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	
//	public static int registerStudent(Teacher teacher) throws ClassNotFoundException{
//		
//     String INSERT_STUDENT_SQL = "INSERT INTO StudentSimple(id,userName,pass,address,phone)"+
//     " VALUES (?,?,?,?,?);";
//	
//    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//     
//
//		int result = 0;
//		//Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		try {
//		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","root");
//		
//		if (connection != null) {
//			
//            System.out.println("Connected to the database students");
//        }
//		              
//		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
//				
//		preparedStatement.setInt(1,1);
//		preparedStatement.setString(2,teacher.getUserName());
//		preparedStatement.setString(3,teacher.getPassword());
//		preparedStatement.setString(4,teacher.getAddress());
//		preparedStatement.setString(5,teacher.getPhoneNum());
//		
//		System.out.println(preparedStatement);
//		result = preparedStatement.executeUpdate();
//				
//		}
//		catch(SQLException e) {
//			
//			e.printStackTrace();
//			
//		}
//		return result;
//				
//	}
//	 
//	public static List getListOfStudents() throws ClassNotFoundException{
//	List dataList = new ArrayList();
//		
//		String SQL = "select * from StudentSimple";
//    	Statement stmt;
//							
//		Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			try {
//			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
//			
//			if (connection != null) {
//				
//	            System.out.println("Connected to the database students");
//	        }
//			stmt = connection.createStatement();
//		       
//			ResultSet rs = stmt.executeQuery(SQL);
//		
//
//        // Iterate through the data in the result set and display it.
//       
//			while (rs.next()) {
//			
//			    System.out.println(rs.getString("userName") + " - " + rs.getString("pass"));
//			    dataList.add(rs.getString("userName"));
//			    dataList.add(rs.getString("pass"));
//			    
//			    
//			}
//			
//			rs.close();
//			stmt.close();
//		}
//		 catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return dataList;
//	}
//}