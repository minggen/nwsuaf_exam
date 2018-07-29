package com.entity;

/**
 * ExamUser entity. @author MyEclipse Persistence Tools
 */

public class ExamUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userPassword;
	private String userName;
	private String userSex;
	private String userTelephone;
	private String userEmail;
	private String userIsAdmin;

	// Constructors

	/** default constructor */
	public ExamUser() {
	}

	/** minimal constructor */
	public ExamUser(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public ExamUser(String userId, String userPassword, String userName, String userSex, String userTelephone,
			String userEmail, String userIsAdmin) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.userTelephone = userTelephone;
		this.userEmail = userEmail;
		this.userIsAdmin = userIsAdmin;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTelephone() {
		return this.userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserIsAdmin() {
		return this.userIsAdmin;
	}

	public void setUserIsAdmin(String userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

}