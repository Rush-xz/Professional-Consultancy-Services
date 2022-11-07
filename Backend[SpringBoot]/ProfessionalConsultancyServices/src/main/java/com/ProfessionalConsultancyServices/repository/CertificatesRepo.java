package com.ProfessionalConsultancyServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ProfessionalConsultancyServices.model.Certificates;

public interface CertificatesRepo extends JpaRepository<Certificates, Integer> {

	@Modifying
	@Query(value = "insert into employee_certificates(employees_employee_id, certificates_cid) VALUES (:empid,:cid)", nativeQuery = true)
	@Transactional
	public int updateEmpCertificate(@Param("empid") int empid, @Param("cid") int cid);

}
