package com.wang.MyBatis.model;

import java.io.Serializable;

public class UserBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private Double account;
    private Double high;
    private String sex;
    private String cityName;
    
    public UserBean() {
        super();
    }
    
    public UserBean(String username, String password, Double account) {
        super();
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public UserBean(Integer id, String username, String password, Double account) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
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

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }
    
    

    public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username + ", password="
                + password + ", account=" + account + "]";
    }
    
    
    

}