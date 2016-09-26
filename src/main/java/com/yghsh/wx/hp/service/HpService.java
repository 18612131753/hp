package com.yghsh.wx.hp.service;

import com.yghsh.wx.base.QueryForm;
import com.yghsh.wx.hp.model.HpDataAnalysis;
import com.yghsh.wx.hp.model.HpDataAnalysisResult;
import com.yghsh.wx.hp.model.HpModelTraining;
import com.yghsh.wx.hp.model.HpModelTrainingResult;
import com.yghsh.wx.util.GridDataModel;

import java.util.List;


public interface HpService {

	/**
	 * 查询训练轨迹
	 * */
	public GridDataModel<HpModelTraining> queryModelTraining( QueryForm form );
	/**
	 * 查询训练结果
	 * */
	public GridDataModel<HpModelTrainingResult> queryHpModelTrainingResult( QueryForm form ); //OPMASTE使用
	public List<HpModelTrainingResult> modelTrainingShow( String jobid );

	/**
	 * 查询数据分类轨迹
	 * */
	public GridDataModel<HpDataAnalysis> queryDataAnalysis( QueryForm form );
	public List<HpDataAnalysisResult> dataAnalysisShow( String labeljobid ,String jobid );
}
