package com.yghsh.wx.util;

import java.io.UnsupportedEncodingException;

public class EncodingUtil {

	/**
	 * @param text   字符串
	 * @param sCode  原编码
	 * @param tCode  转成编码
	 * */
	public static String changCode( String text , String sCode , String tCode ){
		try {
			return new String( text.getBytes(sCode) , tCode );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
}
