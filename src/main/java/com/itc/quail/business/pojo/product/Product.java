package com.itc.quail.business.pojo.product;

import java.util.List;

public class Product {

	private String id;
	private int num;// 序号
	private String name;
	private List<ProductCategory> categorys;
	private double price;
	private String description;
	private String createTime;
	private String deptId;
	private String categoryType;//区分餐饮，小卖部
	
	public Product() {
		super();
	}

	public Product(String id, int num, String name,
			List<ProductCategory> categorys, double price, String description,
			String createTime, String deptId, String categoryType) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.setCategorys(categorys);
		this.price = price;
		this.description = description;
		this.createTime = createTime;
		this.deptId = deptId;
		this.categoryType = categoryType;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<ProductCategory> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<ProductCategory> categorys) {
		this.categorys = categorys;
	}

}
