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
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger Logger=null;
	
	public void init (ServletConfig config) throws ServletException{
		String path =System.getProperty("/ProjectLibary/src/main/webapp/WEB-INF/classes/log4j.properties");
		System.out.println("path->"+path);
		PropertyConfigurator.configure(path);
		Logger=Logger.getLogger(BorrowServlet.class.getName());
	}
	
	
private StudentDao studentDao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

//	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.debug("Debbug logging");		
		Logger.info("info logging");
		Logger.warn("warn logging");
		Logger.error("Error logging");
		Logger.fatal("Fatal logging");
		
		
		

		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);
		int idBook =Integer.parseInt(request.getParameter("idBook"));
		model.Book b=new model.Book();
		
		

		
		try {
			b=BookDao.findBook(idBook);
			if(b.getIdBorrow()==id) {
				try {
					BookDao.returnBook(idBook,id);
                    List lst=BookDao.getListOfBooks();
                   List myLst=BookDao.getMyBooks(id);
                   lst.addAll(0, myLst);
                    request.setAttribute("booksData", lst);
                    System.out.println("lst"+lst);
           
      		      	request.setAttribute("id", id);
              
					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
						System.out.println("showBooks path->"+ requestDispatcher);
						System.out.println("success");
						if(requestDispatcher !=null )
				            requestDispatcher.forward(request, response);
				}catch (Exception e) {
					System.out.println("ERROR");
				}
			}
			else {
				try {
					BookDao.takeBook(idBook,id,"student");
                        System.out.println("take");
                        List lst=BookDao.getListOfBooks();
                        List myLst=BookDao.getMyBooks(id);
                        lst.addAll(0, myLst);
                        request.setAttribute("booksData", lst);
                        System.out.println("lst"+lst);
               
          		      	request.setAttribute("id", id);
                  
					    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showBooks.jsp");
						System.out.println("showBooks path->"+ requestDispatcher);
						System.out.println("success");
						if(requestDispatcher !=null )
				            requestDispatcher.forward(request, response);
				}catch (Exception e) {
					System.out.println("ERROR");
				}
			}
		}
			catch (Exception e) {
				System.out.println("ERROR");
			}
		
			}
	}
	

