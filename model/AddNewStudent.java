package org.attendance.model;

public class AddNewStudent {
	
	private String name;
	private String contact;
	private String email;
	private String batch;
	private String course;
	private boolean a=false;
	private int attendance;
	private int id;
	
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public AddNewStudent(String name,String batch)
	{
		this.name=name;
		this.batch=batch;
	}
	
	public AddNewStudent()
	{
		
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}
}
