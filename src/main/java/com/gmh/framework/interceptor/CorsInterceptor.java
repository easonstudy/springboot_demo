package com.gmh.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CorsInterceptor extends HandlerInterceptorAdapter {

	 private final Logger logger = Logger.getLogger(CorsInterceptor.class);
	
	 @Override  
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	     //logger.info("CorsInterceptor preHandle");
	 	 //表明它允许跨域请求包含content-type头
		 response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		 //表明它允许"*"发起跨域请求
	     response.setHeader("Access-Control-Allow-Origin", "*");  
	     //表明在3628800秒内，不需要再发送预检验请求，可以缓存该结果
	     response.setHeader("Access-Control-Max-Age", "3000");   
	     //表明它允许GET、PUT、DELETE、POST的外域请求
	     response.setHeader("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST");    
		 return true;
	 }
}
