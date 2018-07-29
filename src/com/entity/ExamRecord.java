package com.entity;

/**
 * ExamRecord entity. @author MyEclipse Persistence Tools
 */

public class ExamRecord implements java.io.Serializable {

	// Fields

	private Integer rcId;
	private String studentNo;
	private String studentPassword;
	private String studentName;
	private String examId;
	private String answerSubmit;
	private Double scoreSubmit;
	private String studentCompare;

	// Constructors

	/** default constructor */
	public ExamRecord() {
	}

	/** full constructor */
	public ExamRecord(String studentNo, String studentPassword, String studentName, String examId, String answerSubmit,
			Double scoreSubmit, String studentCompare) {
		this.studentNo = studentNo;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.examId = examId;
		this.answerSubmit = answerSubmit;
		this.scoreSubmit = scoreSubmit;
		this.studentCompare = studentCompare;
	}

	// Property accessors

	public Integer getRcId() {
		return this.rcId;
	}

	public void setRcId(Integer rcId) {
		this.rcId = rcId;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getExamId() {
		return this.examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getAnswerSubmit() {
		return this.answerSubmit;
	}

	public void setAnswerSubmit(String answerSubmit) {
		this.answerSubmit = answerSubmit;
	}

	public Double getScoreSubmit() {
		return this.scoreSubmit;
	}

	public void setScoreSubmit(Double scoreSubmit) {
		this.scoreSubmit = scoreSubmit;
	}

	public String getStudentCompare() {
		return this.studentCompare;
	}

	public void setStudentCompare(String studentCompare) {
		this.studentCompare = studentCompare;
	}

}