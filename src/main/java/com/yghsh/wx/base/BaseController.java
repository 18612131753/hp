package com.yghsh.wx.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {


	/**
	 * 初始化，，
	 **/
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response, Model model) {


	}

	public String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ (port == 80 ? "" : (":" + request.getServerPort())) + path
				+ "/";
		return basePath;
	}


}