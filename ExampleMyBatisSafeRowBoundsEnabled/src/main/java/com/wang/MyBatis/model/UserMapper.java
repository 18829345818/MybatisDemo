package com.wang.MyBatis.model;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.wang.MyBatis.Bean.UserBean;

public interface UserMapper {
	/**
	 * 新增用戶
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(UserBean user) throws Exception;

	/**
	 * 修改用戶
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserBean user, int id) throws Exception;

	/**
	 * 刪除用戶
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int id) throws Exception;

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserBean selectUserById(int id) throws Exception;

	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<UserBean> selectAllUser() throws Exception;

	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<UserBean> selectAllUserRowBounds(RowBounds rowBounds) throws Exception;
}