package com.yghsh.wx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

public class Sha1Util {
	 public static String SHA1_arrayOrder(ArrayList<String> list ){
		 StringBuffer sb = new StringBuffer();
		 //排序
		 Collections.sort(list); 
		 for(String s : list){
			 sb.append(s);
		 }
		 return Sha1Util.SHA1(sb.toString());
	 }
	 public static String SHA1(String decript) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-1");
	            digest.update(decript.getBytes());
	            byte messageDigest[] = digest.digest();
	            // Create Hex String
	            StringBuffer hexString = new StringBuffer();
	            // 字节数组转换为 十六进制 数
	            for (int i = 0; i < messageDigest.length; i++) {
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
	                if (shaHex.length() < 2) {
	                    hexString.append(0);
	                }
	                hexString.append(shaHex);
	            }
	            return hexString.toString();
	 
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
}
