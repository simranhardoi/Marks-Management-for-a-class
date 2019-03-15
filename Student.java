package com.jasjot.application.app.entities;

public class Student {
	
	private int rno;
	private String stName;
	private String email;
	private String className;
	private String gender;
	private int marks;
	
	
	public Student(){
		
	}


	public int getRno() {
		return rno;
	}


	public void setRno(int rno) {
		this.rno = rno;
	}


	public String getStName() {
		return stName;
	}


	public void setStName(String stName) {
		this.stName = stName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [rno=" + rno + ", stName=" + stName + ", email=" + email + ", className=" + className
				+ ", gender=" + gender + ", marks=" + marks + "]";
	}
	
	
	
}
