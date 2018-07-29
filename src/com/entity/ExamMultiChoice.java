package com.entity;

/**
 * ExamMultiChoice entity. @author MyEclipse Persistence Tools
 */

public class ExamMultiChoice implements java.io.Serializable {

	// Fields

	private String mcId;
	private String teacherId;
	private String subjectName;
	private String mcQuestion;
	private String mcAnswerA;
	private String mcAnswerB;
	private String mcAnswerC;
	private String mcAnswerD;
	private String mcAnswerE;
	private String mcAnswerCorrect;
	private String mcAnalysis;
	private String mcIsShare;

	// Constructors

	/** default constructor */
	public ExamMultiChoice() {
	}

	/** minimal constructor */
	public ExamMultiChoice(String mcId, String teacherId) {
		this.mcId = mcId;
		this.teacherId = teacherId;
	}

	/** full constructor */
	public ExamMultiChoice(String mcId, String teacherId, String subjectName, String mcQuestion, String mcAnswerA,
			String mcAnswerB, String mcAnswerC, String mcAnswerD, String mcAnswerE, String mcAnswerCorrect,
			String mcAnalysis, String mcIsShare) {
		this.mcId = mcId;
		this.teacherId = teacherId;
		this.subjectName = subjectName;
		this.mcQuestion = mcQuestion;
		this.mcAnswerA = mcAnswerA;
		this.mcAnswerB = mcAnswerB;
		this.mcAnswerC = mcAnswerC;
		this.mcAnswerD = mcAnswerD;
		this.mcAnswerE = mcAnswerE;
		this.mcAnswerCorrect = mcAnswerCorrect;
		this.mcAnalysis = mcAnalysis;
		this.mcIsShare = mcIsShare;
	}

	// Property accessors

	public String getMcId() {
		return this.mcId;
	}

	public void setMcId(String mcId) {
		this.mcId = mcId;
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

	public String getMcQuestion() {
		return this.mcQuestion;
	}

	public void setMcQuestion(String mcQuestion) {
		this.mcQuestion = mcQuestion;
	}

	public String getMcAnswerA() {
		return this.mcAnswerA;
	}

	public void setMcAnswerA(String mcAnswerA) {
		this.mcAnswerA = mcAnswerA;
	}

	public String getMcAnswerB() {
		return this.mcAnswerB;
	}

	public void setMcAnswerB(String mcAnswerB) {
		this.mcAnswerB = mcAnswerB;
	}

	public String getMcAnswerC() {
		return this.mcAnswerC;
	}

	public void setMcAnswerC(String mcAnswerC) {
		this.mcAnswerC = mcAnswerC;
	}

	public String getMcAnswerD() {
		return this.mcAnswerD;
	}

	public void setMcAnswerD(String mcAnswerD) {
		this.mcAnswerD = mcAnswerD;
	}

	public String getMcAnswerE() {
		return this.mcAnswerE;
	}

	public void setMcAnswerE(String mcAnswerE) {
		this.mcAnswerE = mcAnswerE;
	}

	public String getMcAnswerCorrect() {
		return this.mcAnswerCorrect;
	}

	public void setMcAnswerCorrect(String mcAnswerCorrect) {
		this.mcAnswerCorrect = mcAnswerCorrect;
	}

	public String getMcAnalysis() {
		return this.mcAnalysis;
	}

	public void setMcAnalysis(String mcAnalysis) {
		this.mcAnalysis = mcAnalysis;
	}

	public String getMcIsShare() {
		return this.mcIsShare;
	}

	public void setMcIsShare(String mcIsShare) {
		this.mcIsShare = mcIsShare;
	}

}