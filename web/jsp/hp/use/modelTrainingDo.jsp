<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
<head>
    <style>
        .form .form-bordered .form-group>div{padding:10px;}
    </style>
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
                            <a href="#">配置训练参数</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <a href="#">文件名：${hmt.filename}</a>
                        </li>
                    </ul>
                </div>
                <div class="portlet-title clearfix" style="margin-bottom: 10px">
                    <div class="caption " style="display: inline-block;margin-top: 7px;">
                        <i class="icon-settings font-green"></i>
                        <span class="caption-subject font-green sbold uppercase"> model training </span>
                    </div>
                </div>
                <div class="alert alert-info" id="messagebar" style="display:none">
                    <button class="close" data-close="alert"></button>
                    <span>更新参数ING...</span>
                </div>
                <div class="row">
                <div class="col-md-12">
                <div class="portlet-body form">
                    <!-- BEGIN FORM-->
                    <form id="modfileform" action="${contextPath}/hp/modelTrainingUpdateP" method="post" class="form-horizontal form-bordered">
                        <input type="hidden" name="id" value="${hmt.id}" />
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-3">numClasses</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_numClasses" value="${hmt.p_numClasses}"/>
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">numTrees</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_numTrees" value="${hmt.p_numTrees}"/>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">featureSubsetStrategy</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_featureSubsetStrategy" value="${hmt.p_featureSubsetStrategy}" />
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">impurity</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_impurity" value="${hmt.p_impurity}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">maxDepth</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_maxDepth" value="${hmt.p_maxDepth}" />
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">maxBins</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_maxBins" value="${hmt.p_maxBins}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">numfeatures</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_numfeatures" value="${hmt.p_numfeatures}" />
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">seed</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_seed" value="${hmt.p_seed}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">minInstancesPerNode</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_minInstancesPerNode" value="${hmt.p_minInstancesPerNode}" />
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">minInfoGain</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_minInfoGain" value="${hmt.p_minInfoGain}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">cacheNodeIds</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_cacheNodeIds" value="${hmt.p_cacheNodeIds}" />
                                    <span class="help-block"></span>
                                </div>
                                <label class="control-label col-md-3">checkpointInterval</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_checkpointInterval" value="${hmt.p_checkpointInterval}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">mod</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" maxlength="10" name="p_mod" value="${hmt.p_mod}" />
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <a id="formsubmit" href="javascript:;" class="btn green">
                                        <i class="fa fa-check"></i> 开始训练</a>
                                    <a href="javascript:history.go(-1);" class="btn btn-outline grey-salsa">返回</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                <!-- END CONTENT BODY ==================================================================== -->
            </div>
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

        var click_t = 0 ; //可以点击
        $("#formsubmit").click(function(){
            if(click_t == 0 ){
                click_t = 1;
                $("#messagebar").css("display","block");
                $("#modfileform").submit();
            }
        });
    });
</script>