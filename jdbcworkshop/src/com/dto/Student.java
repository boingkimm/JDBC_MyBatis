package com.dto;

public class Student {

	private String stuNo;
	private String departNo;
	private String stuName;
	private String stuSsn;
	private String stuAddress;
	private String entDate;
	private String absYn;
	private String coachProfessorNo;

	public Student() {
	}

	public Student(String stuNo, String stuName, String stuSsn, String stuAddress, String entDate, String absYn) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuSsn = stuSsn;
		this.stuAddress = stuAddress;
		this.entDate = entDate;
		this.absYn = absYn;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getDepartNo() {
		return departNo;
	}

	public void setDepartNo(String departNo) {
		this.departNo = departNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSsn() {
		return stuSsn;
	}

	public void setStuSsn(String stuSsn) {
		this.stuSsn = stuSsn;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}

	public String getAbsYn() {
		return absYn;
	}

	public void setAbsYn(String absYn) {
		this.absYn = absYn;
	}

	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}

	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}

	@Override
	public String toString() {
		return "StudentDTO [stuNo=" + stuNo + ", departNo=" + departNo + ", stuName=" + stuName + ", stuSsn=" + stuSsn
				+ ", stuAddress=" + stuAddress + ", entDate=" + entDate + ", absYn=" + absYn + ", coachProfessorNo="
				+ coachProfessorNo + "]";
	}

}
