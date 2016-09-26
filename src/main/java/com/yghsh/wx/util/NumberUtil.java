package com.yghsh.wx.util;

public class NumberUtil {
	public static void main(String[] args ){
		System.out.println( NumberUtil.strToInteger("-8.1"));
	}
	
	public static Double strToDouble( String str ){
		str = str.replaceAll("万", "").replaceAll("%", "");
		Double d ;
		try {
			d = Double.valueOf( str );
		} catch (NumberFormatException e) {
			d = 0.0 ;
		}
		return d ;
	}
	
	public static Integer strToInteger( String str ){
		Integer d ;
		try {
			if( str.indexOf(".") >0 ){
				str = str.substring(0, str.indexOf("."));
			}
			d = Integer.valueOf( str );
		} catch (NumberFormatException e) {
			e.printStackTrace();
			d = 0 ;
		}
		return d ;
	}
}
