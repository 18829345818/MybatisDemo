package com.wang.MyBatis.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedJdbcTypes({ JdbcType.VARCHAR })
@MappedTypes({ List.class })
public class MyListTypeHandler extends BaseTypeHandler<List<String>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType)
			throws SQLException {
		System.out.println("1");
		ps.setString(i, parameter.toString());
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		String columnConetnt = rs.getString(columnName);
		List<String> result = new ArrayList<String>();
		if (null != columnName) {
			String subString = columnConetnt.substring(1, columnConetnt.length() - 1);
			if (null != subString) {
				String[] hobies = subString.split(",");
				for (String hoby : hobies) {
					result.add(hoby);
				}
			}
		}
		return result;
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("3" + rs.getString(columnIndex));
		return null;
	}

	@Override
	public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("4" + cs.getString(columnIndex));
		return null;
	}
}