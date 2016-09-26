<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="basePath" value="<%=basePath1 %>"></c:set>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="scriptPath" value="${contextPath}/script"/>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>HP</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="${scriptPath}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="${scriptPath}/assets/pages/css/login.min.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="favicon.ico" /> </head>

    <body class=" login">
        <!-- BEGIN LOGO -->
        <div class="logo">
            <a href="index.html">
                <img src="${scriptPath}/assets/pages/img/logo-big.png" alt="" /> </a>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN LOGIN FORM -->
            <form class="login-form" action="${ctx}/hp/logon" method="post" commandName="user">
                <h3 class="form-title font-green">登录</h3>
                <div class="alert alert-danger display-hide">
                    <button class="close" data-close="alert"></button>
                    <span> 请输入用户名密码登录. </span>
                </div>
                <c:if test="${errorMsg ne  null && not empty errorMsg }">
                <div class="alert alert-danger ">
                    <button class="close" data-close="alert"></button>
                    <span> ${errorMsg}</span>
                </div>                
                </c:if>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="请输入用户名" name="loginName" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="请输入密码" name="password" /> </div>
                <div class="form-actions">
                    <button type="submit" class="btn green uppercase">登录</button>
                    <label class="rememberme check">
                </div>
            </form>
            <!-- END LOGIN FORM -->
           
        </div>
        <div class="copyright"> 2016 ©HP </div>
        <script src="${scriptPath}/assets/global/plugins/respond.min.js"></script>
        <script src="${scriptPath}/assets/global/plugins/excanvas.min.js"></script>
        <script src="${scriptPath}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <script src="${scriptPath}/assets/pages/scripts/login.min.js" type="text/javascript"></script>
    </body>

</html>