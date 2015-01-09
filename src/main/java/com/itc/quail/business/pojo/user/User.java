package com.itc.quail.business.pojo.user;

public class User {

	private String userId;//敏行对应的id
	private String userName;
	private String def1;
	private String def2;
	
	public User(String userId,String userName,String def1,String def2){
		this.userId = userId;
		this.userName = userName;
		this.def1 = def1;
		this.def2 = def2;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDef1() {
		return def1;
	}
	public void setDef1(String def1) {
		this.def1 = def1;
	}
	public String getDef2() {
		return def2;
	}
	public void setDef2(String def2) {
		this.def2 = def2;
	}
	
}
