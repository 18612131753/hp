<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
<head>
	<link rel="stylesheet" type="text/css"  href="${scriptPath}/assets/jqGrid5.1.1/css/ui.jqgrid-bootstrap.css" />
	<script src="${scriptPath}/assets/jqGrid5.1.1/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
	<script src="${scriptPath}/assets/jqGrid5.1.1/src/jquery.jqGrid.js" type="text/javascript"></script>
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
							<a href="#">分类结果</a>
						</li>
					</ul>
				</div>
				<!-- END PAGE BAR -->
				<div class="portlet-title clearfix" style="margin-bottom: 10px">
					<div class="caption " style="display: inline-block;margin-top: 7px;">
						<i class="icon-settings font-green"></i>
						<span class="caption-subject font-green sbold uppercase"> Data analysis </span>
					</div>
					<div class="btn-group" style="float: right;">
						<a href="${contextPath}/hp/use/dataAnalysisAdd" id="sample_editable_1_new" class="btn sbold green"> 上传数据File
							<i class="fa fa-plus"></i>
						</a>
					</div>
				</div>
				<!-- table start -->
				<div class="portlet-body">
					<div class="table-container">
						<table class="table table-striped table-bordered table-hover" id="list"><tr><td></td></tr></table>
						<div id="pager" style="height:40px;"></div>
					</div>
				</div>
				<!-- table end -->
			</div>
		</div>
	</div>
	<!-- END CONTENT BODY ===================================================================-->
</div>
</body>
</html>
<script type="text/javascript">
	$(function () {
		$("#menu_2").addClass("active open");
		$("#list").jqGrid({
			url: "${contextPath}/hp/queryDataAnalysis",
			datatype: "json",
			mtype: "POST",
			styleUI: 'Bootstrap',
			colModel: [
				{ label: '文件名',name:"filename",width:160,editable: true},
				{ label: '状态', name:"status",width:120,editable: true},
				{ label: '上传时间',name:"cdate",width:140,editable: true,formatter: function (cellValue, option, rowObject) {return formatDate(cellValue,"y-m-d h:i:s");}},
				{ label: 'HDFS路径',name:"filepath",width:280,editable: true},
				{ label: '操作',name:"id",editable: true,sortable: false,
					formatter: function (cellValue, option, rowObject) {
						var sss =  '';
						if( rowObject.status == 'Complete'){
							sss='<a href="${contextPath}/hp/dataAnalysisShow/'+rowObject.id+'">查看结果</a>' ;
						}

						return sss ;
					}}
			],
			sopt:['eq'],
			pager: "#pager",
			width: "auto",
			height: "400",
			sortname: "id",
			sortorder: "asc",
			autowidth:true,
			rowNum: 10,
			rowList: [5,10, 20, 50],
			multipleSearch:true,
			viewrecords: true,
			gridview: true,
			autoencode: true
		});
		jQuery("#list").jqGrid('navGrid', '#pager', {edit:false,add:false,del:false,view:true,multipleSearch:false});
	});
</script>