package com.itc.quail.web.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itc.quail.business.pojo.FoodCategory;
import com.itc.quail.business.pojo.demo.User;
import com.itc.quail.business.service.FoodCategoryService;

@ControllerAdvice
@RequestMapping("/productCateController")
public class PruductCategoryController {
	
	FoodCategoryService foodCateService = new FoodCategoryService();
	private String content_type = "text/html;charset=UTF-8";
	
	@RequestMapping("/gotoProductCategoryList")
	public ModelAndView gotoProductCategoryList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelView = new ModelAndView();
//		List<FoodCategory> foodCateList = foodCateService.showFoodCateList("12");
//		request.setAttribute("foodCateList", foodCateList);
		modelView.setViewName("/product_category");
		return modelView;
	}
	
	
	@RequestMapping("/showProductCateList")
	public void showProductCateList(HttpServletRequest request, HttpServletResponse response){
		
	}

}
