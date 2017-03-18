package com.wang.MyBatis.Bean;

public class Books {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bookName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
