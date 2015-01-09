package com.itc.quail.business.pojo.support;

import com.itc.quail.business.pojo.product.Product;
import com.itc.quail.business.pojo.product.ProductCategory;

public class SupportList {

	private String id;
	private String listNo;// 供货条目编号
	private String reservedTime;
	private ProductCategory category;
	private Product product;

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}

	public String getReservedTime() {
		return reservedTime;
	}

	public void setReservedTime(String reservedTime) {
		this.reservedTime = reservedTime;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
