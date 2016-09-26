<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<c:set var="basePath" value="<%=basePath1 %>"></c:set>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="scriptPath" value="${contextPath}/script"/>
<c:set var="jsPath" value="${contextPath}/script/js"/>
<c:set var="cssPath" value="${contextPath}/script/css"/>
<c:set var="imagesPath" value="${contextPath}/script/images"/>

<html>
<head>
	<meta charset="utf-8" />
	<title>HP</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN THEME GLOBAL STYLES -->
	<link href="${scriptPath}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="${scriptPath}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
	<!-- END THEME GLOBAL STYLES -->
	<!-- BEGIN THEME LAYOUT STYLES -->
	<link href="${scriptPath}/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
	<link href="${scriptPath}/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
	<link href="${scriptPath}/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
	<!-- END THEME LAYOUT STYLES -->
</head>
</html>
<script src="${scriptPath}/js/main.js"></script>
<!-- BEGIN CORE PLUGINS -->
<script src="${scriptPath}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${scriptPath}/assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${scriptPath}/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>