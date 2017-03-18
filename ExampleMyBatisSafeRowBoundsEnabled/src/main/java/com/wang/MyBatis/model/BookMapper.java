package com.wang.MyBatis.model;

import com.wang.MyBatis.Bean.Books;

public interface BookMapper {
	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Books selectBookById(int id) throws Exception;

}
