package com.wang.MyBatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wang.MyBatis.DefaultObjectFactory.ExampleObjectFactory;
import com.wang.MyBatis.model.UserBean;
import com.wang.MyBatis.model.UserMapper;
import com.wang.MyBatis.tools.DBTools;

public class App {

	public static Integer id = 0;

	public static void main(String[] args) {

		insertUser();
		// deleteUser();
		selectUserById();
		// selectAllUser();
	}

	/**
	 * 新增用户
	 */
	private static void insertUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		ExampleObjectFactory ex = new ExampleObjectFactory();
		UserBean p = (UserBean) ex.create(UserBean.class);
		System.out.println(p.getUsername());

		ArrayList arr = new ArrayList();
		arr.add("aaa");
		arr.add("bbb");
		arr.add("ccc");
		UserBean user = new UserBean("懿", "1314520", arr);
		try {
			id = mapper.insertUser(user);
			System.out.println(id + "	" + user.toString());
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
			UserBean user = mapper.selectUserById(id);
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
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

}