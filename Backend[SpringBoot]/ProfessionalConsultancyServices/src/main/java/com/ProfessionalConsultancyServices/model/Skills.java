package com.ProfessionalConsultancyServices.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Skill_Id")
	private int sid;
	
	@Column(name="Skill_Tittle")
	private String stitle;
	
	@Column(name="Skill_Category")
	private String scategory;
	
	@Column(name="Skill_Description")
	private String sdesc;

	@ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER,
	        cascade = {
	                CascadeType.MERGE,
	                CascadeType.REFRESH
	            })
	@Column(name="Employees")
	@JsonIgnoreProperties("skills")
	private List<Employee> employees;

	protected Skills() {
		super();
	}

	public Skills(int sid, String stitle, String scategory, String sdesc, List<Employee> employees) {
		super();
		this.sid = sid;
		this.stitle = stitle;
		this.scategory = scategory;
		this.sdesc = sdesc;
		this.employees = employees;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getScategory() {
		return scategory;
	}

	public void setScategory(String scategory) {
		this.scategory = scategory;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Skills [sid=" + sid + ", stitle=" + stitle + ", scategory=" + scategory + ", sdesc=" + sdesc + "]";
	}

}
