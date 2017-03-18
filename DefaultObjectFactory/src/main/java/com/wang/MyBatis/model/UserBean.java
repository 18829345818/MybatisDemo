package com.wang.MyBatis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class UserBean implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private List<String> hobies;

	public UserBean() {

	}

	public UserBean(String username, String password, ArrayList<String> hobies) {
		this.username = username;
		this.password = password;
		this.hobies = hobies;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<String> getHobies() {
		return hobies;
	}

	public void setHobies(List<String> hobies) {
		this.hobies = hobies;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}