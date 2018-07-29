package com.entity;

/**
 * ExamSystem entity. @author MyEclipse Persistence Tools
 */

public class ExamSystem implements java.io.Serializable {

	// Fields

	private String sysId;
	private String sysName;
	private String sysNotes;

	// Constructors

	/** default constructor */
	public ExamSystem() {
	}

	/** full constructor */
	public ExamSystem(String sysId, String sysName, String sysNotes) {
		this.sysId = sysId;
		this.sysName = sysName;
		this.sysNotes = sysNotes;
	}

	// Property accessors

	public String getSysId() {
		return this.sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysNotes() {
		return this.sysNotes;
	}

	public void setSysNotes(String sysNotes) {
		this.sysNotes = sysNotes;
	}

}