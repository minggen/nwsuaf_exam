package com.entity;

/**
 * ExamTofChoice entity. @author MyEclipse Persistence Tools
 */

public class ExamTofChoice implements java.io.Serializable {

	// Fields

	private String tcId;
	private String teacherId;
	private String subjectName;
	private String tcQuestion;
	private String tcAnswerCorrect;
	private String tcAnalysis;
	private String tcIsShare;

	// Constructors

	/** default constructor */
	public ExamTofChoice() {
	}

	/** minimal constructor */
	public ExamTofChoice(String tcId, String teacherId) {
		this.tcId = tcId;
		this.teacherId = teacherId;
	}

	/** full constructor */
	public ExamTofChoice(String tcId, String teacherId, String subjectName, String tcQuestion, String tcAnswerCorrect,
			String tcAnalysis, String tcIsShare) {
		this.tcId = tcId;
		this.teacherId = teacherId;
		this.subjectName = subjectName;
		this.tcQuestion = tcQuestion;
		this.tcAnswerCorrect = tcAnswerCorrect;
		this.tcAnalysis = tcAnalysis;
		this.tcIsShare = tcIsShare;
	}

	// Property accessors

	public String getTcId() {
		return this.tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
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

	public String getTcQuestion() {
		return this.tcQuestion;
	}

	public void setTcQuestion(String tcQuestion) {
		this.tcQuestion = tcQuestion;
	}

	public String getTcAnswerCorrect() {
		return this.tcAnswerCorrect;
	}

	public void setTcAnswerCorrect(String tcAnswerCorrect) {
		this.tcAnswerCorrect = tcAnswerCorrect;
	}

	public String getTcAnalysis() {
		return this.tcAnalysis;
	}

	public void setTcAnalysis(String tcAnalysis) {
		this.tcAnalysis = tcAnalysis;
	}

	public String getTcIsShare() {
		return this.tcIsShare;
	}

	public void setTcIsShare(String tcIsShare) {
		this.tcIsShare = tcIsShare;
	}

}