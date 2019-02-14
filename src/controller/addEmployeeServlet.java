package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListEmployee;

// AJ Abrahamsen

/**
 * Servlet implementation class addEmployeeServlet
 */
@WebServlet("/addEmployeeServlet")
public class addEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String department = request.getParameter("department");
		String name = request.getParameter("name");
		int yearsOfService = Integer.parseInt(request.getParameter("yearsOfService"));
		
		ListEmployee le = new ListEmployee(department, name, yearsOfService);
		ListEmployeeHelper dao = new ListEmployeeHelper();
		dao.insertEmployee(le);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
