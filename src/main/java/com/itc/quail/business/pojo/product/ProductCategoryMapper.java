package com.itc.quail.business.pojo.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itc.quail.business.pojo.demo.User;

public class ProductCategoryMapper implements RowMapper{

	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		ProductCategory productCategory = new ProductCategory(rs.getString("id"),rs.getInt("num"),rs.getString("name"),rs.getString("description"), rs.getString("createTime"),rs.getString("type"));
		return productCategory;
	}
}
