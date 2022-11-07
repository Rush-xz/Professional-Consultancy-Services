package com.ProfessionalConsultancyServices.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private int id;
	
	@Column(name="Employee_Name")
	private String name;
	
	@Column(name="Employee_Email")
	private String email;
	
	@Column(name="Employee_Password")
	private String password;
	
	@Column(name="Employee_Role")
	private String role;
	
	@Column(name="Employee_Bio")
	private String bio;
	
	@Column(name="Employee_RegisterDate")
	private Date registerDate;
	
	@Column(name="Employee_isActive")
	private boolean isActive;

	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name="Skills")
	@JsonIgnoreProperties("employees")
	private List<Skills> skills;

	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name="Certificates")
	@JsonIgnoreProperties("employees")
	private List<Certificates> certificates;

	protected Employee() {
		super();
	}

	public Employee(int id, String name, String email, String password, String role, String bio, Date registerDate,
			boolean isActive, List<Skills> skills, List<Certificates> certificates) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.bio = bio;
		this.registerDate = registerDate;
		this.isActive = isActive;
		this.skills = skills;
		this.certificates = certificates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public List<Certificates> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificates> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", bio=" + bio + ", registerDate=" + registerDate + ", isActive=" + isActive + "]";
	}

}
