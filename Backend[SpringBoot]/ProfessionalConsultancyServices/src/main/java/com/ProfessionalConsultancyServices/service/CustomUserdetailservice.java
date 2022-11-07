package com.ProfessionalConsultancyServices.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ProfessionalConsultancyServices.model.Employee;
import com.ProfessionalConsultancyServices.repository.EmployeeRepo;


@Service
public class CustomUserdetailservice implements UserDetailsService {

	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//this.passwordEncoder.encode("Sharma")
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	     ArrayList<Employee> emplist=(ArrayList<Employee>) employeeRepo.findAll();
		
	     for(Employee emp:emplist) {
		    if(username.equalsIgnoreCase(emp.getEmail()))
		           return new User(emp.getEmail(), emp.getPassword(), new ArrayList<>());
	     }
		
		return null;
	}

}
