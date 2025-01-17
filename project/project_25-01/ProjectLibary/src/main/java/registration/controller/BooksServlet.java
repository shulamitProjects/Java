package registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
* Servlet implementation class StudentServlet
 */
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger Logger=null;
	
	public void init (ServletConfig config) throws ServletException{
		String path =System.getProperty("/ProjectLibary/src/main/webapp/WEB-INF/classes/log4j.properties");
		System.out.println("path->"+path);
		PropertyConfigurator.configure(path);
		Logger=Logger.getLogger(BooksServlet.class.getName());
	}
	
	
private BookDao bookDao = new BookDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List lst=new ArrayList();
		
		try {
			lst = BookDao.getListOfBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("booksData", lst);
		System.out.println(lst);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DeleteBook.jsp");
		if(requestDispatcher !=null)
            requestDispatcher.forward(request, response);
	
		
//		String name = request.getParameter("name");
//		String isBorrow = request.getParameter("isBorrow");
//		String aouther=request.getParameter("aouther");
//
//		Book book = new Book( );
//		
//		book.setAouther(aouther);
//		book.setIsBorrow(isBorrow);
//		book.setName(name);
//		boolean flag=false;
			
//		 try {
//			flag=StudentDao.checkExistStudent(student);
//			System.out.println(flag);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 if(flag==true) {
//			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
////				System.out.println("showBooks path->"+ requestDispatcher);
//
//				if(requestDispatcher !=null )
//		            requestDispatcher.forward(request, response);
//			 //booksPage
//		 }
//		 else {
//			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HomePage.jsp");
//				System.out.println("HomePage path->"+ requestDispatcher);
//				System.out.println("error 400");
//				if(requestDispatcher !=null )
//		            requestDispatcher.forward(request, response);
//		 }
//		
		
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
		//student Servlet code
		String name = request.getParameter("name");
		String isBorrow = "false";
		String aouther = request.getParameter("aouther");
	
		
		Book book = new Book();
		
		book.setName(name);
		book.setAouther(aouther);
		book.setIsBorrow(isBorrow);
			
		try {
				
			BookDao.registerBook(book);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		List dataList = new ArrayList();
		try {
		   dataList = BookDao.getListOfBooks();
		   
		}
		catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
        request.setAttribute("booksData", dataList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/libraryWorker.jsp");

		System.out.println("showBook path->"+ requestDispatcher);
		if(requestDispatcher !=null)
            requestDispatcher.forward(request, response);
		
	
	}

}
