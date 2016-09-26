package com.yghsh.wx.util;

public class RayPathUtils {

	/**
	 * 获取自定义class的根路径
	 * */
	public static String getClassRootPath(){
		String path = RayPathUtils.class.getResource("/").toString();
		if (path.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
			path = path.substring(6);
		}
		return path ;
	}
	/**
	 * 获取自定义class路径
	 * */
	public static String getClassPath(Class<?> myclass){
		String path = myclass.getResource("").toString();
		if (path.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
			path = path.substring(6);
		}
		return path ;
	}
	
}
