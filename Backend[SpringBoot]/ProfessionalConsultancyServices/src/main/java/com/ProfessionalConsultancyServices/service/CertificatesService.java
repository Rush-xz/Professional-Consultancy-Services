package com.ProfessionalConsultancyServices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Certificates;

@Service
public interface CertificatesService {

	public Certificates addCertificates(Certificates certificates);

	public List<Certificates> getCertificates();

	public Certificates getcertificatesid(int id);

	public void delete_certification(int id);

	public long totalCertificates();

	public String updateEmpCertificate(int empid, int cid);

}
