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
import model.Book;
import model.History;
import model.Student;

public class BorrowDao {
		public static String CONNECTION_STR = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		public static int registerBook(Book book) throws ClassNotFoundException{
		System.out.println("book"+book);
	     String INSERT_STUDENT_SQL = "INSERT INTO Books(idbook,idperson,takendate,returndate)"+
	     " VALUES (?,?,?,?,?);";
		
	    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	     
	     	
			int result = 0;
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database books");
	        }
			              
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);

			preparedStatement.setString(1,book.getAouther());
			preparedStatement.setString(2,book.getName());
			preparedStatement.setString(3,book.getIsBorrow());

			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
					
			}
			catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			return result;
					
		}
		
		public static Book findBook(int idBook) throws ClassNotFoundException {
			System.out.println("aaa"+idBook);
			String SQL="select * from Books where idBook = "+idBook+"";
			
			Book b=new Book();
			System.out.println("!!!!!!!"+SQL);
	    	Statement stmt;			
			Class.forName("com.mysql.cj.jdbc.Driver");
				try {
				Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");

				if (connection != null) {
		            System.out.println("Connected to the database books");
		        }
				stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(SQL);
					while(rs.next()) {
				    b.setName(rs.getString("name"));
				    b.setAouther(rs.getString("aouther"));
				    b.setIsBorrow(rs.getString("isBorrow")); 
				    b.setIdBook(rs.getInt("idBook"));
				    b.setIdBorrow(rs.getInt("idBorrow"));
				    System.out.println(b);}
				rs.close();
				stmt.close();

			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return b;
		}

		public static void returnBook(int idBook,int idUser) throws ClassNotFoundException, SQLException {

			
				Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");

	
				
				String SQL="UPDATE Books SET idBorrow= 0 WHERE (idBook = "+idBook+");";
				System.out.println("SQL "+SQL);
				String SQL2="UPDATE Books SET isBorrow='false' WHERE (idBook = "+idBook+");";
				System.out.println("SQL2 "+SQL2);
//				String SQL3="UPDATE studentsimple SET idBook= 0 WHERE (id = "+idUser+");";
//				System.out.println("SQL3 "+SQL3);
				Statement stmt;
				Statement stmt2;
//				Statement stmt3;
				System.out.println("1");
				Class.forName("com.mysql.cj.jdbc.Driver");
					try {
					Connection connection2 = DriverManager.getConnection(CONNECTION_STR,"root","1234");
					System.out.println("2");
					if (connection != null) {
			            System.out.println("Connected to the database books");
			            System.out.println("3");
			        }
					System.out.println("4");
					stmt = connection.createStatement();
					stmt2 = connection.createStatement();
//					stmt3 = connection.createStatement();
					stmt2.executeUpdate(SQL2);
				    stmt.executeUpdate(SQL);
					
//  					stmt3.executeUpdate(SQL3);
						
					stmt.close();
					stmt2.close();
//					stmt3.close();
					

			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		
					return;
		}
		

		public static void takeBook(int idBook,int idUser,String s) throws ClassNotFoundException, SQLException {

			
				Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
				
				String SQL="UPDATE Books SET idBorrow ="+idUser+" WHERE (idBook = "+idBook+");";
				System.out.println("SQL "+SQL);
				String SQL2="UPDATE Books SET isBorrow='true' WHERE (idBook = "+idBook+");";
				System.out.println("SQL2 "+SQL2);
				
//				History h=new History();		
//				String SQL3="UPDATE studentsimple SET idBook="+idBook+" WHERE (id = "+idUser+");";
//				System.out.println("SQL3 "+SQL3);
				Statement stmt;
				Statement stmt2;
//				Statement stmt3;
				System.out.println("1");
				Class.forName("com.mysql.cj.jdbc.Driver");
					try {
					Connection connection2 = DriverManager.getConnection(CONNECTION_STR,"root","1234");
					System.out.println("2");
					if (connection != null) {
			            System.out.println("Connected to the database books");
//			            System.out.println("3");
			        }
					System.out.println("4");
					stmt = connection.createStatement();
					stmt2 = connection.createStatement();
//					stmt3 = connection.createStatement();
					stmt2.executeUpdate(SQL2);
				    stmt.executeUpdate(SQL);
				    addToHistory(idBook,idUser,s);

					
	
//  				stmt3.executeUpdate(SQL3);
						
					stmt.close();
					stmt2.close();
//					stmt3.close();
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
					return;
		}
		private static int addToHistory(int idBook, int idUser,String s) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			String SQL3 = "INSERT INTO history(idBook,idPerson,type)"+" VALUES (?,?,?);";
	
				int result = 0;

				Class.forName("com.mysql.cj.jdbc.Driver");
				
				try {
				Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
				
				if (connection != null) {
					
		            System.out.println("Connected to the database books");
		        }
				              
				PreparedStatement preparedStatement = connection.prepareStatement(SQL3);

				preparedStatement.setInt(1,idBook);
				preparedStatement.setInt(2,idUser);
				preparedStatement.setString(3,s);
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();		
				}
				catch(SQLException e) {
					
					e.printStackTrace();	
				}
				return result;
		}

		public static List getListOfBooks() throws ClassNotFoundException{
		List dataList = new ArrayList();
			
			String SQL = "select * from books where isBorrow='false'";
			System.out.println("!!!!!!!"+SQL);
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
				    System.out.println(rs.getString("name") + " - " + rs.getString("aouther"));
				    dataList.add(rs.getInt("idBook"));
				    dataList.add(rs.getString("name"));
				    dataList.add(rs.getString("aouther"));
				    dataList.add(rs.getString("isBorrow")); 
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
	
public static List getMyBooks(int idUser) throws ClassNotFoundException{
		List b=new ArrayList();

		String find = "select * from books where idBorrow="+idUser;
		System.out.println("!!!!!!!"+find);
    	Statement stmt;			
		Class.forName("com.mysql.cj.jdbc.Driver");
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");

			if (connection != null) {
	            System.out.println("Connected to the database books");
	        }
			stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(find);
				while(rs.next()) {
				b.add(rs.getInt("idBook"));
			    b.add(rs.getString("name"));
			    b.add(rs.getString("aouther"));
			    b.add(rs.getString("isBorrow")); 
			    
			    System.out.println(b);}
			rs.close();
			stmt.close();

		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return b;
	}

public static void deleteBook(int idBook) throws ClassNotFoundException {
	System.out.println("aaa");
	String SQL="DELETE FROM books WHERE (idBook = "+idBook+")";
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

