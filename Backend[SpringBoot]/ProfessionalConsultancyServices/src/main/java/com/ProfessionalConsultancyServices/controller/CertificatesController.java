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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ProfessionalConsultancyServices.model.Certificates;
import com.ProfessionalConsultancyServices.service.CertificatesService;


@RestController
@CrossOrigin(origins="*")
public class CertificatesController {
	
	@Autowired
	private CertificatesService certificateservice;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/addcertificates/{id}")
	public ResponseEntity<?> add_certificate(@PathVariable int id,@RequestBody Certificates certi)
	{
		
		//System.out.print(certi+"    ");
		
	   Certificates certificate=certificateservice.addCertificates(certi);
	   
	   System.out.print( certificateservice.updateEmpCertificate(id, certificate.getCid()) );
		
		
		JSONObject json=new JSONObject();
		json.put("message", "Certificate Added");
		return ResponseEntity.ok(json);
		
	}
	
	@GetMapping("/certificates")
	
	public ResponseEntity<List<Certificates>> getAllcertificates()
	{
		return ResponseEntity.ok(certificateservice.getCertificates());
	}

	@GetMapping("/certificates/{id}")
	public Certificates getById(@PathVariable int id)
	{
		return certificateservice.getcertificatesid(id);
	}
	
	@DeleteMapping("/delete/certificates/{id}")
	public void delete_certification(@PathVariable int id)
	{
		certificateservice.delete_certification(id);
	}
	
	@GetMapping("/total-certificates")
	public ResponseEntity<Long> totalCertificates() {
		return ResponseEntity.ok(certificateservice.totalCertificates());
	}
	
	
	
}
