package registration.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
* Servlet implementation class StudentServlet
 */
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger Logger=null;
	
	public void init (ServletConfig config) throws ServletException{
		String path =System.getProperty("/ProjectLibary/src/main/webapp/WEB-INF/classes/log4j.properties");
		System.out.println("path->"+path);
		PropertyConfigurator.configure(path);
		Logger=Logger.getLogger(StudentServlet.class.getName());
	}
	
	
private LibraryWorkerDao libraryWorkerDao = new LibraryWorkerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("doget");
//		
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//
//		LibraryWorker libraryWorker = new LibraryWorker();
//		
//		libraryWorker.setUserName(userName);
//		libraryWorker.setPassword(password);
//		boolean flag=false;
//		List dataList=new ArrayList();
//			
//		 try {
//			flag=LibraryWorkerDao.checkExistLibraryWorker(libraryWorker);
//			System.out.println(flag);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 if(flag==true) {
////			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/libraryWorker.jsp");
////				System.out.println("showBooks path->"+ requestDispatcher);
//
////				if(requestDispatcher !=null ) {
////					System.out.println("2!");
////		            requestDispatcher.forward(request, response);}
//					try {
//						 dataList = BookDao.getListOfBooks();
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					request.setAttribute("booksData", dataList);
//					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/libraryWorker.jsp");
//						if(requestDispatcher !=null )
//				            requestDispatcher.forward(request, response);
//		 }
//		 else {
//			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HomePage.jsp");
//				System.out.println("HomePage path->"+ requestDispatcher);
//				System.out.println("error 400");
//				if(requestDispatcher !=null )
//		            requestDispatcher.forward(request, response);
//		 }
//		
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		//student Servlet code
		
		System.out.println("dodelete");

		int idBook =Integer.parseInt(request.getParameter("idBook"));
	
		try {
					BookDao.deleteBook(idBook);
                    List lst=BookDao.getListOfBooks();

                    request.setAttribute("booksData",lst);
                    System.out.println("lst"+lst);
  
					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DeleteBook.jsp");
						System.out.println("LibraryWorker path->"+ requestDispatcher);
						System.out.println("success");
						if(requestDispatcher !=null )
				            requestDispatcher.forward(request, response);
				}catch (Exception e) {
					System.out.println("ERROR");
				}
			}
		
}

