package registration.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.BookDao;
import dao.LibraryWorkerDao;
import dao.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LibraryWorker;
import model.Student;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
* Servlet implementation class StudentServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger Logger=null;
	
	public void init (ServletConfig config) throws ServletException{
		String path =System.getProperty("/ProjectLibary/src/main/webapp/WEB-INF/classes/log4j.properties");
		System.out.println("path->"+path);
		PropertyConfigurator.configure(path);
		Logger=Logger.getLogger(AddBookServlet.class.getName());
	}
	
	
private StudentDao studentDao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		Student student = new Student();
		
		student.setUserName(userName);
		student.setPassword(password);
		boolean flag=false;
		Student st=new Student();
				
		 try {
			flag=StudentDao.checkExistStudent(student);
			System.out.println(flag);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(flag==true) {	 
			 try {
				st=StudentDao.returnExistStudent(student);
//				myBook=BookDao.getMyBook(st.getIdBook());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(st);
			 List dataList = new ArrayList();
			 List myBook=new ArrayList();
			 List dataList2=new ArrayList();
				try {
				   dataList = BookDao.getListOfBooks();
				   
				   myBook=BookDao.getMyBooks(st.getId());
//				   System.out.println(myBook);
				}
				catch(ClassNotFoundException e) {
						
					e.printStackTrace();
				}
				dataList.addAll(0, myBook);
//				System.out.println("zsdxfcgnc"+dataList);
//				if(myBook.getIdBook()!=0) {
//				dataList2.add(0,myBook.getIsBorrow());
//				dataList2.add(0,myBook.getAouther());
//				dataList2.add(0,myBook.getName());
//				dataList2.add(0,myBook.getIdBook());}
				
				System.out.println("aaa "+dataList);
		      request.setAttribute("booksData", dataList);
		      request.setAttribute("id", st.getId());
//		      request.setAttribute("idBook", st.getId());
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
				if(requestDispatcher !=null )
		            requestDispatcher.forward(request, response);
				System.out.println("yes1234");
 
		 } 
		 else {
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HomePage.jsp");
				System.out.println("HomePage path->"+ requestDispatcher);
				System.out.println("error 400");
				if(requestDispatcher !=null )
		            requestDispatcher.forward(request, response);
		 }

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.debug("Debbug logging");		
		Logger.info("info logging");
		Logger.warn("warn logging");
		Logger.error("Error logging");
		Logger.fatal("Fatal logging");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phoneNum");
		
		Student st = new Student();
		
		st.setUserName(userName);
		st.setPassword(password);
		st.setAddress(address);
		st.setPhoneNum(phoneNum);
			
		try {
				
			StudentDao.registerStudent(st);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		List dataList = new ArrayList();
		try {
		   dataList = StudentDao.getListOfStudents();
		   
		}
		catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		//student Servlet code
//		String s=request.getParameter("type");

//		int id =Integer.parseInt(request.getParameter("id"));
//		System.out.println("id "+id);
//		int idBook =Integer.parseInt(request.getParameter("idBook"));
//		model.Book b=new model.Book();
//
//		
//		try {
//			b=BookDao.findBook(idBook);
//			if(b.getIdBorrow()==id) {
//				try {
//					BookDao.returnBook(idBook,id);
//                    List lst=BookDao.getListOfBooks();
//                    List myLst=BookDao.getMyBooks(id);
//                    lst.addAll(0, myLst);
//                    request.setAttribute("booksData", lst);
//                    System.out.println("lst"+lst);
//           
//      		      	request.setAttribute("id", id);
//              
//					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
//						System.out.println("showBooks path->"+ requestDispatcher);
//						System.out.println("success");
//						if(requestDispatcher !=null )
//				            requestDispatcher.forward(request, response);
//				}catch (Exception e) {
//					System.out.println("ERROR");
//				}
//			}
//			else {
//				try {
//					BookDao.takeBook(idBook,id);
//                        System.out.println("take");
//                        List lst=BookDao.getListOfBooks();
//                        List myLst=BookDao.getMyBooks(id);
//                        lst.addAll(0, myLst);
//                        request.setAttribute("booksData", lst);
//                        System.out.println("lst"+lst);
//               
//          		      	request.setAttribute("id", id);
//                  
//					    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
//						System.out.println("showBooks path->"+ requestDispatcher);
//						System.out.println("success");
//						if(requestDispatcher !=null )
//				            requestDispatcher.forward(request, response);
//				}catch (Exception e) {
//					System.out.println("ERROR");
//				}
//			}
//		}
//			catch (Exception e) {
//				System.out.println("ERROR");
//			}
		
		
		
		
		
		
		
		
		
//		}
//		else {
//			String userName = request.getParameter("userName");
//			String password = request.getParameter("password");
//			String address = request.getParameter("address");
//			String phoneNum = request.getParameter("phoneNum");
//			
//			Student st=new Student();
//			st.setUserName(userName);
//			st.setPassword(password);
//			st.setAddress(address);
//			st.setPhoneNum(phoneNum);
//			
//			try {
//				StudentDao.registerStudent(st);
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/libraryWorker.jsp");
//			} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
			
			
//		}
	}
	
}
