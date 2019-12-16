package com.classes;

public class User {
	
	private int id;
	private String userNickname;
	private String userName;
	private String e_mail;
	private String pass;

	public User(int id,String userNickname, String userName, String e_mail, String pass) {
		this.id=id;
		this.userNickname = userNickname;
		this.userName = userName;
		this.e_mail = e_mail;
		this.pass = pass;
	}
	
	public User()
	{		
	}

	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
