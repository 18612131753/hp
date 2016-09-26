package com.yghsh.wx.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * springMVC过滤器
 * */
public class SpringMVCFliterInterceptor extends HandlerInterceptorAdapter {

	@Override
	//实现预处理，
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response, 
		Object handler 
	) throws Exception {
		return true;
	}
	
	@Override
	//后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView
	public void postHandle(    
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		ModelAndView modelAndView
	) throws Exception {
		
    }
	
	@Override
	//返回处理（已经渲染了页面） 
    public void afterCompletion(    
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler,
		Exception ex
	)throws Exception {
    	
    }   
}
