package com.ProfessionalConsultancyServices.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Certificates;
import com.ProfessionalConsultancyServices.repository.CertificatesRepo;
import com.ProfessionalConsultancyServices.service.CertificatesService;

@Service
public class CertificatesServiceImpl implements CertificatesService {

	@Autowired
	private CertificatesRepo certificatesRepo;
	
	@Override
	public Certificates addCertificates(Certificates certificates) {
		
		return certificatesRepo.save(certificates);
		
	}

	@Override
	public List<Certificates> getCertificates() {
		
		List<Certificates> Certilist=certificatesRepo.findAll();
		
		return Certilist;
	}

	@Override
	public Certificates getcertificatesid(int id) {
		
		Certificates certificates=certificatesRepo.findById(id).get();
		
	    return certificates;
	}

	@Override
	public void delete_certification(int id) {
	    
		certificatesRepo.deleteById(id);
		
	}

	@Override
	public long totalCertificates() {
		// TODO Auto-generated method stub
		return certificatesRepo.count();
	}

	
	@Override
	public String updateEmpCertificate(int empid, int cid) {
		int msgemp_cid = certificatesRepo.updateEmpCertificate(empid, cid);
		return msgemp_cid + " row in employee_certificates table is added successfully";
	}

}
