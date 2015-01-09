package com.itc.quail.web.controller.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@ControllerAdvice
@RequestMapping("/loginController")
public class LoginController {
	
	private String content_type = "text/html;charset=UTF-8";
	private String failcause = "NONE";
	@RequestMapping("/login")
	public void checkLogin(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("user", "user");//查询获取的user对象
      final String data = " {} ";
      
      final JSONObject jsonObj = JSONObject.fromObject(data);
      jsonObj.put("failcause", failcause);
      final JSONArray json = JSONArray.fromObject(jsonObj);
      response.setCharacterEncoding("UTF-8");
      response.setContentType(content_type);
      try {
		response.getWriter().print(json.toString());
	} catch (IOException e) {

	}
	}

}
