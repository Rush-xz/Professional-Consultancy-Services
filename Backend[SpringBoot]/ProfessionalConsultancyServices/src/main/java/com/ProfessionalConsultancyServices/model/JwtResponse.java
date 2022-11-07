package com.ProfessionalConsultancyServices.model;

public class JwtResponse {

	private String token;
	private int id;
	private String username;
	private boolean isActive;
	private String role;
	
	
	public JwtResponse() {
		super();
	}
	public JwtResponse(String token,int id, String username, boolean isActive, String role) {
		super();
		this.token=token;
		this.id = id;
		this.username = username;
		this.isActive = isActive;
		this.role = role;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", id=" + id + ", username=" + username + ", isActive=" + isActive
				+ ", role=" + role + "]";
	}
	
	

	
	
}
