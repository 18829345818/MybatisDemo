package com.wang.MyBatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import com.wang.MyBatis.model.UserBean;
import com.wang.MyBatis.model.UserMapper;
import com.wang.MyBatis.tools.DBTools;

public class App {

	public static void main(String[] args) {
		//init();
		selectUserByCondition(160.0,170.0,"male","南京");
		selectUserByCondition(160.0,170.0,null,"南京");
		selectUserByCondition(160.0,170.0,"male",null);
		
		
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);ids.add(2);ids.add(3);ids.add(4);
		selectUserByIDs(ids);
		
		selectUserByIDs(null);
		
		selectUserByChooseCondition(160.0,170.0,"male","南京");
		
		selectUserByChooseCondition(160.0,170.0,null,"南京");
		
		selectUserByChooseCondition(160.0,170.0,"male",null);
		
		UserBean user = new UserBean("小明", "1314520", getRandom(6000,7000)+0.0);
		user.setId(1);
		user.setHigh(getRandom(170,175)+0.0);
		user.setSex(getRandom(170,175)%2==0?"male":"fmale");
		user.setCityName("北京");
		
		UpdateByIdCondition(user);
	}
	
	private static void init(){
		SqlSession session = DBTools.getSession();
		for(int i=0;i<100;i++){
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean("小明"+i, "1314520", getRandom(6000,7000)+0.0);
		user.setHigh(getRandom(170,175)+0.0);
		user.setSex(getRandom(170,175)%2==0?"male":"fmale");
		user.setCityName((getRandom(170,175)%2==0?"南京":"上海"));
		try {
			mapper.insertUser(user);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		}
		
	}
	
	public static  int getRandom(int min,int max) {
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }

	/**
	 * 根据id查询用户
	 */
	private static void selectUserByCondition(Double minhigh,Double maxhigh,String sex,String cityName) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			Map<String, Object> params =new HashMap<String, Object>();
			params.put("minhigh", minhigh);
			params.put("maxhigh", maxhigh);
			params.put("sex", sex);
			params.put("cityName", cityName);
			List<UserBean> users = mapper.selectUserByCondition(params);
			if (null != users) {
				System.out.println(users.size());
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
	private static void selectUserByChooseCondition(Double minhigh,Double maxhigh,String sex,String cityName) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			Map<String, Object> params =new HashMap<String, Object>();
			params.put("minhigh", minhigh);
			params.put("maxhigh", maxhigh);
			params.put("sex", sex);
			params.put("cityName", cityName);
			List<UserBean> users = mapper.selectUserByChooseCondition(params);
			if (null != users) {
				System.out.println(users.size());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
	
	/**
	 * 根据id列表查询用户
	 */
	private static void selectUserByIDs(List<Integer> ids) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<UserBean> users = mapper.selectUserByIDs(ids);
			if (null != users) {
				System.out.println(users.size());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
	
	/**
	 * 根据id列表查询用户
	 */
	private static void UpdateByIdCondition(UserBean bean) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			int users = mapper.UpdateByIdCondition(bean);
			System.out.println(users);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
}