package com.demo.web.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.web.auth.AuthPassport;

/**
 * @author ZKX
 *
 */
@Controller
	// 这表示对该controller的所有action请求必须是以"/helloworld”开始。
@RequestMapping(value = "/helloworld")
public class HelloWorldController extends BaseController{

	//对该Action设置了两个映射
	@AuthPassport
	@RequestMapping(value={"/index","/hello"})
    public ModelAndView index() throws SQLException{
		
		throw new SQLException("database error");
		
//		ModelAndView modelAndView = new ModelAndView();  
//		modelAndView.addObject("message", "Hello World!");  
//		modelAndView.setViewName("index");  
//        return modelAndView;
    }
	//传递id的值
	@RequestMapping(value = "/detail/{id}",method = {RequestMethod.GET})
	public ModelAndView getDetail(@PathVariable(value ="id") Integer id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("detail");
		return modelAndView;
	}
	
	@AuthPassport
	//Spring MVC会按照最长匹配优先原则（即和映射配置中哪个匹配的最多）
	@RequestMapping(value = "/*",method = {RequestMethod.GET})
	public ModelAndView urlTest(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("urltest");
		
		return modelAndView;	
	}
	
	//Spring MVC还支持正则表达式方式的映射配置
	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}",method={RequestMethod.GET})
	public ModelAndView regUrlTest(@PathVariable(value="name") String name,
			@PathVariable(value="age") Integer age){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.addObject("age", age);
		modelAndView.setViewName("regurltest");
		return modelAndView;
		
	}
	
	// 请求中必须带有参数的情况
	@RequestMapping(value="/paramstest",params="example",method={RequestMethod.GET})
	public ModelAndView paramsTest(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paramstest");
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
}
