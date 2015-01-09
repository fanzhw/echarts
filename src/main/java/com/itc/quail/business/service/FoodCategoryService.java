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
 * 菜品类别service层
 */
public class FoodCategoryService {
	
	@Autowired
	ProductCategoryDAO productTypeDao = new ProductCategoryDAO();
	
	@Autowired
	ProductDAO productDAO = new ProductDAO();
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public ProductCategoryDAO getProductTypeDao() {
		return productTypeDao;
	}

	public void setProductTypeDao(ProductCategoryDAO productTypeDao) {
		this.productTypeDao = productTypeDao;
	}
    
	public List<ProductCategory> showFoodCateList(){
		List<ProductCategory> foodCategoryList = productTypeDao.getAllProductType();
		return foodCategoryList;
	}
  
	/**
	 * 添加商品类别
	 * @param num
	 * @param name
	 * @param content
	 */
	public void addFoodCategory(String num,String name, String content){
		ProductCategory productType = new ProductCategory();
		Format format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String id = format.format(new java.util.Date());
		productType.setId(id);
		productType.setNum(Integer.parseInt(num));
		productType.setName(name);
		productType.setDescription(content);
		productType.setCreateTime(new Date(0).toString());
		productType.setType("0");
		productTypeDao.save(productType);
	}
	
	/**
	 * 根据某一序号删除菜品类别
	 * @param serialNum
	 * @return
	 */
    public int delFoodCategoryBySerialNum(String id){
    	//判断该类别是否有菜品引用，若有则不删除
    	List cateList = productDAO.getAllCateId();
    	String ids = "{category_id="+id+"#}";
    	boolean isHasCate  = cateList.contains(ids);
    	if(isHasCate){
    		return -1;
    	}else{
    	   return productTypeDao.deleteById(id);
    	}
	}
    
   /**
    * 根据序号批量删除菜品类别
    * @param serialNum
    * @return
    */
    public int  delFoodCategoryBySerialNums(Object[] serialNum){
    	return productTypeDao.deleteByNums(serialNum);
	}
    /**
     * 
     * @param serialNum
     */
    public int editFoodCategoryBySerialNum(String id,String serialNum,String name,String description){
    	ProductCategory productCategory = getFoodCategoryDetail(id);
    	int num = Integer.parseInt(serialNum);
    	if(productCategory.getNum()!=num && isExistNums(num)){
    		updateNum(num);
    	}
    	productCategory.setDescription(description);
    	productCategory.setName(name);
    	productCategory.setNum(num);
    	
    	int updateRow = productTypeDao.edit(productCategory);
    	if(updateRow>0){
    		return updateRow;
    	}else{
    		return -1;
    	}
    }
    
    public ProductCategory getFoodCategoryDetail(String id){
    	ProductCategory productCategory = productTypeDao.getProductCategoryById(id);
    	if(productCategory!=null){
    		return productCategory;
    	}
    	return productCategory;
    }
    public boolean isExistNums(int num){
    	List<ProductCategory> productCategory = productTypeDao.getProductCategory(num);
    	if(productCategory == null || productCategory.size()>0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void updateNum(int num){
    	productTypeDao.updateNum(num);
    }
}
