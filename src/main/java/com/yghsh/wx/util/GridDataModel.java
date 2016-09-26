/**
 * 表单数据格式
 */
package com.yghsh.wx.util;

import java.util.List;

/** 
 * 2013-1-7
 * @author wxl 
 */
public class GridDataModel<T> {

	private int page =1;
	private int total=0;  //一共多少页
	private int count ;
	private String records="";
	private List<T> rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int count , int rowNum) {
		if( count%rowNum == 0 ) this.total =count/rowNum ;
		this.total =count/rowNum+1 ;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
