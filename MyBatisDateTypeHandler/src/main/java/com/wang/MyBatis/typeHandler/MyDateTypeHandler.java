package com.wang.MyBatis.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedJdbcTypes({ JdbcType.VARCHAR })
@MappedTypes({ Date.class })
public class MyDateTypeHandler extends BaseTypeHandler<Date> {
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType)
			throws SQLException {
		System.out.println("setNonNullParameter 1");
		preparedStatement.setString(i, String.valueOf(date.getTime()));
		System.out.println(preparedStatement);
	}

	public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
		System.out.println("setNonNullParameter 2");
		return new Date(resultSet.getLong(s));
	}

	public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
		System.out.println("setNonNullParameter 3");
		return new Date(resultSet.getLong(i));
	}

	public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		System.out.println("setNonNullParameter 4");
		return callableStatement.getDate(i);
	}
}