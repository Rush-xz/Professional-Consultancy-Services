package com.ProfessionalConsultancyServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ProfessionalConsultancyServices.model.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {
	
	
	@Modifying
	@Query(value = "insert into employee_skills(employees_employee_id, skills_skill_id) VALUES (:empid,:sid)", nativeQuery = true)
	@Transactional
	public int updateEmpSkill(@Param("empid") int empid, @Param("sid") int sid);

}
