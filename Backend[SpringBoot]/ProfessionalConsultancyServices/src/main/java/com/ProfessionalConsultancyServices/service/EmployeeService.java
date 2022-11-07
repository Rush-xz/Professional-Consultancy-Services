package com.ProfessionalConsultancyServices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Employee;

@Service
public interface EmployeeService  {
	
	public boolean registerEmployee( Employee employee);
	
	public List<Employee> getEmployee( );
	
	public Employee getEmployeebyid(int id );

	public Employee findbyEmail(String email);
	
	public void updateEmployee(int id,Employee e);
	
	public void deleteEmployee(int id);
	
	public long totalEmployees();
	

}
