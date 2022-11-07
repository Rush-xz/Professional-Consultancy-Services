package com.ProfessionalConsultancyServices.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Skills;
import com.ProfessionalConsultancyServices.repository.SkillsRepo;
import com.ProfessionalConsultancyServices.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService{

	@Autowired
	private SkillsRepo skillsRepo;
	
	@Override
	public Skills addSkills(Skills skill) {
		
		return skillsRepo.save(skill);
		
	
	}

	@Override
	public List<Skills> getSkills() {
		
		List<Skills> skillslist=skillsRepo.findAll();
		return skillslist;
	}

	@Override
	public Skills getSkillid(int id) {
		
		Skills skill=skillsRepo.findById(id).get();
		
		return skill;
	}

	@Override
	public void delete_Skill(int id) {
		
		skillsRepo.deleteById(id);
		
	}

	@Override
	public long totalSkills() {
		// TODO Auto-generated method stub
		return skillsRepo.count();
	}

	@Override
	public String updateEmpSkill(int empid, int sid) {
		
		int msgempid_sid= skillsRepo.updateEmpSkill(empid, sid);
		
		return msgempid_sid + " row in employee_skills table is added successfully";
	}


	
	
	
	
}
