package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// AJ Abrahamsen

@Entity
@Table(name="employees")
public class ListEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="NAME")
	private String name;
	@Column(name="YEARS_OF_SERVICE")
	private int yearsOfService;
	
	public ListEmployee() {
		super();
	}
	
	public ListEmployee(String dept, String name, int yos) {
		super();
		this.department = dept;
		this.name = name;
		this.yearsOfService = yos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	public String returnEmployeeDetails() {
		String yr;
		if(yearsOfService == 1) {
			yr = " year";
		}else {
			yr = " years";
		}
		return name + " works in " + department + " and has been here for " + yearsOfService + yr + ".";
	}

}
