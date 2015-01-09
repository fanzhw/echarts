package com.itc.quail.business.pojo.product;

public class ProductCategory {
	
	private String id;
	
	private int num;
	private String name;
	private String description;
	private String createTime;
	private String type;//产品种类(0:餐饮;1:小卖部)
	
	
	public ProductCategory() {
		super();
	}
	public ProductCategory(String id, int num, String name, String description,
			String createTime, String type) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
