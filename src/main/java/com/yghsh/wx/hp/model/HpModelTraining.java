package com.yghsh.wx.hp.model;

import java.util.Date;

/**
 * 训练计划
 * */
public class HpModelTraining extends BaseObject{
	
	private Date dodate ;     //训练时间
	private String username ; //训练人
	private String filename ; //文件名
	private String filepath ; //HDFS的文件路径
	private String jobid ;    //训练的任务ID
	private String status ;   //状态，备用字段
	private Double modelAccuracy ; //模型匹配度（hp_model_prediction）
	
	//各种参数
	private String p_numClasses ;
	private String p_numTrees ;
	private String p_featureSubsetStrategy ;
	private String p_impurity ;
	private String p_maxDepth ;
	private String p_maxBins ;
	private String p_numfeatures ;
	private String p_seed ;
	private String p_minInstancesPerNode ;
	private String p_minInfoGain ;
	private String p_cacheNodeIds ;
	private String p_checkpointInterval ;
	private String p_mod ;
	
	public HpModelTraining( ){}
	public HpModelTraining( boolean b ){
		if( b == true ){  //初始化默认参数
			p_numClasses ="218" ;
			p_numTrees ="200" ;
			p_featureSubsetStrategy ="auto" ;
			p_impurity ="gini" ;
			p_maxDepth ="30" ;
			p_maxBins ="70" ;
			p_numfeatures ="6900" ;
			p_seed ="1234" ;
			p_minInstancesPerNode ="1" ;
			p_minInfoGain ="0.0" ;
			p_cacheNodeIds ="false" ;
			p_checkpointInterval ="10" ;
			p_mod = "10" ;
		}
	}

	public Date getDodate() {
		return dodate;
	}
	public void setDodate(Date dodate) {
		this.dodate = dodate;
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
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getP_numClasses() {
		return p_numClasses;
	}
	public void setP_numClasses(String p_numClasses) {
		this.p_numClasses = p_numClasses;
	}
	public String getP_numTrees() {
		return p_numTrees;
	}
	public void setP_numTrees(String p_numTrees) {
		this.p_numTrees = p_numTrees;
	}
	public String getP_featureSubsetStrategy() {
		return p_featureSubsetStrategy;
	}
	public void setP_featureSubsetStrategy(String p_featureSubsetStrategy) {
		this.p_featureSubsetStrategy = p_featureSubsetStrategy;
	}
	public String getP_impurity() {
		return p_impurity;
	}
	public void setP_impurity(String p_impurity) {
		this.p_impurity = p_impurity;
	}
	public String getP_maxDepth() {
		return p_maxDepth;
	}
	public void setP_maxDepth(String p_maxDepth) {
		this.p_maxDepth = p_maxDepth;
	}
	public String getP_maxBins() {
		return p_maxBins;
	}
	public void setP_maxBins(String p_maxBins) {
		this.p_maxBins = p_maxBins;
	}
	public String getP_numfeatures() {
		return p_numfeatures;
	}
	public void setP_numfeatures(String p_numfeatures) {
		this.p_numfeatures = p_numfeatures;
	}
	public String getP_seed() {
		return p_seed;
	}
	public void setP_seed(String p_seed) {
		this.p_seed = p_seed;
	}

	public String getP_minInstancesPerNode() {
		return p_minInstancesPerNode;
	}
	public void setP_minInstancesPerNode(String p_minInstancesPerNode) {
		this.p_minInstancesPerNode = p_minInstancesPerNode;
	}
	public String getP_minInfoGain() {
		return p_minInfoGain;
	}
	public void setP_minInfoGain(String p_minInfoGain) {
		this.p_minInfoGain = p_minInfoGain;
	}
	public String getP_cacheNodeIds() {
		return p_cacheNodeIds;
	}
	public void setP_cacheNodeIds(String p_cacheNodeIds) {
		this.p_cacheNodeIds = p_cacheNodeIds;
	}
	public String getP_checkpointInterval() {
		return p_checkpointInterval;
	}
	public void setP_checkpointInterval(String p_checkpointInterval) {
		this.p_checkpointInterval = p_checkpointInterval;
	}
	public Double getModelAccuracy() {
		return modelAccuracy;
	}
	public void setModelAccuracy(Double modelAccuracy) {
		this.modelAccuracy = modelAccuracy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getP_mod() {
		return p_mod;
	}
	public void setP_mod(String p_mod) {
		this.p_mod = p_mod;
	}
	
	public String findShellParam(){
		return
				"0 "+
				this.filepath + "_" +
				this.filepath + "_" +
				this.jobid +"_"+
				this.p_numClasses + "_"+
			    this.p_numTrees + "_"+
				this.p_featureSubsetStrategy+ "_" +
			    this.p_impurity + "_"+
			    this.p_maxDepth+ "_"+
			    this.p_maxBins+ "_"+
			    this.p_numfeatures+ "_"+
			    this.p_seed+ "_"+
			    this.p_minInstancesPerNode+ "_"+
			    this.p_minInfoGain+ "_"+
			    this.p_cacheNodeIds+ "_"+
			    //this.p_checkpointInterval+ "_" +
			    this.p_mod ;
	}
}
