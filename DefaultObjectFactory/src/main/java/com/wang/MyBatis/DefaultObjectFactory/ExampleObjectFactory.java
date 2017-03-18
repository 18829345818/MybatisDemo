package com.wang.MyBatis.DefaultObjectFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.wang.MyBatis.model.UserBean;

public class ExampleObjectFactory extends DefaultObjectFactory {

	@Override
	public Object create(Class type) {
		if (type.equals(UserBean.class)) {
			UserBean p = (UserBean) super.create(type);
			p.setUsername("wangjiuyong");
			return p;
		}
		return super.create(type);
	}

	@Override
	public void setProperties(Properties properties) {
		Iterator iterator = properties.keySet().iterator();
		while (iterator.hasNext()) {
			String keyValue = String.valueOf(iterator.next());
			System.out.println(properties.getProperty(keyValue));
		}
		super.setProperties(properties);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}

}
