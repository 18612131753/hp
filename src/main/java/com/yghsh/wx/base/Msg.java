package com.yghsh.wx.base;

public class Msg {
	
	private Integer resultCode ;
	private String message ;
	private Object data ;
	
	public Msg(Integer resultCode, String message){
		this.resultCode = resultCode;
		this.message = message ;
	}
	
	public Msg(Integer resultCode, String message , Object data){
		this.resultCode = resultCode;
		this.message = message ;
		this.data = data;
	}
	
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
