package com.yghsh.wx.hp.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yghsh.wx.hp.model.*;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yghsh.wx.base.BaseController;
import com.yghsh.wx.base.QueryForm;
import com.yghsh.wx.hdfs.HDFS;
import com.yghsh.wx.hp.aspect.HpProcess;
import com.yghsh.wx.hp.dao.HpDao;
import com.yghsh.wx.hp.service.HpService;
import com.yghsh.wx.util.GridDataModel;
import com.yghsh.wx.util.ModelAndViewUtil;
import com.yghsh.wx.util.PropertiesUtils;
import com.yghsh.wx.util.RemoteShellTool;
import com.yghsh.wx.util.SessionUtil;

/**
 * HP
 * 
 * */
@Controller
@RequestMapping("/hp")
public class HpController extends BaseController {
	
	private final static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(HpController.class);
	
	@Resource(name="hpService")
	private HpService hpService ;

	@Resource
	private HpDao hpDao ;
	
	@RequestMapping(value = "")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView index(
		HttpServletRequest  request, 
		HttpServletResponse response
	){
		logger.info("进入..index");
		return ModelAndViewUtil.Jsp("hp/index");
	}

	/**
	 * 登入登出
	 * @param type in=登陆  out=推出
	 * */
	@RequestMapping(value = "login/{type}")
	@HpProcess( needLogin = false , isAjax=false )
	public ModelAndView login(
		HttpServletRequest  request, 
		HttpServletResponse response,
		@PathVariable String type
	){
		if ("out".equals(type) ){
			SessionUtil.logout( request.getSession() );
		}
		return ModelAndViewUtil.Jsp("hp/login/login");
	}
	
	/**
	 * 登陆方法
	 * @throws IOException 
	 * */
	@RequestMapping(value = "logon")
	@HpProcess( needLogin = false , isAjax=false )
	public ModelAndView logon(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		@RequestParam(value="loginName",required=false) String loginName, 
		@RequestParam(value="password", required=false) String upwd
	) throws IOException{
		HpUser usr = hpDao.findUserByName( loginName );
		//登陆成功
		if( usr != null && usr.getPassword().equals(upwd)){
			SessionUtil.saveUserSession( request.getSession(), usr) ;
			response.sendRedirect(request.getContextPath()+"/hp/use/modelTraining");
			return null ;
		}
		//登陆失败
		model.addAttribute("errorMsg", "登录名或密码错误") ;
		return ModelAndViewUtil.Jsp("hp/login/login");
	}
	
	/**
	 * 功能页面跳转
	 * */
	@RequestMapping(value = "use/{page}")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView upage(
		HttpServletRequest  request,
		HttpServletResponse response,
		Model model ,
		@PathVariable String page
	){
		logger.info("进入/usr/"+page);
		return ModelAndViewUtil.Jsp("hp/use/"+page);
	}
	
	/**
	 * 查询训练轨迹
	 * */
	@RequestMapping(value = "queryModelTraining")
	@HpProcess( needLogin = true , isAjax=true )
	public ModelAndView queryModelTraining(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		QueryForm form
	){
		GridDataModel<HpModelTraining> gdm = hpService.queryModelTraining( form );
		return ModelAndViewUtil.Json_ok(gdm, "queryForm");
	}
	
