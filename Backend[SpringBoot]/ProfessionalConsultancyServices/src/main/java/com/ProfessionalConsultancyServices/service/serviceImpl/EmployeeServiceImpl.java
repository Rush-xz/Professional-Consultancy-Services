package com.ProfessionalConsultancyServices.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Employee;
import com.ProfessionalConsultancyServices.repository.EmployeeRepo;
import com.ProfessionalConsultancyServices.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean registerEmployee( Employee employee) {
		
		employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));
		
        System.out.print(employee);
		
		employeeRepo.save(employee);
				
		return true;
	}

	@Override
	public List<Employee> getEmployee() {
		
		List<Employee> emplist= employeeRepo.findAll();
		
		return emplist;
	}

	@Override
	public Employee getEmployeebyid(int id) {
		
		Employee emp=employeeRepo.findById(id).get();
		
		return emp;
	}

	@Override
	public Employee findbyEmail(String email) {
		
		Employee emp=employeeRepo.findbyemail(email);
		return emp;
		
		
	}

	@Override
	public void updateEmployee(int id, Employee e) {
		try {
			Employee e1 = employeeRepo.findById(id).orElseThrow(() -> new Exception("no user found"));
			
			e1.setName(e.getName());
			e1.setPassword(this.passwordEncoder.encode(e.getPassword()));
			e1.setBio(e.getBio());
			
			employeeRepo.save(e1);
			
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
	
		employeeRepo.deleteById(id);
		
	}

	@Override
	public long totalEmployees() {
		
	 return employeeRepo.count();
	}

}
