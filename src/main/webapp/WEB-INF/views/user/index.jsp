<%--
  Created by IntelliJ IDEA.
  User: h135m
  Date: 2020/6/3
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        table tbody tr:nth-child(odd){background:#F4F4F4;}
        table tbody td:nth-child(even){color:#C00;}
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="../main">创网平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> ${loginUser} <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="../logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed" >
                        <a href="../main"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="./index" style="color:red;"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="../role/index"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="../permission/index"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
                            </li>
                            <li style="height:30px;">
                                <a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
                            </li>
                            <li style="height:30px;">
                                <a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed" >
                        <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="queryText" class="form-control has-success" type="text" placeholder="请输入账号名查询">
                            </div>
                        </div>
                        <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" onclick="deleteUsers(  )" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/user/add'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <form id="userForm">
                            <table class="table  table-bordered">
                                <thead>
                                <tr >
                                    <th width="30">#</th>
                                    <th width="30"><input type="checkbox" id="allSelBox"></th>
                                    <th>账号</th>
                                    <th>邮箱地址</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>

                                <tbody id="userData">

                                </tbody>

                                <tfoot>
                                <tr >
                                    <td colspan="6" align="center">
                                        <ul class="pagination">

                                        </ul>
                                    </td>
                                </tr>

                                </tfoot>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/static/jquery/jquery-3.5.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/script/docs.min.js"></script>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<script type="text/javascript">
    var likeflg = false;
    var pagepn =1;
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });

        pageQuery(1);

        $("#queryBtn").click(function(){
            var queryText = $("#queryText").val();
            if ( queryText == "" ) {
                likeflg = false;
            } else {
                likeflg = true;
            }

            pageQuery(1);
        });

        $("#allSelBox").click(function(){
            var flg = this.checked;

            $("#userData :checkbox").each(function(){
                this.checked = flg;
            });
        });
    });
    // $("tbody .btn-success").click(function(){
    //     window.location.href = "assignRole.html";
    // });
    // $("tbody .btn-primary").click(function(){
    //     window.location.href = "edit.html";
    // });

    // 分页查询
    function pageQuery( pn ) {
        //清除全选框样式
        $("#allSelBox").prop("checked",false);
        pagepn = pn;
        var loadingIndex = null;
        var jsonData = {"pn" : pn};
        if (likeflg) {
            jsonData.queryText = $("#queryText").val();
        }

        $.ajax({
            type : "POST",
            url  : "${APP_PATH}/user/pageQuery",
            data : jsonData,
            beforeSend : function(){
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success : function(result) {
                layer.close(loadingIndex);
                if ( result.code==100 ) {
                    // 局部刷新页面数据
                    var tableContent = "";
                    var pageContent = "";
                    var userPage = result.extend.pageInfo;
                    var users = userPage.list;

                    $.each(users, function(i, user){
                        tableContent += '<tr>';
                        tableContent += '  <td>'+(i+1)+'</td>';
                        tableContent += '  <td><input type="checkbox" name="userid" value="'+user.id+'"></td>';
                        tableContent += '  <td>'+user.name+'</td>';
                        tableContent += '  <td>'+user.email+'</td>';
                        tableContent += '  <td>';
                        tableContent += '      <button type="button" onclick="goAssignPage('+user.id+')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                        tableContent += '      <button type="button" onclick="goUpdatePage('+user.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
                        tableContent += '	  <button type="button" onclick="deleteUser('+user.id+', \''+user.name+'\','+pn+')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                        tableContent += '  </td>';
                        tableContent += '</tr>';
                    });

                    if ( pn > 1 ) {
                        pageContent += '<li><a href="#" onclick="pageQuery('+(1)+')">首页</a></li>';
                        pageContent += '<li><a href="#" onclick="pageQuery('+(pn-1)+')">上一页</a></li>';
                    }

                    for ( var i = 1; i <= userPage.pages; i++ ) {
                        if ( i == pn ) {
                            pageContent += '<li class="active"><a  href="#">'+i+'</a></li>';
                        } else {
                            pageContent += '<li ><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
                        }
                    }

                    if ( pn < userPage.pages ) {
                        pageContent += '<li><a href="#" onclick="pageQuery('+(pn+1)+')">下一页</a></li>';
                        pageContent += '<li><a href="#" onclick="pageQuery('+(userPage.pages)+')">末页</a></li>';
                    }

                    $("#userData").html(tableContent);
                    $(".pagination").html(pageContent);
                } else {
                    layer.msg("用户信息分页查询失败", {time:2000, icon:5, shift:6}, function(){

                    });
                }
            }
        });
    }

    function goUpdatePage(id) {
        window.location.href = "${APP_PATH}/user/edit?id="+id;
    }

    function goAssignPage(id) {
        window.location.href = "${APP_PATH}/user/assign?id="+id;
    }


    /**
     * 批量删除
     */
    function deleteUsers() {
        var boxes = $("#userData :checkbox");
        if ( boxes.length == 0 ) {
            layer.msg("请选择需要删除的用户信息", {time:2000, icon:5, shift:6}, function(){

            });
        } else {
            layer.confirm("删除选择的用户信息, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
                // 删除选择的用户信息
                console.info($("#userForm").serialize());
                $.ajax({
                    type : "DELETE",
                    url  : "${APP_PATH}/user/deletes",
                    data : $("#userForm").serialize(),
                    success : function(result) {
                        if ( result.code==100 ) {
                            pageQuery(pagepn);
                        } else {
                            layer.msg("用户信息删除失败", {time:2000, icon:5, shift:6}, function(){

                            });
                        }
                    }
                });

                layer.close(cindex);
            }, function(cindex){
                layer.close(cindex);
            });
        }
    }

    function deleteUser( id, name ,pn) {
        layer.confirm("删除用户信息【"+name+"】, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
            console.info(id);
            // 删除用户信息
            $.ajax({
                type : "DELETE",
                url  : "${APP_PATH}/user/delete/"+id,
                success : function(result) {
                    if ( result.code==100 ) {
                        pageQuery(pn);
                    } else {
                        layer.msg("用户信息删除失败", {time:2000, icon:5, shift:6}, function(){
                        });
                    }
                }
            });

            layer.close(cindex);
        }, function(cindex){
            layer.close(cindex);
        });
    }
</script>
</body>
</html>

