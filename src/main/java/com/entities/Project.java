package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="project_new")
public class Project {
	
	@Id
	/*private String uniqueId;
	private String savingDate;
	private String dateTime;*/
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	private int projectid;
	private String details;
	private String highlights;
	private String highlights1;
	//private String uniq;
	private String asstdocument1;
	private String asstdocument2;
	private String asstdocument3;
	private String asstdocument4;
	private String asstdocument5;
	private String asstdocument1name;
	private String asstdocument2name;
	private String asstdocument3name;
	private String asstdocument4name;
	private String asstdocument5name;
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getHighlights() {
		return highlights;
	}
	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}
	public String getHighlights1() {
		return highlights1;
	}
	public void setHighlights1(String highlights1) {
		this.highlights1 = highlights1;
	}
	public String getAsstdocument1() {
		return asstdocument1;
	}
	public void setAsstdocument1(String asstdocument1) {
		this.asstdocument1 = asstdocument1;
	}
	public String getAsstdocument2() {
		return asstdocument2;
	}
	public void setAsstdocument2(String asstdocument2) {
		this.asstdocument2 = asstdocument2;
	}
	public String getAsstdocument3() {
		return asstdocument3;
	}
	public void setAsstdocument3(String asstdocument3) {
		this.asstdocument3 = asstdocument3;
	}
	public String getAsstdocument4() {
		return asstdocument4;
	}
	public void setAsstdocument4(String asstdocument4) {
		this.asstdocument4 = asstdocument4;
	}
	public String getAsstdocument5() {
		return asstdocument5;
	}
	public void setAsstdocument5(String asstdocument5) {
		this.asstdocument5 = asstdocument5;
	}
	public String getAsstdocument1name() {
		return asstdocument1name;
	}
	public void setAsstdocument1name(String asstdocument1name) {
		this.asstdocument1name = asstdocument1name;
	}
	public String getAsstdocument2name() {
		return asstdocument2name;
	}
	public void setAsstdocument2name(String asstdocument2name) {
		this.asstdocument2name = asstdocument2name;
	}
	public String getAsstdocument3name() {
		return asstdocument3name;
	}
	public void setAsstdocument3name(String asstdocument3name) {
		this.asstdocument3name = asstdocument3name;
	}
	public String getAsstdocument4name() {
		return asstdocument4name;
	}
	public void setAsstdocument4name(String asstdocument4name) {
		this.asstdocument4name = asstdocument4name;
	}
	public String getAsstdocument5name() {
		return asstdocument5name;
	}
	public void setAsstdocument5name(String asstdocument5name) {
		this.asstdocument5name = asstdocument5name;
	}
	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", details=" + details + ", highlights=" + highlights
				+ ", highlights1=" + highlights1 + ", asstdocument1=" + asstdocument1 + ", asstdocument2="
				+ asstdocument2 + ", asstdocument3=" + asstdocument3 + ", asstdocument4=" + asstdocument4
				+ ", asstdocument5=" + asstdocument5 + ", asstdocument1name=" + asstdocument1name
				+ ", asstdocument2name=" + asstdocument2name + ", asstdocument3name=" + asstdocument3name
				+ ", asstdocument4name=" + asstdocument4name + ", asstdocument5name=" + asstdocument5name + "]";
	}
	public Project(int projectid, String details, String highlights, String highlights1, String asstdocument1,
			String asstdocument2, String asstdocument3, String asstdocument4, String asstdocument5,
			String asstdocument1name, String asstdocument2name, String asstdocument3name, String asstdocument4name,
			String asstdocument5name) {
		super();
		this.projectid = projectid;
		this.details = details;
		this.highlights = highlights;
		this.highlights1 = highlights1;
		this.asstdocument1 = asstdocument1;
		this.asstdocument2 = asstdocument2;
		this.asstdocument3 = asstdocument3;
		this.asstdocument4 = asstdocument4;
		this.asstdocument5 = asstdocument5;
		this.asstdocument1name = asstdocument1name;
		this.asstdocument2name = asstdocument2name;
		this.asstdocument3name = asstdocument3name;
		this.asstdocument4name = asstdocument4name;
		this.asstdocument5name = asstdocument5name;
	}
	/*public void setCategory(String parameter) {
		// TODO Auto-generated method stub
		
	}*/
	public Project() {
		// TODO Auto-generated constructor stub
	}
	/*public void setDocument1size(String string) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	
	
	
}