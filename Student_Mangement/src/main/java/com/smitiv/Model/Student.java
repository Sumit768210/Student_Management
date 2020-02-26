package com.smitiv.Model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;



public class Student {
	
	 private long id;
	  private String Student_name ;
	  private String Adress;
	  private String email;
	public Student(long id, String student_name, String adress, String email) {
		
		this.id = id;
		Student_name = student_name;
		Adress = adress;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	  
	
	
	
	

}
