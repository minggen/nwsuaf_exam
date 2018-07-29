package com.entity;

/**
 * ExamSingleChoice entity. @author MyEclipse Persistence Tools
 */

public class ExamSingleChoice implements java.io.Serializable {

	// Fields

	private String scId;
	private String teacherId;
	private String subjectName;
	private String scQuestion;
	private String scAnswerA;
	private String scAnswerB;
	private String scAnswerC;
	private String scAnswerD;
	private String scAnswerCorrect;
	private String scAnalysis;
	private String scIsShare;

	// Constructors

	/** default constructor */
	public ExamSingleChoice() {
	}

	/** minimal constructor */
	public ExamSingleChoice(String scId, String teacherId) {
		this.scId = scId;
		this.teacherId = teacherId;
	}

	/** full constructor */
	public ExamSingleChoice(String scId, String teacherId, String subjectName, String scQuestion, String scAnswerA,
			String scAnswerB, String scAnswerC, String scAnswerD, String scAnswerCorrect, String scAnalysis,
			String scIsShare) {
		this.scId = scId;
		this.teacherId = teacherId;
		this.subjectName = subjectName;
		this.scQuestion = scQuestion;
		this.scAnswerA = scAnswerA;
		this.scAnswerB = scAnswerB;
		this.scAnswerC = scAnswerC;
		this.scAnswerD = scAnswerD;
		this.scAnswerCorrect = scAnswerCorrect;
		this.scAnalysis = scAnalysis;
		this.scIsShare = scIsShare;
	}

	// Property accessors

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
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

	public String getScQuestion() {
		return this.scQuestion;
	}

	public void setScQuestion(String scQuestion) {
		this.scQuestion = scQuestion;
	}

	public String getScAnswerA() {
		return this.scAnswerA;
	}

	public void setScAnswerA(String scAnswerA) {
		this.scAnswerA = scAnswerA;
	}

	public String getScAnswerB() {
		return this.scAnswerB;
	}

	public void setScAnswerB(String scAnswerB) {
		this.scAnswerB = scAnswerB;
	}

	public String getScAnswerC() {
		return this.scAnswerC;
	}

	public void setScAnswerC(String scAnswerC) {
		this.scAnswerC = scAnswerC;
	}

	public String getScAnswerD() {
		return this.scAnswerD;
	}

	public void setScAnswerD(String scAnswerD) {
		this.scAnswerD = scAnswerD;
	}

	public String getScAnswerCorrect() {
		return this.scAnswerCorrect;
	}

	public void setScAnswerCorrect(String scAnswerCorrect) {
		this.scAnswerCorrect = scAnswerCorrect;
	}

	public String getScAnalysis() {
		return this.scAnalysis;
	}

	public void setScAnalysis(String scAnalysis) {
		this.scAnalysis = scAnalysis;
	}

	public String getScIsShare() {
		return this.scIsShare;
	}

	public void setScIsShare(String scIsShare) {
		this.scIsShare = scIsShare;
	}

}