	/**
	 * 上传训练集文件
	 * */
	@RequestMapping(value = "modelTrainingAddFile")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView modelTrainingAddFile(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model
	){
		logger.info("上传文件");
		int type = 0 ; //1表示执行成功 ， 0表示执行失败
		//读取文件
		ServletFileUpload upload = new ServletFileUpload();
		upload.setHeaderEncoding("UTF-8");
		upload.setHeaderEncoding("UTF-8");
		InputStream stream = null; 
		BufferedOutputStream bos = null;
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					//判断是否为文件名
					if (!item.isFormField() && item.getName() !=null && item.getName().length()>0) {
						logger.info( "文件名：" + item.getName() );
						String hdfsPath = "/hp/"+new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-" +RandomUtils.nextInt(10000)+"/datafile" ;
						logger.info( "hdfs路径：" + hdfsPath );
						
						//上传至HDFS
						//判断是否windows
						if( System.getProperties().getProperty("os.name").indexOf("Windows")>-1 ){
							System.setProperty("hadoop.home.dir", this.getClass().getClassLoader().getResource("").getPath() );
						}
						HDFS.getInstance().uploadFile( hdfsPath , item.openStream() );

						HpModelTraining hmt = new HpModelTraining( true );
						hmt.setFilepath( HDFS.url+hdfsPath ) ;
						hmt.setFilename( item.getName() );
						hmt.setCdate( new Date() );
						hmt.setUsername( SessionUtil.getUserSession(request.getSession()).getUsername());
						hpDao.insertModeltraining(hmt);
						type =1;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			type = 0;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception e) {
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
				}
			}
		}

		logger.info("type:"+type);
		if( type == 1){
			return ModelAndViewUtil.Jsp("hp/use/modelTraining");
		} else {
			model.addAttribute("mess","上传失败");
			return ModelAndViewUtil.Jsp("hp/use/modelTrainingAdd");
		}
	}
	
	/**
	 * 训练模型页面
	 * */
	@RequestMapping(value = "modelTrainingDo/{id}")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView modelTrainingDo(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		@PathVariable Integer id
	){
		logger.info("进入训练模型");
		HpModelTraining hmt = hpDao.findModelById( id );
		model.addAttribute( "hmt" , hmt );
		return ModelAndViewUtil.Jsp("hp/use/modelTrainingDo");
	}
	/**
	 * 更新参数
	 * */
	@RequestMapping(value = "modelTrainingUpdateP")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView modelTrainingUpdateP(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		HpModelTraining hmt
	) throws IOException {
		logger.info("更新数据");
		//生成新的jobid
		String jobid = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+RandomUtils.nextInt(1000);
		hmt.setJobid(jobid);
		hmt.setDodate( new Date() );
		HpModelTraining oldhmt = hpDao.findModelById( hmt.getId() );
		hmt.setFilepath( oldhmt.getFilepath());
		//执行模型shell TODO 拼接参数
		RemoteShellTool tool = new RemoteShellTool(
				PropertiesUtils.getPerVal("/config.properties", "sparkshell.ip"), 
				PropertiesUtils.getPerVal("/config.properties", "sparkshell.user"),  
				PropertiesUtils.getPerVal("/config.properties", "sparkshell.password"),
                "utf-8"
        );
		String shellexce = "sh "+
				PropertiesUtils.getPerVal("/config.properties", "sparkshell.modelTraining")+
				" "+hmt.findShellParam();

		logger.info("数据执行脚本："+shellexce);
        tool.exec( shellexce );
		//更新字段
		hpDao.modelTrainingUpdateP(hmt);
		response.sendRedirect(request.getContextPath()+"/hp/use/modelTraining") ;
		return null ;
	}
	/**
	 * 训练 - 查看结果
	 * */
	@RequestMapping(value = "modelTrainingShow/{id}")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView modelTrainingShow(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		@PathVariable int id
	){
		logger.info("进入训练模型");
		HpModelTraining hmt = hpDao.findModelById( id );
		model.addAttribute( "hmt" , hmt );
		if( hmt.getJobid() != null) {
			List<HpModelTrainingResult> list = hpService.modelTrainingShow( hmt.getJobid() );
			model.addAttribute( "list" , list );
		}
		return ModelAndViewUtil.Jsp("hp/use/modelTrainingShow");
	}
	
	/**
	 * 查询数据分类轨迹
	 * */
	@RequestMapping(value = "queryDataAnalysis")
	@HpProcess( needLogin = true , isAjax=true )
	public ModelAndView queryDataAnalysis(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model ,
		QueryForm form
	){
		//更新状态
		hpDao.updateDataanalysisStatus();

		GridDataModel<HpDataAnalysis> gdm = hpService.queryDataAnalysis( form );
		return ModelAndViewUtil.Json_ok(gdm, "queryForm");
	}
	
	/**
	 * 上传数据分类文件
	 * */
	@RequestMapping(value = "dataAnalysisAddFile")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView dataAnalysisAddFile(
		HttpServletRequest  request, 
		HttpServletResponse response,
		Model model
	){
		logger.info("上传文件");
		int type = 1 ; //1表示执行成功 ， 0表示执行失败
		//读取文件
		ServletFileUpload upload = new ServletFileUpload();
		upload.setHeaderEncoding("UTF-8");
		upload.setHeaderEncoding("UTF-8");
		InputStream stream = null; 
		BufferedOutputStream bos = null;
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					//判断是否为文件名
					if (!item.isFormField()) {
						String hdfsPath = "/hpdata/"+new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-" +RandomUtils.nextInt(10000)+"/datafile" ;
						logger.info( "hdfs路径：" + hdfsPath );
						
						//上传至HDFS
						//判断是否windows
						if( System.getProperties().getProperty("os.name").indexOf("Windows")>-1 ){
							System.setProperty("hadoop.home.dir", this.getClass().getClassLoader().getResource("").getPath() );
						}
						HDFS.getInstance().uploadFile( hdfsPath , item.openStream() );
						String jobid = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+RandomUtils.nextInt(1000);
						HpDataAnalysis hda = new HpDataAnalysis( );
						hda.setJobid(jobid );
						hda.setFilepath( HDFS.url+hdfsPath ) ;
						hda.setFilename( item.getName() );
						hda.setCdate( new Date() );
						hda.setStatus("doing");
						hda.setLabeljobid( hpDao.findNowLabelJobid() );
						hda.setUsername( SessionUtil.getUserSession(request.getSession()).getUsername());
						hpDao.insertDataAnalysis(hda);
						
						//调用shell脚本执行
						RemoteShellTool tool = new RemoteShellTool(
								PropertiesUtils.getPerVal("/config.properties", "sparkshell.ip"),
								PropertiesUtils.getPerVal("/config.properties", "sparkshell.user"),
								PropertiesUtils.getPerVal("/config.properties", "sparkshell.password"),
								"utf-8"
						);
						String shellexce =
								"sh "+ PropertiesUtils.getPerVal("/config.properties", "sparkshell.dataAnalysis")+
								" 1 "+hda.getFilepath()+"_"+hda.getJobid() ;
						logger.info("数据执行脚本："+shellexce);
						tool.exec( shellexce );
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			type = 0;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception e) {
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
				}
			}
		}
		if( type == 1){
			return ModelAndViewUtil.Jsp("hp/use/dataAnalysis");
		} else {
			model.addAttribute("mess","上传失败");
			return ModelAndViewUtil.Jsp("hp/use/dataAnalysisAdd");
		}
	}

	/**
	 * 训练 - 查看结果
	 * */
	@RequestMapping(value = "dataAnalysisShow/{id}")
	@HpProcess( needLogin = true , isAjax=false )
	public ModelAndView dataAnalysisShow(
			HttpServletRequest  request,
			HttpServletResponse response,
			Model model ,
			@PathVariable int id
	){
		logger.info("进入训练模型");
		HpDataAnalysis hda = hpDao.findDataAnalysisById(id);
		model.addAttribute( "hda" , hda );

		List<HpDataAnalysisResult> list = hpService.dataAnalysisShow(hda.getLabeljobid(),hda.getJobid());
		model.addAttribute( "list" , list );

		return ModelAndViewUtil.Jsp("hp/use/dataAnalysisShow");
	}
}