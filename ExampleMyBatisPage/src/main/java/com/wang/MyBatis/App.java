package com.wang.MyBatis;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.wang.MyBatis.Page.Page;
import com.wang.MyBatis.model.UserBean;
import com.wang.MyBatis.model.UserMapper;
import com.wang.MyBatis.tools.DBTools;

public class App {

	public static void main(String[] args) {
		//for(int i=0;i<100;i++)
		 insertUser();
		/*
		 * insertUser(); // deleteUser(); selectUserById();
		 * 
		 * selectAllUserByIdRow();
		 */
		selectAllUserPage();
	}

	/**
	 * 新增用户
	 */
	private static void insertUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean("懿", "1314520", 7000.0);
		try {
			for (int i = 0; i < 1000; i++) {
				mapper.insertUser(user);
				user.setAccount(user.getAccount() + i);
			}
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
	 * 根据id查询用户
	 */
	private static void selectAllUserByIdRow() {
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
	private static void selectAllUserPage() {

		Page u1 = new Page();
		u1.setPageIndex(2);// 查询第几页
		u1.setPageSize(2);// 分布每页的条数
		int startNum = (u1.getPageIndex() - 1) * u1.getPageSize() + 1;
		int endNum = u1.getPageIndex() * u1.getPageSize();
		u1.setStartNum(startNum);
		u1.setEndNum(endNum);

		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<UserBean> user = mapper.selectAllUserPage(u1);
			System.out.println(user.size());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

}