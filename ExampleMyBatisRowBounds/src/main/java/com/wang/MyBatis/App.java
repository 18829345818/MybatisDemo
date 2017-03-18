package com.wang.MyBatis;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.wang.MyBatis.model.UserBean;
import com.wang.MyBatis.model.UserMapper;
import com.wang.MyBatis.tools.DBTools;

public class App {

	public static void main(String[] args) {
		/*
		 * insertUser(); // deleteUser(); selectUserById();
		 * 
		 * selectUserById();
		 */
		selectAllUser1();
	}

	/**
	 * 新增用户
	 */
	private static void insertUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean("懿", "1314520", 7000.0);
		try {
			mapper.insertUser(user);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 删除用户
	 */
	private static void deleteUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.deleteUser(1);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 根据id查询用户
	 */
	private static void selectUserById() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			UserBean user = mapper.selectUserById(12);
			mapper.selectUserById(12);
			mapper.selectUserById(12);
			if (null != user) {
				System.out.println(user.toString());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 查询所有的用户
	 */
	private static void selectAllUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<UserBean> user = mapper.selectAllUser();
			System.out.println(user.size());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 查询所有的用户
	 */
	private static void selectAllUser1() {

		SqlSession session = DBTools.getSession();
		try {
			int offset = 1;
			int limit = 2;
			RowBounds rowBounds = new RowBounds(offset, limit);
			List<UserBean> user = session.selectList("selectAllUser", null, rowBounds);

			System.out.println(user.size());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

}