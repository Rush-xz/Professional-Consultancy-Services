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
import com.ProfessionalConsultancyServices.model.Skills;
import com.ProfessionalConsultancyServices.service.SkillsService;


@RestController
@CrossOrigin(origins="*")
public class SkillsController {
	
	@Autowired
	private SkillsService skillservice;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/addskills/{id}")
	public ResponseEntity<?> add_skill(@PathVariable int id,@RequestBody Skills skill)
	{
		
	  Skills sk=skillservice.addSkills(skill);
	  
	 System.out.print(skillservice.updateEmpSkill(id, sk.getSid()));
		
		JSONObject json=new JSONObject();
		json.put("message", "Skill Added");
		return ResponseEntity.ok(json);
	}
	
	@GetMapping("/skills")
	public List<Skills> getAllskills()
	{
		return skillservice.getSkills();
	}
	
	@GetMapping("/skills/{id}")
	public Skills getById(@PathVariable int id)
	{
		return skillservice.getSkillid(id);
	}
	
	@DeleteMapping("/delete/skills/{id}")
	public void delete_skill(@PathVariable int id)
	{
		skillservice.delete_Skill(id);
	}

	@GetMapping("/total-skills")
	public ResponseEntity<Long> totalSkills() {
		return ResponseEntity.ok(skillservice.totalSkills());
	}
	

}
