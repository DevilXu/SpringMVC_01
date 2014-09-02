package org.app.users.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class demo implements Serializable{
	private String id;
	private String dept_code;
	private String dept_name;
	private String dept_desc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_desc() {
		return dept_desc;
	}
	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}
	
}
