package com.itc.quail.web.controller.microService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itc.quail.business.service.FoodCategoryService;

@ControllerAdvice
@RequestMapping("/microServiceController")
public class MicroServiceController {
	
	FoodCategoryService foodCateService = new FoodCategoryService();
	private String content_type = "text/html;charset=UTF-8";
	
	@RequestMapping("/gotoMicroServiceList")
	public ModelAndView gotoMicroServiceList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelView = new ModelAndView();
//		List<FoodCategory> foodCateList = foodCateService.showFoodCateList("12");
//		request.setAttribute("foodCateList", foodCateList);
		modelView.setViewName("/microService");
		return modelView;
	}
	
	
	@RequestMapping("/showMicroServiceList")
	public void showMicroServiceList(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping("/addFoodCategory")
	public void addFoodCategory(HttpServletRequest request, HttpServletResponse response){
		
	}

}
