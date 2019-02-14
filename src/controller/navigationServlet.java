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
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToEmployee");
		
		ListEmployeeHelper dao = new ListEmployeeHelper();
		
		if (act==null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
		}else if (act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListEmployee itemToDelete = dao.searchForEmployeeById(tempId);
				dao.deleteEmployee(itemToDelete);
			
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
			}
		}else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListEmployee employeeToEdit = dao.searchForEmployeeById(tempId);
			request.setAttribute("employeeToEdit", employeeToEdit);
			getServletContext().getRequestDispatcher("/edit-employee.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
			}
		}else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
