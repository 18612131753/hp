<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
<head>
    <link href="${scriptPath}/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
    <link href="${scriptPath}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
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
                            <a href="#">数据分析</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <a href="#">分析结果查看</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <a href="#">文件名：${hda.filename}</a>
                        </li>
                    </ul>
                </div>
                <div class="portlet-title clearfix" style="margin-bottom: 10px">
                    <div class="caption " style="display: inline-block;margin-top: 7px;">
                        <i class="icon-settings font-green"></i>
                        <span class="caption-subject font-green sbold uppercase">  Data analysis  </span>
                        <a href="javascript:history.go(-1);" class="btn btn-outline grey-salsa">返回</a>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                    <thead>
                    <tr>
                        <th> <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /> </th>
                        <th> 文本内容 </th>
                        <th> 预测分类 </th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hmt" items="${list}" >
                            <tr class="odd gradeX">
                                <td><input type="checkbox" class="checkboxes" value="1" /> </td>
                                <td width="70%"> ${hmt.orgtext} </td>
                                <td style="text-align:center;vertical-align:middle;"> <span class="label label-sm label-success"> ${hmt.group}</span> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <!-- END CONTENT BODY ==================================================================== -->
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script src="${scriptPath}/assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="${scriptPath}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $("#menu_2").addClass("active open");

        var TableDatatablesManaged = function () {
            var initTable1 = function () {
                var table = $('#sample_1');
                table.dataTable({
                    "language": {
                        "aria": {
                            "sortAscending": ": activate to sort column ascending",
                            "sortDescending": ": activate to sort column descending"
                        },
                        "emptyTable": "No data available in table",
                        "info": "数据 _START_ 至 _END_ 条 ，共 _TOTAL_ 条",
                        "infoEmpty": "No records found",
                        "infoFiltered": "(filtered1 from _MAX_ total records)",
                        "lengthMenu": "Show _MENU_",
                        "search": "Search:",
                        "zeroRecords": "No matching records found",
                        "paginate": {
                            "previous":"Prev",
                            "next": "Next",
                            "last": "Last",
                            "first": "First"
                        }
                    },
                    "bStateSave": false,
                    "columnDefs": [ {
                        "targets": 0,
                        "orderable": false,
                        "searchable": false
                    }],
                    "lengthMenu": [
                        [5, 15, 20, -1],
                        [5, 15, 20, "All"]
                    ],
                    "pageLength": 10,
                    "pagingType": "bootstrap_full_number",
                    "columnDefs": [{  // set default column settings
                        'orderable': false,
                        'targets': [0]
                    },{
                        "searchable": false,
                        "targets": [0]
                    }],
                    "order": [
                        [1, "asc"]
                    ]
                });
                var tableWrapper = jQuery('#sample_1_wrapper');
                table.find('.group-checkable').change(function () {
                    var set = jQuery(this).attr("data-set");
                    var checked = jQuery(this).is(":checked");
                    jQuery(set).each(function () {
                        if (checked) {
                            $(this).prop("checked", true);
                            $(this).parents('tr').addClass("active");
                        } else {
                            $(this).prop("checked", false);
                            $(this).parents('tr').removeClass("active");
                        }
                    });
                    jQuery.uniform.update(set);
                });
                table.on('change', 'tbody tr .checkboxes', function () {
                    $(this).parents('tr').toggleClass("active");
                });
            }
            return {
                init: function () {
                    if (!jQuery().dataTable) {
                        return;
                    }
                    initTable1();
                }
            };
        }();
        if (App.isAngularJsApp() === false) {
            jQuery(document).ready(function() {
                TableDatatablesManaged.init();
            });
        }
    });
</script>