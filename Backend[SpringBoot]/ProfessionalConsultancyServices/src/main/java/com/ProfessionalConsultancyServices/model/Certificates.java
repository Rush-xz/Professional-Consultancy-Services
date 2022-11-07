package com.ProfessionalConsultancyServices.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Certificates {

	@Override
	public String toString() {
		return "Certificates [cid=" + cid + ", cname=" + cname + ", cexpiryDate=" + cexpiryDate + "]";
	}

	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private Date cexpiryDate;

	@ManyToMany(mappedBy = "certificates", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("certificates")
	private List<Employee> employees;

	protected Certificates() {
		super();
	}

	public Certificates(int cid, String cname, Date cexpiryDate, List<Employee> employees) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cexpiryDate = cexpiryDate;
		this.employees = employees;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Date getCexpiryDate() {
		return cexpiryDate;
	}

	public void setCexpiryDate(Date cexpiryDate) {
		this.cexpiryDate = cexpiryDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}