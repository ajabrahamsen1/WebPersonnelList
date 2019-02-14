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
 * Servlet implementation class editEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class editEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListEmployeeHelper dao = new ListEmployeeHelper();
		
		String department = request.getParameter("department");
		String name = request.getParameter("name");
		int yearsOfService = Integer.parseInt(request.getParameter("yearsOfService"));
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		ListEmployee employeeToUpdate = dao.searchForEmployeeById(tempId);
		employeeToUpdate.setName(name);
		employeeToUpdate.setDepartment(department);
		employeeToUpdate.setYearsOfService(yearsOfService);
		
		dao.updateEmployee(employeeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
	}

}
