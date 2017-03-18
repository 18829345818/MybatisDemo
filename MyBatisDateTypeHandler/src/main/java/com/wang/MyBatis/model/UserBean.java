package com.wang.MyBatis.model;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

public class UserBean implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private Date regTime;

	public UserBean() {

	}

	public UserBean(String username, String password, Date regTime) {
		this.username = username;
		this.password = password;
		this.regTime = regTime;

	}

	public UserBean(int id, String username, String password, String regTime) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public UserBean(int id, String username, String password, Date regTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.regTime = regTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}