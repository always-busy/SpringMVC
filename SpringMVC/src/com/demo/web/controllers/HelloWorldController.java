package com.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZKX
 *
 */
@Controller
	// ���ʾ�Ը�controller������action�����������"/helloworld����ʼ��
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

	//�Ը�Action����������ӳ��
	@RequestMapping(value={"/index","/hello"}, method = {RequestMethod.POST})
    public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("message", "Hello World!");  
		modelAndView.setViewName("index");  
        return modelAndView;
    }
	//����id��ֵ
	@RequestMapping(value = "/detail/{id}",method = {RequestMethod.GET})
	public ModelAndView getDetail(@PathVariable(value ="id") Integer id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("detail");
		return modelAndView;
	}
	
	//Spring MVC�ᰴ���ƥ������ԭ�򣨼���ӳ���������ĸ�ƥ�����ࣩ
	@RequestMapping(value = "/*",method = {RequestMethod.GET})
	public ModelAndView urlTest(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("urltest");
		
		return modelAndView;	
	}
	
	//Spring MVC��֧���������ʽ��ʽ��ӳ������
	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}",method={RequestMethod.GET})
	public ModelAndView regUrlTest(@PathVariable(value="name") String name,
			@PathVariable(value="age") Integer age){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.addObject("age", age);
		modelAndView.setViewName("regurltest");
		return modelAndView;
		
	}
	
	// �����б�����в��������
	@RequestMapping(value="/paramstest",params="example",method={RequestMethod.GET})
	public ModelAndView paramsTest(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paramstest");
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
}