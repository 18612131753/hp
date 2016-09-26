<%@ page language="java"  pageEncoding="UTF-8"%>

        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                <li class="sidebar-toggler-wrapper hide">
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler"> </div>
                    <!-- END SIDEBAR TOGGLER BUTTON -->
                </li>
                <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
                <li class="sidebar-search-wrapper">
                    <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                   <form class="sidebar-search" action="#" method="POST">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <a href="javascript:;" class="btn "><!--submit -->
                                    <i class="icon-magnifier"></i>
                                </a>
                            </span>
                        </div>
                    </form>
                    <!-- END RESPONSIVE QUICK SEARCH FORM -->
                </li>
                <li class="heading">
                    <h3 class="uppercase">Features</h3>
                </li>
                <li class="nav-item" id="menu_1"><!--active open -->
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-puzzle"></i>
                        <span class="title">模型训练</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item  ">
                            <a href="${contextPath}/hp/use/modelTraining" class="nav-link ">
                                <span class="title">训练结果</span>
                                <span class="badge badge-danger"></span>
                            </a>
                        </li>
                        <li class="nav-item  ">
                            <a href="${contextPath}/hp/use/modelTrainingAdd" class="nav-link ">
                                <span class="title">上传训练文件</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item" id="menu_2">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-settings"></i>
                        <span class="title">数据分类</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item  ">
                            <a href="${contextPath}/hp/use/dataAnalysis" class="nav-link ">
                                <span class="title">分类结果</span>
                            </a>
                        </li>
                        <li class="nav-item  ">
                            <a href="${contextPath}/hp/use/dataAnalysisAdd" class="nav-link ">
                                <span class="title">上传数据文件</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
        <!-- END SIDEBAR -->