package com.demo.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
			
			//û��������ҪȨ�ޣ�������������֤Ȩ��
			if(authPassport==null || authPassport.validate()==false)
				return true;
			else{
				//�����֤ʧ��
				//���ص���½����
				response.sendRedirect("account/login");
				return false;
			}
		}
		else 
			return true;
	}

	
}
