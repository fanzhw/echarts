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

import com.itc.quail.business.pojo.product.Product;
import com.itc.quail.business.pojo.product.ProductCategory;
import com.itc.quail.business.service.FoodCategoryService;
import com.itc.quail.business.service.FoodService;

@ControllerAdvice
@RequestMapping("/foodController")
public class FoodController {
	
	FoodService foodService = new FoodService();
	private String content_type = "text/html;charset=UTF-8";
	
	@RequestMapping("/showFoodList")
	public void showFoodList(HttpServletRequest request, HttpServletResponse response){
		List<Product> foodList = foodService.showFoodList();
		String[][] resultArr = null;
		if(foodList!=null  && foodList.size()>0){
			resultArr = new String[foodList.size()][];
			for(int i = 0; i<foodList.size(); i++){
				String[] resultOne = new String[7];
				Product food = foodList.get(i);
				resultOne[0] = "<input type='checkbox' id='"+food.getNum()+"' name='setCheckOne' onclick='setChecked(this)' value='"+food.getId()+"'>";
				resultOne[1] = "<span class='text-center'>"+food.getNum()+"</span>";
				resultOne[2] = "<span class='text-center'>"+food.getName()+"</span>";
				List<ProductCategory> foodCategory = food.getCategorys();
				StringBuffer sBuffer = new StringBuffer();
				for(int j = 0;j<foodCategory.size();j++){
					sBuffer.append(foodCategory.get(j).getName()+",");
				}
				resultOne[3] = "<span class='text-center'>"+sBuffer.toString()+"</span>";
				resultOne[4] = "<span class='text-center'>"+food.getPrice()+"</span>";
				resultOne[5] = "<span class='text-center'>"+food.getDescription()+"</span>";
				resultOne[6] = "<span class='text-center'><button type='button' class='btn btn-info btn-sm mr10'"
						+ "data-toggle='modal' data-target='#editcateModal' onclick='getFoodCateDetail(\""+food.getId()+"\")'>编辑</button> "
					    + "<button type='button' class='btn btn-default btn-sm' onclick='confirmDelBySerialNum(\""+food.getNum()+"\")'>删除</button></span>";
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
	
	@RequestMapping("/addFood")
	public void addFood(HttpServletRequest request, HttpServletResponse response){
		String serialNum = request.getParameter("serialNum");
		String foodName = request.getParameter("foodName");
		String foodContent = request.getParameter("foodContent");
		String price = request.getParameter("price");
		String foodCate = request.getParameter("foodCate");
		
		//判断serialNum在数据库中是否存在，若存在则所有序号后移
		isExistNum(serialNum);
		foodService.addFood(serialNum,foodName,foodContent,price,foodCate);
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
	 * 校验前台输入框传的数据是否合法
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkInput")
	public void checkInput(HttpServletRequest request, HttpServletResponse response){
		String serialNum = request.getParameter("num");
		String foodName = request.getParameter("name");
		String foodContent = request.getParameter("content");
		String price = request.getParameter("price");
		
		String message = "NONE";
		String rex = "/^[0-9]*[1-9][0-9]*$/";
		String rex1 = "/^\\d+(\\.\\d{2})?$/";
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(serialNum);
		
		Pattern p2 = Pattern.compile(rex1);
		Matcher m2 = p.matcher(price);
		
		if (!m.matches()){
		    message="figure";
		}else if(foodName.length()>45){
			message= "namelength";
		}else if(foodContent.length()>200){
			message= "conlength";
		}else if(serialNum==null||foodName==null){
			message="empty";
		}else if(!m2.matches()){
			message="price";
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
	
	public void isExistNum(String serialNum){
		int num = Integer.parseInt(serialNum);
		if(foodService.isExistNums(num)){
			foodService.updateNum(num);
		}
	}
}
