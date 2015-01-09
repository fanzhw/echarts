package com.itc.quail.web.controller.foodcategory;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;




import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.itc.quail.business.pojo.product.ProductCategory;
import com.itc.quail.business.service.FoodCategoryService;

/*
 * 菜品类别控制层
 */
@ControllerAdvice
@RequestMapping("/foodCateController")
public class FoodCategoryController {
	
	
	FoodCategoryService foodCateService = new FoodCategoryService();
	
	public void setFoodCateService(FoodCategoryService foodCateService) {
		this.foodCateService = foodCateService;
	}

	private String content_type = "text/html;charset=UTF-8";
	
	@RequestMapping("/gotoFoodCategoryList")
	public ModelAndView gotoFoodCategoryList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelView = new ModelAndView();
//		List<FoodCategory> foodCateList = foodCateService.showFoodCateList("12");
//		request.setAttribute("foodCateList", foodCateList);
		modelView.setViewName("/food_home");
		return modelView;
	}
	
	/**
	 * 显示菜品类别列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/showFoodCateList")
	public void showFoodCategoryList(HttpServletRequest request, HttpServletResponse response){
		//User user = (User) request.getSession().getAttribute("user");
		//查看全部的菜品类别，无部门之分
		List<ProductCategory> foodCateList = foodCateService.showFoodCateList();
		String[][] resultArr = null;
		if(foodCateList!=null  && foodCateList.size()>0){
			resultArr = new String[foodCateList.size()][];
			for(int i = 0; i<foodCateList.size(); i++){
				String[] resultOne = new String[5];
				ProductCategory foodCate = foodCateList.get(i);
				resultOne[0] = "<input type='checkbox' id='"+foodCate.getId()+"' name='setCheckOne' onclick='setChecked(this)' value='"+foodCate.getId()+"'>";
				resultOne[1] = "<span class='text-center'>"+i+1+"</span>";
				resultOne[2] = "<span class='text-center'>"+foodCate.getName()+"</span>";
				resultOne[3] = "<span class='text-center'>"+foodCate.getDescription()+"</span>";
				//判断是否为系统默认菜品，默认菜品不可编辑，删除
				resultOne[4] = "<span class='text-center'><button type='button' class='btn btn-info btn-sm mr10'"
						+ "data-toggle='modal' data-target='#editcateModal' onclick='getFoodCateDetail(\""+foodCate.getId()+"\")'>编辑</button> "
					    + "<button type='button' class='btn btn-default btn-sm' onclick='confirmDelById(\""+foodCate.getId()+"\")'>删除</button></span>";
				resultArr[i] = resultOne;
			}
		}
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("aaData", resultArr);
	      json.put("iTotalRecords", resultArr.length);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
		
	}
	
	/**
	 * 添加菜品类别
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addFoodCategory")
	public void addFoodCategory(HttpServletRequest request, HttpServletResponse response){
		String serialNum = request.getParameter("serialNum");
		String foodCateName = request.getParameter("foodCateName");
		String foodCateContent = request.getParameter("foodCateContent");
		
		//判断serialNum在数据库中是否存在，若存在则所有序号后移
		isExistNum(serialNum);
		foodCateService.addFoodCategory(serialNum,foodCateName,foodCateContent);
		final String data = " {} ";  
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("status", "success");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}
	
	
	
	/**
	 * 根据序号删除菜品类别
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delFoodCategoryBySerialNum")
	public void delFoodCategoryBySerialNum(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		
		  int updateRow = foodCateService.delFoodCategoryBySerialNum(id);
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("status", updateRow);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}

	/**
	 * 根据id查询菜品类别具体信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getFoodCateById")
	public void getFoodCateById(HttpServletRequest request, HttpServletResponse response){
		 String id = request.getParameter("id");
		 ProductCategory productCategory = foodCateService.getFoodCategoryDetail(id);
		 final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("status", "success");
	      json.put("productCategory", productCategory);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}
	
	/**
	 * 根据id编辑菜品信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/editFoodCategoryBySerialNum")
	public void editFoodCategoryBySerialNum(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int updateRow = foodCateService.editFoodCategoryBySerialNum(id,num,name,description);
		
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      if(updateRow>0){
	         json.put("status", "success");
	      }
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}
	
	//批量删除菜品类别
	@RequestMapping("/delFoodCategoryBySerialNums")
	public void delFoodCategoryBySerialNums(HttpServletRequest request, HttpServletResponse response){
		  String nums = request.getParameter("serialNums");
		  String status = "fail";
		  String[] numList = nums.split("#");
		  Object[] serialNums = new Object[numList.length];
		  for(int i = 0;i<numList.length;i++){
			  Object num = Integer.parseInt(numList[i]);
			  serialNums[i] = num;
		  }
		  
		  int deleteRow = foodCateService.delFoodCategoryBySerialNums(serialNums);
		  
		  if(deleteRow>0){
				status="success";
			}
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("status", status);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
}

	public void isExistNum(String serialNum){
		int num = Integer.parseInt(serialNum);
		if(foodCateService.isExistNums(num)){
			foodCateService.updateNum(num);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getFoodCate")
	public void getFoodCate(HttpServletRequest request, HttpServletResponse response){
		List<ProductCategory> foodCateList = foodCateService.showFoodCateList();
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("foodCateList", foodCateList);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}
	/**
	 * 校验前台输入框传的数据是否合法
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkInput")
	public void checkInput(HttpServletRequest request, HttpServletResponse response){
		String serialNum = request.getParameter("num");
		String foodCateName = request.getParameter("name");
		String foodCateContent = request.getParameter("content");
		
		String message = "NONE";
		String rex = "/^[0-9]*[1-9][0-9]*$/";
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(serialNum);
		
		if (!m.matches()){
		    message="figure";
		}else if(foodCateName.length()>100){
			message= "namelength";
		}else if(foodCateContent.length()>200){
			message= "conlength";
		}
		message = "NONE";
		  final String data = " {} ";
	      final JSONObject json = JSONObject.fromObject(data);
	      json.put("message", message);
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType(content_type);
	      try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {

		}
	}
	
}