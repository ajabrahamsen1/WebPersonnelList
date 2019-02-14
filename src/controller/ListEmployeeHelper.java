package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListEmployee;

// AJ Abrahamsen

public class ListEmployeeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePersonnelList");
	
	public void insertEmployee(ListEmployee le) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(le);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListEmployee> showAllEmployees(){
		EntityManager em = emfactory.createEntityManager();
		List<ListEmployee> allEmployees = em.createQuery("SELECT i FROM ListEmployee i").getResultList();
		return allEmployees;
	}
	
	public void deleteEmployee(ListEmployee toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEmployee> typedQuery = em.createQuery("select le from ListEmployee le where le.department = :selectedDepartment and le.name = :selectedName and le.yearsOfService = :selectedYearsOfService", ListEmployee.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedDepartment", toDelete.getDepartment());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedYearsOfService", toDelete.getYearsOfService());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ListEmployee result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListEmployee searchForEmployeeById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListEmployee found = em.find(ListEmployee.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEmployee(ListEmployee toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListEmployee> searchForEmployeeByDepartment(String department) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEmployee> typedQuery = em.createQuery("select le from ListEmployee le where le.department = :selectedDepartment", ListEmployee.class);
		typedQuery.setParameter("selectedDepartment", department);
		
		List<ListEmployee> foundEmployees = typedQuery.getResultList();
		em.close();
		return foundEmployees;
	}

	public List<ListEmployee> searchForEmployeeByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEmployee> typedQuery = em.createQuery("select le from ListEmployee le where le.name = :selectedName", ListEmployee.class);
		typedQuery.setParameter("selectedName", name);
		
		List<ListEmployee> foundEmployees = typedQuery.getResultList();
		em.close();
		return foundEmployees;
	}

	public List<ListEmployee> searchForEmployeeByYearsOfService(int yearsOfService) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEmployee> typedQuery = em.createQuery("select le from ListEmployee le where le.yearsOfService = :selectedYearsOfService", ListEmployee.class);
		typedQuery.setParameter("selectedYearsOfService", yearsOfService);
		
		List<ListEmployee> foundEmployees = typedQuery.getResultList();
		em.close();
		return foundEmployees;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
