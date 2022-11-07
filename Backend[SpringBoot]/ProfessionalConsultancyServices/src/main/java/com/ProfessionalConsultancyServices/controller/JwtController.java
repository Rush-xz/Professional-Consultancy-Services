package com.ProfessionalConsultancyServices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ProfessionalConsultancyServices.Utility.JwtUtil;
import com.ProfessionalConsultancyServices.model.Employee;
import com.ProfessionalConsultancyServices.model.JwtRequest;
import com.ProfessionalConsultancyServices.model.JwtResponse;
import com.ProfessionalConsultancyServices.service.CustomUserdetailservice;
import com.ProfessionalConsultancyServices.service.EmployeeService;

@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CustomUserdetailservice customUserdetailservice;

	@Autowired
	 private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception {

		System.out.print(jwtrequest);
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		UserDetails user=this.customUserdetailservice.loadUserByUsername(jwtrequest.getUsername());
		
		String token= this.jwtutil.generateToken(user);
		
		Employee emp=employeeService.findbyEmail(jwtrequest.getUsername());
		
		JwtResponse response=new JwtResponse(token,emp.getId(),emp.getName(),emp.getIsActive(),emp.getRole());
		
		System.out.print(response.toString());
		
		
		return ResponseEntity.ok(response);	
		
	}
	

}
