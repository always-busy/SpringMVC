package com.demo.web.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.web.models.ValidateModel;

@Controller
@RequestMapping(value="/validate")
public class ValidateController {
	
	@RequestMapping(value="/test",method={RequestMethod.GET})
	public String test(Model model){
		if(!model.containsAttribute("contentModel")){
			model.addAttribute("contentModel", new ValidateModel());
		}
		return "validatetest";	
	}
	
	//@Valid 意思是在把数据绑定到@ModelAttribute("contentModel") 后就进行验证。
	@RequestMapping(value="/test",method={RequestMethod.POST})
	public String test(Model model,@Valid @ModelAttribute("contentModel") ValidateModel validateModel,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return test(model);
		}
		return "validatesuccess";
		
	}
}
