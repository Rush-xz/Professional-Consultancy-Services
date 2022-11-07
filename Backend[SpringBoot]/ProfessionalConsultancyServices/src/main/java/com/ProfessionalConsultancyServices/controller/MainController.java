package com.ProfessionalConsultancyServices.controller;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProfessionalConsultancyServices.model.Employee;
import com.ProfessionalConsultancyServices.service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public ResponseEntity<?> doRegister(@RequestBody Employee employee) {
		System.out.print(employee);
		JSONObject json = new JSONObject();
		boolean isregister = false;
        try {
		Employee emp=employeeService.findbyEmail(employee.getEmail());
		if(emp!=null) {
			json.put("message", "User Already exist");
			return ResponseEntity.ok(json);
		}
		
        }
        catch (Exception exception) {
        	
		}
        
        isregister = employeeService.registerEmployee(employee);
		if (isregister == true) {
			json.put("message", "Registration Successfull");
			return ResponseEntity.ok(json);
		} else {
			json.put("message", "Something wents wrong");

			return ResponseEntity.ok(json);
		}
	}

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getEmployee();
	}

	@GetMapping("/getemployees/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		
		return ResponseEntity.ok(employeeService.getEmployeebyid(id));
	}

	@PutMapping("/employees/{id}")
	public void update_employee(@PathVariable int id, @RequestBody Employee emp) {
		employeeService.updateEmployee(id, emp);

	}

	@DeleteMapping("/delete/employees/{id}")
	public void delete_employee(@PathVariable int id) {
		
		employeeService.deleteEmployee(id);
		
		
	}

	@GetMapping("/total-employees")
	public ResponseEntity<Long> totalEmployees() {
		return ResponseEntity.ok(employeeService.totalEmployees());
	}
	
	
	
}
