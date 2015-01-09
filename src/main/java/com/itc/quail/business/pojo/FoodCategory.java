package com.itc.quail.business.pojo;

public class FoodCategory {
	
	private String id;
	
	private String foodCategory_name;
	
	private String serialNum;
	
	private String foodCategory_content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodCategory_name() {
		return foodCategory_name;
	}

	public void setFoodCategory_name(String foodCategory_name) {
		this.foodCategory_name = foodCategory_name;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getFoodCategory_content() {
		return foodCategory_content;
	}

	public void setFoodCategory_content(String foodCategory_content) {
		this.foodCategory_content = foodCategory_content;
	}

	public FoodCategory(String id, String foodCategory_name, String serialNum,
			String foodCategory_content) {
		super();
		this.id = id;
		this.foodCategory_name = foodCategory_name;
		this.serialNum = serialNum;
		this.foodCategory_content = foodCategory_content;
	}
	
	
	

}
