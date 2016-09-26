package com.yghsh.wx.hp.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE,METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HpProcess{
	
	/**
	 * 判断是否登陆
	 * */
	boolean needLogin() default false ;

	/**
	 * 判断是否是AJAX还是JSP跳转
	 * */
	boolean isAjax() default false ;
}
