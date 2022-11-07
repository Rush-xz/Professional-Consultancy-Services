package com.ProfessionalConsultancyServices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProfessionalConsultancyServices.model.Skills;

@Service
public interface SkillsService {

	public Skills addSkills(Skills skill);

	public List<Skills> getSkills();

	public Skills getSkillid(int id);

	public void delete_Skill(int id);

	public long totalSkills();

	public String updateEmpSkill(int empid, int sid);

}
