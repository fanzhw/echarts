package com.itc.quail.business.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.itc.quail.business.pojo.support.SupportList;

public class SupportListDAO {

	private static JdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	public int add(SupportList sl) {
		return template
				.update("insert into support_list(id,list_no,reservedTime,category_id,product_id,category_type) values(?,?,?,?,?,?)",
						new Object[] {});
	}

	
}
