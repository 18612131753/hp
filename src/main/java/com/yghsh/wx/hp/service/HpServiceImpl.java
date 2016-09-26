package com.yghsh.wx.hp.service;

import com.yghsh.wx.base.QueryForm;
import com.yghsh.wx.hp.dao.HpDao;
import com.yghsh.wx.hp.model.HpDataAnalysis;
import com.yghsh.wx.hp.model.HpDataAnalysisResult;
import com.yghsh.wx.hp.model.HpModelTraining;
import com.yghsh.wx.hp.model.HpModelTrainingResult;
import com.yghsh.wx.util.GridDataModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;

@Service("hpService")
@Transactional
public class HpServiceImpl implements HpService{

	private final static org.apache.log4j.Logger logger =
			org.apache.log4j.Logger.getLogger(HpServiceImpl.class);
	
	public static DecimalFormat df = new DecimalFormat("#0.00");
	
	@Resource
	public HpDao hpDao ;

	public GridDataModel<HpModelTraining> queryModelTraining(QueryForm form) {
		logger.info("查询训练轨迹..."+form.getSidx());
		GridDataModel<HpModelTraining> gdm = new GridDataModel<HpModelTraining>();
		gdm.setTotal( hpDao.findModelTrainCount(form) , form.getRows());
		gdm.setRows( hpDao.findModelTrain(form) );
		return gdm ;
	}

	public GridDataModel<HpModelTrainingResult> queryHpModelTrainingResult( QueryForm form ) {
		logger.info("查询数据分类结果..." );
		GridDataModel<HpModelTrainingResult> gdm = new GridDataModel<HpModelTrainingResult>();
		gdm.setTotal( hpDao.findModelTrainResultCount(form), form.getRows());
		gdm.setRows( hpDao.findModelTrainResult(form) );
		return gdm ;
	}
	public List<HpModelTrainingResult> modelTrainingShow(String jobid) {
		List<HpModelTrainingResult> list = hpDao.modelTrainingShow(jobid);
		return list ;
	}

	public GridDataModel<HpDataAnalysis> queryDataAnalysis(QueryForm form) {
		logger.info("查询数据分类轨迹..." + form.getSidx());
		GridDataModel<HpDataAnalysis> gdm = new GridDataModel<HpDataAnalysis>();
		gdm.setTotal( hpDao.findDataAnalysisCount(form), form.getRows());
		gdm.setRows( hpDao.findDataAnalysis(form) );
		return gdm ;
	}

	public List<HpDataAnalysisResult> dataAnalysisShow(String labeljobid ,String jobid) {
		List<HpDataAnalysisResult> list = hpDao.dataAnalysisShow(labeljobid,jobid);
		return list ;
	}
}
