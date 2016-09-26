<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
<head>
	<link href="${scriptPath}/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css" />
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<%@ include file="../main/header.jsp"%>
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<%@ include file="../main/left.jsp"%>
			<div class="page-content-wrapper">
<!-- BEGIN CONTENT BODY=================================================================== -->
				<div class="page-content" >
					<!-- BEGIN PAGE HEADER-->
					<!-- BEGIN PAGE BAR -->
					<div class="page-bar" style="margin-bottom: 10px;">
						<ul class="page-breadcrumb">
							<li>
								<a href="#">数据分类</a>
								<i class="fa fa-circle"></i>
							</li>
							<li>
								<a href="#">上传数据文件</a>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<div class="portlet-title clearfix" style="margin-bottom: 10px">
						<div class="caption " style="display: inline-block;margin-top: 7px;">
							<i class="icon-settings font-green"></i>
							<span class="caption-subject font-green sbold uppercase"> Data analysis </span>
						</div>
					</div>
					<div class="alert alert-info" id="messagebar" style="display:none">
						<button class="close" data-close="alert"></button>
						<span>上传中...请稍等</span>
					</div>
					<c:if test="${mess ne  null && not empty mess }">
						<div class="alert alert-danger ">
							<button class="close" data-close="alert"></button>
							<span> ${mess}</span>
						</div>
					</c:if>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->
						<form id="modfileform" method="post" enctype="multipart/form-data" action="${contextPath}/hp/dataAnalysisAddFile" class="form-horizontal form-bordered">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-md-3">选择数据文件</label>
									<div class="col-md-3">
										<div class="fileinput fileinput-new" data-provides="fileinput">
											<div class="input-group input-large">
												<div class="form-control uneditable-input input-fixed input-medium" data-trigger="fileinput">
													<i class="fa fa-file fileinput-exists"></i>&nbsp;
													<span class="fileinput-filename"> </span>
												</div>
												<span class="input-group-addon btn default btn-file">
													<span class="fileinput-new"> Select file </span>
													<span class="fileinput-exists"> Change </span>
													<input type="file" name="file" id="dddfile"/>
												</span>
												<a href="javascript:;" class="input-group-addon btn red fileinput-exists" data-dismiss="fileinput"> Remove </a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-offset-3 col-md-9">
										<a href="javascript:;" class="btn green" id="formsubmit">
											<i class="fa fa-check"></i> 上传并分析
										</a>
										<a href="javascript:history.go(-1);" class="btn btn-outline grey-salsa"> 返回</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
<!-- END CONTENT BODY ===================================================================-->
	</div>
</body>
</html>
<script src="${scriptPath}/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
		$("#menu_2").addClass("active open");

		var click_t = 0 ; //可以点击
		$("#formsubmit").click(function(){
			if( $("#dddfile").val().length >0 && click_t == 0 ){
				click_t = 1;
				$("#messagebar").css("display","block");
				$("#modfileform").submit();
			}
		});
	});
</script>