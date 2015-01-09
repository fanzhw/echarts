package com.itc.quail.business.dao.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.itc.quail.business.pojo.demo.User;

public class UserDao{

	private JdbcTemplate template;
	
	public void setDataSource(DataSource dataSource){
		this.template = new JdbcTemplate(dataSource);
	}
	
	public void save(User user) {
		template.update("insert into person(name,age)values(?,?)",
                new Object[] { user.getName(), user.getAge()}, new int[] { java.sql.Types.VARCHAR,
                        java.sql.Types.INTEGER});
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> getUsers() {
		
        List<User> list = template.query("select * from user", new UserRowMapper());
        return list;

    }

}
