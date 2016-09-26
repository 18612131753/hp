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
            <div class="page-content" >
            <!-- BEGIN CONTENT BODY=================================================================== -->
                <div class="page-bar" style="margin-bottom: 10px;">
                    <ul class="page-breadcrumb">
                        <li>
                            <a href="#">模型训练</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <a href="#">训练模型</a>
                        </li>
                    </ul>
                </div>
                <div class="portlet-title clearfix" style="margin-bottom: 10px">
                    <div class="caption " style="display: inline-block;margin-top: 7px;">
                        <i class="icon-settings font-green"></i>
                        <span class="caption-subject font-green sbold uppercase"> Managed </span>
                    </div>
                </div>

            <!-- END CONTENT BODY ==================================================================== -->
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
        $(".nav-item").removeClass("active open");
        $("#menu_1").addClass("active open");
 });
</script>