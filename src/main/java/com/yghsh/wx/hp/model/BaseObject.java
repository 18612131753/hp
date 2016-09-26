package com.yghsh.wx.hp.model;

import java.util.Date;

public class BaseObject {

	private Integer id ;

	private Date cdate ;      //创建时间

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
