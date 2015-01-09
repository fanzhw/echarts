package com.itc.quail.business.dao;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.itc.quail.business.pojo.product.ProductCategory;
import com.itc.quail.business.pojo.product.ProductCategoryMapper;

public class ProductCategoryDAO {

	private static JdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	public void save(ProductCategory type) {
		template.update(
				"insert into product_category(id,num,name,description,createtime,type) values(?,?,?,?,?,?)",
				new Object[] { type.getId(), type.getNum(), type.getName(),
						type.getDescription(), type.getCreateTime(),
						type.getType() }
		// new int[]
		// {java.sql.Types.INTEGER,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.DATE,java.sql.Types.VARCHAR}
		);
	}
/**
 * 根据序号查询类别信息
 * @param num
 * @return
 */
	public List<ProductCategory> getProductCategory(int num) {
		List<ProductCategory> list = template.query(
				"select * from product_category where num=? and type='0'",
				new ProductCategoryMapper(), new Object[] { num });
		return list;

	}

	public int edit(ProductCategory type) {
		// TODO Auto-generated method stub
		return template.update(
				"update product_category set num=?,set name=?,set description=? where id=?",
				new Object[] { type.getNum(), type.getName(),
						type.getDescription(), type.getId() });
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return template.update(
				"delete from product_category where id=? ",
				new Object[] { id });

	}

	public List<ProductCategory> getAllProductType() {
		List<ProductCategory> list = template.query(
				"select * from product_category where type='0' order by num",
				new ProductCategoryMapper());
		return list;
	}

	public int deleteByNums(Object[] ids) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from product_category ");
		if (ids != null && ids.length > 0) {
			sb.append("where ");
			for (int i = 0; i < ids.length; i++) {
				if (i != ids.length - 1) {
					sb.append("num = ? or ");
				} else {
					sb.append("num = ? ");
				}
			}
		}
		sb.append("and type='0'");
		return template.update(sb.toString(), ids);
	}

	public void updateNum(int num) {
		template.update(
				"update product_category set num=num+1 where type='0' and num>=?",
				new Object[] { num });
	}

	public List<ProductCategory> getProductCategoryByIds(String ids) {
		Object[] idArry = ids.split("#");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < idArry.length; i++) {
			sb.append("select * from product_category ");
			sb.append("where ");
			if (i != idArry.length - 1) {
				sb.append("id = ? or ");
			} else {
				sb.append("id = ? ");
			}
		}
		List<ProductCategory> list = template.query(sb.toString(), new ProductCategoryMapper(), idArry);
		return list;

	}
	
	public ProductCategory getProductCategoryById(String id){
		ProductCategory productCategory = template.queryForObject("select * from product_category where id=?", new ProductCategoryMapper(), new Object[]{id});
		return productCategory;
	}

}
