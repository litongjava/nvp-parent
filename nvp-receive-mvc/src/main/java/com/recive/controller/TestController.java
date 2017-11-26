package com.recive.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

@RestController
@RequestMapping("test")
public class TestController{
	private Log log=LogFactory.getLog(this.getClass());
	@Autowired
	private FreeMarkerConfig fc;
	@RequestMapping("/test1")
	public String test1(){
		log.info(fc.toString());
		return fc.toString();
	}
	@RequestMapping("test2")
	public String test2(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
}