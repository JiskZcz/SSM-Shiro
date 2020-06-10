<%--
  Created by IntelliJ IDEA.
  User: h135m
  Date: 2020/6/7
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${APP_PATH}/static/css/doc.min.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="../main"><创网></创网>平台 - 用户维护</a></div>
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
                                <a href="../role/index"><i class="glyphicon glyphicon-certificate"></i> 角色维护</a>
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
            <ol class="breadcrumb">
                <li><a href="../main">首页</a></li>
                <li><a href="./index">数据列表</a></li>
                <li class="active">分配角色</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form id="roleForm" role="form" class="form-inline">
                        <input type="hidden" name="userid" value="${userid}">
                        <div class="form-group">
                            <label for="exampleInputPassword1">未分配角色列表</label><br>
                            <select id="leftList" name="unassignroleids" class="form-control" multiple size="10" style="width:200px;overflow-y:auto;">
                                <c:forEach items="${unassignRoles}" var="role">
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <ul>
                                <li id="left2RightBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                                <br>
                                <li id="right2LeftBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                            </ul>
                        </div>
                        <div class="form-group" style="margin-left:40px;">
                            <label for="exampleInputPassword1">已分配角色列表</label><br>
                            <select id="rightList" name="assignroleids" class="form-control" multiple size="10" style="width:200px;overflow-y:auto;">
                                <c:forEach items="${assignRoles}" var="role">
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </form>
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

        $("#left2RightBtn").click(function(){
            var opts = $("#leftList :selected");
            if ( opts.length == 0 ) {
                layer.msg("请选择需要分配的角色数据", {time:2000, icon:5, shift:6}, function(){

                });
            } else {

                $.ajax({
                    type : "POST",
                    url  : "${APP_PATH}/user/doAssign",
                    data : $("#roleForm").serialize(),
                    success : function(result) {
                        if ( result.code==100 ) {
                            $("#rightList").append(opts);
                            layer.msg("分配角色数据成功", {time:2000, icon:6}, function(){
                            });
                        } else {
                            layer.msg("分配角色数据失败", {time:2000, icon:5, shift:6}, function(){
                            });
                        }
                    }
                });
            }
        });
        $("#right2LeftBtn").click(function(){
            var opts = $("#rightList :selected");
            if ( opts.length == 0 ) {
                layer.msg("请选择需要取消分配的角色数据", {time:2000, icon:5, shift:6}, function(){

                });
            } else {
                $.ajax({
                    type : "POST",
                    url  : "${APP_PATH}/user/dounAssign",
                    data : $("#roleForm").serialize(),
                    success : function(result) {
                        if ( result.code==100 ) {
                            $("#leftList").append(opts);
                            layer.msg("取消分配角色数据成功", {time:2000, icon:6}, function(){
                            });
                        } else {
                            layer.msg("取消分配角色数据失败", {time:2000, icon:5, shift:6}, function(){
                            });
                        }
                    }
                });

            }
        });
    });
</script>
</body>
</html>
