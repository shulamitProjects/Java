package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.History;
import model.LibraryWorker;

public class HistoryDao {

	public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static int registerHistory(History History) throws ClassNotFoundException{
		
     String INSERT_WORKER_SQL = "INSERT INTO history(userName,pass,address,phone)"+
     " VALUES (?,?,?,?);";
	
    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     

		int result = 0;
		//Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		try {
//		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
//		if (connection != null) {
			
//            System.out.println("Connected to the database students");
//        }
		              
//		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_SQL);
				
//		preparedStatement.setInt(1,1);
//		preparedStatement.setString(1,libraryWorker.getUserName());
//		preparedStatement.setString(2,libraryWorker.getPassword());
//		preparedStatement.setString(3,libraryWorker.getAddress());
//		preparedStatement.setString(4,libraryWorker.getPhoneNum());
		
//		System.out.println(preparedStatement);
//		result = preparedStatement.executeUpdate();
//				
//		}
//		catch(SQLException e) {
//			
//			e.printStackTrace();
//			
//		}
		return result;
				
	}
	
	
	public static List getHistoryBooks(int id,String type)throws ClassNotFoundException {
		String SQL="select idbook,idperson from history where idperson ="+id+" and type like '"+type+"'" ;
		System.out.println(SQL);
		
		List lst=new ArrayList();
		
		Statement stmt;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database books");
        }
		stmt = connection.createStatement();
	       
		ResultSet rs = stmt.executeQuery(SQL);
	

    // Iterate through the data in the result set and display it.
   
		while (rs.next()) {		
//		    System.out.println(rs.getString("name") + " - " + rs.getString("aouther"));
		    lst.add(rs.getInt("idBook"));
		    lst.add(rs.getString("idPerson"));

		}
		
		rs.close();
		stmt.close();
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		return lst;
	}
	

}

