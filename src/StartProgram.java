

import java.util.List;
import java.util.Scanner;

import controller.ListEmployeeHelper;
import model.ListEmployee;

// AJ Abrahamsen

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListEmployeeHelper leh = new ListEmployeeHelper();
		

		private static void addAnEmployee() {
			// TODO Auto-generated method stub
			System.out.print("Enter a department: ");
			String department = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter years of service: ");
			int yearsOfService = in.nextInt();
			ListEmployee toAdd = new ListEmployee(department, name, yearsOfService);
			leh.insertEmployee(toAdd);

		}

		private static void deleteAnEmployee() {
			// TODO Auto-generated method stub
			System.out.print("Enter the department to delete: ");
			String department = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the years of service to delete: ");
			int yearsOfService = in.nextInt();
			ListEmployee toDelete = new ListEmployee(department, name, yearsOfService);
			leh.deleteEmployee(toDelete);

		}

		private static void editAnEmployee() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by department");
			System.out.println("2 : Search by name");
			System.out.println("3 : Search by years of service");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListEmployee> foundEmployees;
			if (searchBy == 1) {
				System.out.print("Enter the department name: ");
				String department = in.nextLine();
				foundEmployees = leh.searchForEmployeeByDepartment(department);
				
			} else if (searchBy == 2) {
				System.out.print("Enter the name: ");
				String name = in.nextLine();
				foundEmployees = leh.searchForEmployeeByName(name);
				
			} else {
				System.out.print("Enter the years of service: ");
				int yearsOfService = in.nextInt();
				foundEmployees = leh.searchForEmployeeByYearsOfService(yearsOfService);
			}

			if (!foundEmployees.isEmpty()) {
				System.out.println("Found Results.");
				for (ListEmployee l : foundEmployees) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListEmployee toEdit = leh.searchForEmployeeById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getDepartment());
				System.out.println("1 : Update department");
				System.out.println("2 : Update name");
				System.out.println("3 : Update years of service");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New department: ");
					String newdepartment = in.nextLine();
					toEdit.setDepartment(newdepartment);
				} else if (update == 2) {
					System.out.print("New name: ");
					String newname = in.nextLine();
					toEdit.setName(newname);
				} else if (update == 3) {
					System.out.print("New years of service: ");
					int newYearsOfSerivce = in.nextInt();
					toEdit.setYearsOfService(newYearsOfSerivce);
				}

				leh.updateEmployee(toEdit);

			} else {
				System.out.println("---- No results found");
			}
			

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an employee:");
				System.out.println("*  1 -- Add an employee");
				System.out.println("*  2 -- Edit an employee");
				System.out.println("*  3 -- Delete an employee");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnEmployee();
				} else if (selection == 2) {
					editAnEmployee();
				} else if (selection == 3) {
					deleteAnEmployee();
				} else if (selection == 4) {
					viewTheList();
				} else {
					leh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListEmployee> allEmployees = leh.showAllEmployees();
			for(ListEmployee singleEmployee:allEmployees) {
				System.out.println(singleEmployee.returnEmployeeDetails());
			}

		}

	}
