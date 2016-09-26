package com.yghsh.wx.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSONObject;

public class ModelAndViewUtil {
	
	private final static Logger logger = Logger.getLogger(ModelAndViewUtil.class);
	
	private static Integer SUCCESS = 200 ;
	private static Integer ERROR = 404 ;
	public  static Integer LOGIN = 500 ; //登陆才能访问，如果返回500，跳转前台页面
	
	public static ModelAndView json_result( Integer result , String mess ){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", result );
		mav.addObject("message" , mess );
		return mav ;
	}
	
	/**
	 * 返回json
	 * */
	public static ModelAndView json(Object obj){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject( obj );
		return mav ;
	}
	public static ModelAndView json_error( String mess ){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.ERROR );
		mav.addObject("message" , mess );
		return mav ;
	}
	
	public static ModelAndView json_error(String key , Object obj){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.ERROR );
		mav.addObject( key , obj );
		return mav ;
	}
	
	public static ModelAndView json_ok(){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.SUCCESS );
		return mav ;
	}
	
	public static ModelAndView json_ok(String key , Object obj){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.SUCCESS );
		mav.addObject( key , obj );
		logger.info(JSONObject.toJSONString(obj));
		return mav ;
	}
	
	public static ModelAndView json_ok( Map<String, Object> map ){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.SUCCESS );
		for( String key : map.keySet() ){
			mav.addObject( key , map.get(key) );
		}
		return mav ;
	}
	public static ModelAndView json_ok( List<?> list ){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", ModelAndViewUtil.SUCCESS );
		mav.addObject("list", list);
		logger.info(JSONObject.toJSONString(list));
		return mav ;
	}
	/**
	 * 返回JSP
	 * */
	public static ModelAndView Jsp(String jspPath){
		//return new ModelAndView( PropertiesUtils.getHshType()+"/" + jspPath );
		return new ModelAndView( jspPath );
	}

	public static ModelAndView Json_ok( GridDataModel<?> gdm ,String form ){
		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
		mav.addObject("result", "1");
		mav.addObject("total", gdm.getTotal());
		mav.addObject("rows", gdm.getRows());
		mav.addObject( form , null);
		return mav ;
	}
}