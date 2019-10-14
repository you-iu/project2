package com.khrd.dto;

import java.util.Date;

public class Project {
	private int project_no;
	private String project_name;
	private String project_content;
	private Date regdate;
	private Date moddate;
	private String project_re;
	public Project() {
	
	}
	public Project(int project_no, String project_name, String project_content, Date regdate, Date moddate,
			String project_re) {
		super();
		this.project_no = project_no;
		this.project_name = project_name;
		this.project_content = project_content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.project_re = project_re;
	}
	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_content() {
		return project_content;
	}
	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public String getProject_re() {
		return project_re;
	}
	public void setProject_re(String project_re) {
		this.project_re = project_re;
	}
	@Override
	public String toString() {
		return "Project [project_no=" + project_no + ", project_name=" + project_name + ", project_content="
				+ project_content + ", regdate=" + regdate + ", moddate=" + moddate + ", project_re=" + project_re
				+ "]";
	}
	
	

}
