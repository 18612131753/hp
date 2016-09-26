package com.yghsh.wx.hp.dao;

import java.util.List;

import com.yghsh.wx.hp.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yghsh.wx.base.QueryForm;


public interface HpDao {
	
	@Select("select * from hp_user where username = #{username}")
	public HpUser findUserByName( @Param("username")String username );
	
	public int findModelTrainCount( @Param("form")QueryForm form  );
	public List<HpModelTraining> findModelTrain( @Param("form")QueryForm form  );
	
	public int findModelTrainResultCount( @Param("form")QueryForm form  );
	public List<HpModelTrainingResult> findModelTrainResult( @Param("form")QueryForm form );
	
	@Insert("insert into hp_modeltraining (cdate,dodate,username,status,filepath,filename,jobid,p_numClasses,p_numTrees,p_featureSubsetStrategy,p_impurity,p_maxDepth,p_maxBins,p_numfeatures,p_seed,p_minInstancesPerNode,p_minInfoGain,p_cacheNodeIds,p_checkpointInterval,p_mod)" +
	         "values(#{hmt.cdate},#{hmt.dodate},#{hmt.username},#{hmt.status},#{hmt.filepath},#{hmt.filename},#{hmt.jobid},"+
	         "#{hmt.p_numClasses},#{hmt.p_numTrees},#{hmt.p_featureSubsetStrategy},#{hmt.p_impurity},#{hmt.p_maxDepth},"+
	         "#{hmt.p_maxBins},#{hmt.p_numfeatures},#{hmt.p_seed},#{hmt.p_minInstancesPerNode},#{hmt.p_minInfoGain},#{hmt.p_cacheNodeIds},#{hmt.p_checkpointInterval},#{hmt.p_mod})")
	@Options(useGeneratedKeys = true, keyProperty = "hmt.id")
	public void insertModeltraining( @Param("hmt")HpModelTraining hmt );
	
	@Select("select * from hp_modeltraining where id = #{id}")
	public HpModelTraining findModelById(  @Param("id")Integer id );
	
   @Update(
		 "update hp_modeltraining set jobid=#{hmt.jobid},dodate=#{hmt.dodate},"+
         "p_numClasses=#{hmt.p_numClasses},p_numTrees=#{hmt.p_numTrees},p_featureSubsetStrategy=#{hmt.p_featureSubsetStrategy},p_impurity=#{hmt.p_impurity},p_maxDepth=#{hmt.p_maxDepth},"+
         "p_maxBins=#{hmt.p_maxBins},p_numfeatures=#{hmt.p_numfeatures},p_seed=#{hmt.p_seed},p_minInstancesPerNode=#{hmt.p_minInstancesPerNode},p_minInfoGain=#{hmt.p_minInfoGain},p_cacheNodeIds=#{hmt.p_cacheNodeIds},p_checkpointInterval=#{hmt.p_checkpointInterval},p_mod=#{hmt.p_mod}" +
         " where id=#{hmt.id} ")
	public int modelTrainingUpdateP( @Param("hmt")HpModelTraining hmt );
   
	public int findDataAnalysisCount( @Param("form")QueryForm form  );
	public List<HpDataAnalysis> findDataAnalysis( @Param("form")QueryForm form  );
	
   @Insert("insert into hp_dataanalysis (cdate,username,status,filepath,filename,jobid,labeljobid)" +
		   "values(#{hda.cdate},#{hda.username},#{hda.status},#{hda.filepath},#{hda.filename},#{hda.jobid},#{hda.labeljobid})" )
   @Options(useGeneratedKeys = true, keyProperty = "hda.id")
   public void insertDataAnalysis( @Param("hda")HpDataAnalysis hda );

	@Select("SELECT t.* , l.group as newgroup " +
			"from hp_test_prediction t " +
			"left join hp_label_index l on t.label=l.label and l.jobid=#{jobid} " +
			"where t.jobid=#{jobid}"
	)
	public List<HpModelTrainingResult> modelTrainingShow(@Param("jobid")String jobid);


	@Select("select * from hp_dataanalysis where id = #{id}")
	public HpDataAnalysis findDataAnalysisById(  @Param("id")Integer id );

	@Select("select a.*,b.group from hp_prediction a join hp_label_index b on a.label=b.label " +
			"and b.jobId=#{labeljobid} "+
			"where a.jobid=#{jobid}"
	)
	public List<HpDataAnalysisResult> dataAnalysisShow(@Param("labeljobid")String labeljobid,@Param("jobid")String jobid);

	//获取当前最近一次模型训练出来的jobid，用于显示类型
	@Select("select c.jobId from hp_label_index c order by c.createtime desc limit 0,1")
	public String findNowLabelJobid();

	@Update("update hp_dataanalysis s " +
			"INNER JOIN  (" +
			"select d.id from hp_dataanalysis d ,hp_prediction p where d.jobid=p.jobId and d.status='doing' GROUP BY d.jobid having count(*)>0 " +
			") s1 " +
			" set s.status='Complete' " +
			"where s.id=s1.id")
	public void updateDataanalysisStatus();
}
