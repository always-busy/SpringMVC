package com.demo.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.demo.web.models.AccountModel;

@Controller
@RequestMapping(value="/databind")
public class DataBindController {

	@RequestMapping(value="parambind",method={RequestMethod.GET})
	public ModelAndView paraBind(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("parambind");
		return modelAndView;
	}
	
	@RequestMapping(value="/parambind",method={RequestMethod.POST})
	public ModelAndView paramBind(HttpServletRequest request,@RequestParam("urlParam")
		String urlParam,@RequestParam("formParam") 
		String formParam,@RequestParam("formFile") MultipartFile formFile){
		
		//如果不用注解的形式，还可以用手动获取数据
		String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam",null);
		String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
		MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("urlParam", urlParam);
		modelAndView.addObject("formParam", formParam);
		modelAndView.addObject("formFileName", formFile.getOriginalFilename());
		
		modelAndView.addObject("urlParam1", urlParam1);
		modelAndView.addObject("formParam1", formParam1);
		modelAndView.addObject("formFileName1", formFile1.getOriginalFilename());
		modelAndView.setViewName("parambindresult");
		return modelAndView;	
	}
	
	
	@RequestMapping(value="/modelautobind",method={RequestMethod.GET})
	public String modelAutoBind(HttpServletRequest request,Model model){
		
		model.addAttribute("accountmodel", new AccountModel());
		return "modelautobind";		
	}
	
	@RequestMapping(value="/modelautobind",method={RequestMethod.POST})
	public String modelAutoBind(HttpServletRequest request,Model model,AccountModel accountModel){
		
		model.addAttribute("accountmodel", accountModel);
		return "modelautobindresult";
		
	}
}
