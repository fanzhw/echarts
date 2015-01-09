package com.itc.quail.business.dao.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itc.quail.business.pojo.demo.User;

public class UserRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		User user = new User(rs.getString("id"),rs.getString("name"),rs.getInt("age"));
		return user;
	}

}
