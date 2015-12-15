package com.demo.web.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

	@ExceptionHandler
	public String exception(HttpServletRequest request,Exception e){
		request.setAttribute("exceptionMessage", e.getMessage());
		
		if(e instanceof SQLException)
			return "errortest";
		else
			return "error";
	}
}
