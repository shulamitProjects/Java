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
public class ShowAllExistStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger Logger=null;
	
	public void init (ServletConfig config) throws ServletException{
		String path =System.getProperty("/ProjectLibary/src/main/webapp/WEB-INF/classes/log4j.properties");
		System.out.println("path->"+path);
		PropertyConfigurator.configure(path);
		Logger=Logger.getLogger(ShowAllExistStudents.class.getName());
	}
	
	
private BookDao bookDao = new BookDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllExistStudents() {
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
			lst = StudentDao.getListOfStudents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("studentsData", lst);
		System.out.println(lst);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DeletePerson.jsp");
		if(requestDispatcher !=null)
            requestDispatcher.forward(request, response);
	}
	}
		