package com.ProfessionalConsultancyServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProfessionalConsultancyServices.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee where employee_email=?1 ")
	public Employee findbyemail(String email);

}