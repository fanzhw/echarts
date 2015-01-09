package com.itc.quail.web.controller.demo;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minxing.connector.ocu.OcuAccount;
import com.minxing.connector.ocu.TextMessage;
import com.minxing.connector.ocu.User;
import com.minxing.connector.utils.HMACSHA1;
import com.minxing.connector.utils.OcuConfig;
import com.minxing.connector.utils.StringUtil;
import com.minxing.connector.utils.UrlEncoder;

@ControllerAdvice
@RequestMapping("/test")
public class OperateMessageControllerTest {
	

	protected String ocuId = OcuConfig.getValue("OcuID");
	  protected String ocuSecret = OcuConfig.getValue("OcuSecret");
	  
  @RequestMapping("/sendMessage")
	public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 InputStream in = request.getInputStream();
		 //String s=IOUtils.toString(in, "utf-8");
		 
//		 String s = InputStreamTOString(in, "utf-8");
	  String open_id = checkSignature(request);
      OcuAccount  oa  =  new OcuAccount();
      User user = oa.getUserInfo(request.getParameter("open_id"));
      
      TextMessage tm = new TextMessage(open_id+" << "+user.getCellPhone());
      oa.setRootUrl("http://10.0.0.7"); 
      oa.setApiPrefix("/api/v1");
      oa.setOcuId("d5fafe71ff6530e9ae8d56c140a9a49e");
      oa.setOcuSecret("a43396c1faebfe70ef35a2a83bb0aa1d");
     //  oa.sendMessageToPublic(tm);
	
   }
  
  
  public  String InputStreamTOString(InputStream in,String encoding) throws Exception{ 
      ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
      byte[] data = new byte[1024]; 
      int count = -1; 
      while((count = in.read(data,0,1024)) != -1) 
          outStream.write(data, 0, count); 
      data = null; 
      return new String(outStream.toByteArray(),"utf-8"); 
  }
  
  
  public String checkSignature(HttpServletRequest request)
  {
    String token = null;
    String timestamp = null;
    String nonce = null;
    String openId = null;

    if ((request != null) && (request.getMethod().equals("GET"))) {
      try {
        token = UrlEncoder.encode(StringUtil.pathDecode(request.getParameter("token")));
        timestamp = request.getParameter("timestamp");
        nonce = request.getParameter("nonce");
        openId = StringUtil.pathDecode(request.getParameter("open_id"));
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return null;
      }
    }
    else if ((request != null) && (request.getMethod().equals("POST"))) {
      token = request.getHeader("token");
      timestamp = request.getHeader("timestamp");
      nonce = request.getHeader("nonce");
      openId = request.getHeader("open_id");
    }

    if ((token == null) || (timestamp == null) || (nonce == null) || (openId == null)) {
      return null;
    }

    String sign = HMACSHA1.getSignature(timestamp + nonce, this.ocuSecret);
    String t = UrlEncoder.encode(this.ocuId + ":" + sign);
    if (t.equals(token)) {
      return openId;
    }
    if(token.equals(t)){
    	return openId;
    }
    return null;
  }
  
  public void setOcuId(String ocuId) {
      this.ocuId = ocuId;
    }
  
  public void setOcuSecret(String ocuSecret) {
      this.ocuSecret = ocuSecret;
    }
  
  
  
}
