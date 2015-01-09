package com.itc.quail.business.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.itc.quail.business.pojo.user.User;

public class UserDAO {

	private JdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public int createUser(User user) {
		int i = template.update("insert into user(minxing_id,username,def1,def2)values(?,?,?,?)",
                new Object[] { user.getUserName(), user.getUserId(),user.getDef1(),user.getDef2()});
//		, new int[] { java.sql.Types.VARCHAR,java.sql.Types.INTEGER}
		return i;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
