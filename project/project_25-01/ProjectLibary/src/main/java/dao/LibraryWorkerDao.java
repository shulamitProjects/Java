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


import model.LibraryWorker;


public class LibraryWorkerDao {

	
	public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static int registerLibraryWorker(LibraryWorker libraryWorker) throws ClassNotFoundException{
		
     String INSERT_WORKER_SQL = "INSERT INTO libraryWorker(userName,pass,address,phone)"+
     " VALUES (?,?,?,?);";
	
    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     

		int result = 0;
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database students");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_SQL);
				
//		preparedStatement.setInt(1,1);
		preparedStatement.setString(1,libraryWorker.getUserName());
		preparedStatement.setString(2,libraryWorker.getPassword());
		preparedStatement.setString(3,libraryWorker.getAddress());
		preparedStatement.setString(4,libraryWorker.getPhoneNum());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
				
	}
	
	public static boolean checkExistLibraryWorker(LibraryWorker libraryWorker ) throws ClassNotFoundException {
		String SQL="select * from libraryworker where userName like '"+libraryWorker.getUserName()+"' and password like '"+libraryWorker.getPassword()+"'" ;
		System.out.println(libraryWorker.getUserName());
		System.out.println(libraryWorker.getPassword());
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
	public static List getListOfLibraryWorker() throws ClassNotFoundException{
	List dataList = new ArrayList();
		
		String SQL = "select * from StudentSimple";
    	Statement stmt;
							
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database libraryWorker");
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