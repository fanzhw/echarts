package com.itc.quail.business.pojo.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.itc.quail.business.dao.ProductCategoryDAO;

public class ProductMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		ProductCategoryDAO dao = new ProductCategoryDAO();
		List<ProductCategory> categoryList = dao.getProductCategoryByIds(rs
				.getString("category_id"));
		Product product = new Product(rs.getString("id"), rs.getInt("num"),
				rs.getString("name"), categoryList, rs.getDouble("price"),
				rs.getString("description"), rs.getString("createTime"),
				rs.getString("dept_id"), rs.getString("category_type"));
		return product;
	}
}
