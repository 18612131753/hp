package com.yghsh.wx.hp.model;

public class HpDataAnalysis extends BaseObject {

	private Integer id ;
	private String username ; //训练人
	private String filename ; //文件名
	private String filepath ; //HDFS的文件路径
	private String status ;   //状态，备用字段
	private String jobid ;
	private String labeljobid ; //当前训练模型的分析出来的类型的jobid

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getLabeljobid() {
		return labeljobid;
	}

	public void setLabeljobid(String labeljobid) {
		this.labeljobid = labeljobid;
	}
}
