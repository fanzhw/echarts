package com.itc.quail.business.service;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itc.quail.business.dao.ProductCategoryDAO;
import com.itc.quail.business.dao.ProductDAO;
import com.itc.quail.business.pojo.product.Product;
import com.itc.quail.business.pojo.product.ProductCategory;

/*
 * @author tangly
 * 
 * 菜品service层
 */
public class FoodService {
	
	@Autowired
	ProductDAO productDao = new ProductDAO();
	
	@Autowired
	ProductCategoryDAO productTypeDao = new ProductCategoryDAO();
	
	
	
	public ProductCategoryDAO getProductTypeDao() {
		return productTypeDao;
	}

	public void setProductTypeDao(ProductCategoryDAO productTypeDao) {
		this.productTypeDao = productTypeDao;
	}
	
	
	public List<Product> showFoodList(){
		List<Product> foodList = productDao.getAllFood();
		return foodList;
	}
  
	/**
	 * 添加商品类别
	 * @param num
	 * @param name
	 * @param content
	 */
	public void addFood(String num,String name, String content,String price,String foodCate){
		Product product = new Product();
		ProductCategory productCategory = productTypeDao.getProductCategoryById(foodCate);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		double foodPrice = Double.parseDouble("1.023");
		Format format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String id = format.format(new java.util.Date());
		product.setId(id);
		product.setNum(Integer.parseInt(num));
		product.setName(name);
		product.setDescription(content);
		product.setPrice(foodPrice);
		product.setCreateTime(new Date(0).toString());
		product.setCategoryType("0");
		product.setCategorys(productCategoryList);
		
		productDao.add(product);
		
	}
	
	/**
	 * 根据某一序号删除菜品类别
	 * @param serialNum
	 * @return
	 */
   /* public int delFoodCategoryBySerialNum(int serialNum){
    	//return productTypeDao.deleteByNum(serialNum);
    	
	}*/
    
   /**
    * 根据序号批量删除菜品类别
    * @param serialNum
    * @return
    */
   /* public int  delFoodCategoryBySerialNums(Object[] serialNum){
    	//eturn productTypeDao.deleteByNums(serialNum);
	}*/
    /**
     * 
     * @param serialNum
     */
   /* public int editFoodCategoryBySerialNum(String id,String serialNum,String name,String description){
    	ProductCategory productCategory = getFoodCategoryDetail(id);
    	int num = Integer.parseInt(serialNum);
    	if(productCategory.getNum()!=num && isExistNums(num)){
    		updateNum(num);
    	}
    	productCategory.setDescription(description);
    	productCategory.setName(name);
    	productCategory.setNum(num);
    	
    	//int updateRow = productTypeDao.edit(productCategory);
    	if(updateRow>0){
    		return updateRow;
    	}else{
    		return -1;
    	}
    }*/
    
   /* public ProductCategory getFoodCategoryDetail(String id){
    	List<ProductCategory> productCategoryList = productTypeDao.getProductCategoryById(id);
    	ProductCategory productCategory = null;
    	if(productCategoryList!=null&&productCategoryList.size()>0){
    		productCategory = productCategoryList.get(0);
    	}
    	return productCategory;
    }
    */
    public boolean isExistNums(int num){
    	List<Product> product = productDao.getProduct(num);
    	if(product == null || product.size()>0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void updateNum(int num){
    	productDao.updateNum(num);
    }
}
