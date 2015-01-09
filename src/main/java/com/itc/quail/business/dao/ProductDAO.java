package com.itc.quail.business.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.itc.quail.business.pojo.product.Product;
import com.itc.quail.business.pojo.product.ProductCategory;
import com.itc.quail.business.pojo.product.ProductCategoryMapper;
import com.itc.quail.business.pojo.product.ProductMapper;

public class ProductDAO {

	private static JdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	public int add(Product product) {
		List<ProductCategory> list = product.getCategorys();
		String category_id = "";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				category_id += list.get(i).getId();
				if (i < list.size()) {
					category_id += "#";
				}
			}
			return template
					.update("insert into product(id,num,name,category_id,price,description,createTime,dept_id,category_type) values(?,?,?,?,?,?,?,?,?)",
							new Object[] { product.getId(), product.getNum(),
									product.getName(), category_id,
									product.getPrice(),
									product.getDescription(),
									product.getCreateTime(),
									product.getDeptId(),
									product.getCategoryType() });
		} else {
			return -1;
		}
	}

	/**
	 * 获取所有菜品
	 * 
	 * @return
	 */
	public List<Product> getAllFood() {
		List<Product> list = template.query(
				"select * from product where category_type='0' order by num",
				new ProductMapper());
		return list;
	}

	/**
	 * 获取所有商品
	 * 
	 * @return
	 */
	public List<Product> getAllProduct() {
		List<Product> list = template.query(
				"select * from product where category_type='1'",
				new ProductMapper());
		return list;
	}

	/**
	 * 根据序号和物品类型进行删除
	 * 
	 * @param num
	 *            序号
	 * @param type
	 *            餐饮：0/小卖部：1
	 * @return
	 */
	public int deleteByNumAndType(int num, String type) {
		return template.update(
				"delete from product where num=? and category_type=?",
				new Object[] { num, type });
	}

	/**
	 * 删除多条
	 * 
	 * @param nums
	 * @param type
	 *            0：菜品删除 ，1：商品删除
	 * @return
	 */
	public int deleteByNums(int[] nums, String type) {
		if (nums.length > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("delete from product where ");
			for (int i = 0; i < nums.length; i++) {
				if (i != nums.length - 1) {
					sb.append("num = ? or ");
				} else {
					sb.append("num = ? ");
				}
			}
			sb.append("and type='" + type + "'");
			return template.update(sb.toString(), nums);
		} else {
			return -1;
		}
	}

	/**
	 * 编辑选中条目
	 * 
	 * @param product
	 */
	public void updateProduct(Product product) {
		List<ProductCategory> list = product.getCategorys();
		String category_id = "";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				category_id += list.get(i).getId();
				if (i < list.size()) {
					category_id += "#";
				}
			}
			template.update(
					"update product set num=?, category_id=?, name=?, price=?, description=? where id=?",
					new Object[] { product.getNum(), category_id,
							product.getName(), product.getPrice(),
							product.getDescription(), product.getId() });

		}
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public List<Product> getProduct(int num) {
		List<Product> list = template.query(
				"select * from product where num=? and category_type='0'",
				new ProductMapper(), new Object[] { num });
		return list;

	}

	/**
	 * 
	 * @param num
	 */
	public void updateNum(int num) {
		template.update(
				"update product set num=num+1 where category_type='0' and num>=?",
				new Object[] { num });
	}
	
	public List getAllCateId() {
		List list = template.queryForList("select DISTINCT(category_id) from product where category_type='0'");
		return list;

	}
}
