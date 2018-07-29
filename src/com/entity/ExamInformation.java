package com.entity;

/**
 * ExamInformation entity. @author MyEclipse Persistence Tools
 */

public class ExamInformation implements java.io.Serializable {

	// Fields

	private String examId;
	private String examName;
	private String teacherId;
	private String subjectName;
	private String examChoice;
	private String examQustions;
	private String examBeginTime;
	private String examTime;
	private String examAnswer;
	private String examIsBySelf;
	private String examAnalysis;

	// Constructors

	/** default constructor */
	public ExamInformation() {
	}

	/** minimal constructor */
	public ExamInformation(String examId, String examName, String teacherId) {
		this.examId = examId;
		this.examName = examName;
		this.teacherId = teacherId;
	}

	/** full constructor */
	public ExamInformation(String examId, String examName, String teacherId, String subjectName, String examChoice,
			String examQustions, String examBeginTime, String examTime, String examAnswer, String examIsBySelf,
			String examAnalysis) {
		this.examId = examId;
		this.examName = examName;
		this.teacherId = teacherId;
		this.subjectName = subjectName;
		this.examChoice = examChoice;
		this.examQustions = examQustions;
		this.examBeginTime = examBeginTime;
		this.examTime = examTime;
		this.examAnswer = examAnswer;
		this.examIsBySelf = examIsBySelf;
		this.examAnalysis = examAnalysis;
	}

	// Property accessors

	public String getExamId() {
		return this.examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return this.examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getExamChoice() {
		return this.examChoice;
	}

	public void setExamChoice(String examChoice) {
		this.examChoice = examChoice;
	}

	public String getExamQustions() {
		return this.examQustions;
	}

	public void setExamQustions(String examQustions) {
		this.examQustions = examQustions;
	}

	public String getExamBeginTime() {
		return this.examBeginTime;
	}

	public void setExamBeginTime(String examBeginTime) {
		this.examBeginTime = examBeginTime;
	}

	public String getExamTime() {
		return this.examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamAnswer() {
		return this.examAnswer;
	}

	public void setExamAnswer(String examAnswer) {
		this.examAnswer = examAnswer;
	}

	public String getExamIsBySelf() {
		return this.examIsBySelf;
	}

	public void setExamIsBySelf(String examIsBySelf) {
		this.examIsBySelf = examIsBySelf;
	}

	public String getExamAnalysis() {
		return this.examAnalysis;
	}

	public void setExamAnalysis(String examAnalysis) {
		this.examAnalysis = examAnalysis;
	}

}