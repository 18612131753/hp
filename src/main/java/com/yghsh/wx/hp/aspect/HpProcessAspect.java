package com.yghsh.wx.hp.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import com.yghsh.wx.hp.model.HpUser;
import com.yghsh.wx.util.ModelAndViewUtil;
import com.yghsh.wx.util.SessionUtil;

@Aspect
@Service("HpProcessAspect")
public class HpProcessAspect {

	private final static org.apache.log4j.Logger logger = 
		org.apache.log4j.Logger.getLogger(HpProcessAspect.class);
	
	@Around("@annotation(com.yghsh.wx.hp.aspect.HpProcess)")
	public Object checkLogin(ProceedingJoinPoint pjp )throws Throwable{
		Object obj=null;
		Object[] args = pjp.getArgs();
		//controller方法的参数请确认第一个必须为request，第二个为response
		HttpServletRequest  request  = (HttpServletRequest) args[0];
		HttpServletResponse response = (HttpServletResponse)args[1];
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		logger.info("LoginAspect拦截登录:" + request.getRequestURL().toString()+" "+ method.getName() );

		//扫描方法上是否有注解
		if( method.isAnnotationPresent(HpProcess.class) ){
			HpProcess info = method.getAnnotation(HpProcess.class);
			logger.info( "method:"+method.getName() );
			boolean login = info.needLogin();
			if( login ){ //需要登录状态，默认为false
				HpUser user = SessionUtil.getUserSession( request.getSession());
				if( user == null){
					logger.info("没有登陆，跳转登陆页");
					if( info.isAjax() ){
						return ModelAndViewUtil.json_result( ModelAndViewUtil.LOGIN , "不登陆无法访问" ) ;
					} else {
						response.sendRedirect(request.getContextPath()+"/hp/login/in");
						return null ;
					}
				}
			}
		}
		obj=pjp.proceed();
		return obj;
	}

}