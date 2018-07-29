package com.entity;

/**
 * ExamSubject entity. @author MyEclipse Persistence Tools
 */

public class ExamSubject implements java.io.Serializable {

	// Fields

	private String subjectId;
	private String subjectName;

	// Constructors

	/** default constructor */
	public ExamSubject() {
	}

	/** minimal constructor */
	public ExamSubject(String subjectId) {
		this.subjectId = subjectId;
	}

	/** full constructor */
	public ExamSubject(String subjectId, String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	// Property accessors

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}