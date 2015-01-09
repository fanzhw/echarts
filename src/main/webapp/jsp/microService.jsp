<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="../static/js/microService.js"></script>
<script type="text/javascript" src="../static/js/WdatePicker/WdatePicker.js"></script>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-2">
        	<ul class="side_nav">
            	<li><a href="#" class="side_nav_on">微服务</a>
                	<ul>
                        <li class="active"><a href="#">服务记录</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
        	<div class="search well">
            	<ul class="row list-inline">
                	<li class="col-md-2">服务类别：<select class="form-control"><option>表扬</option><option>投诉</option><option>建议</option><option>其他</option></select></li>
                    <li class="col-md-3">操作状态：<select class="form-control"><option>已回复</option><option>未回复</option></select></li>
                    <li class="col-md-3">开始时间：<input  id="startTime" type="text" onClick="WdatePicker()" class="form-control" style="width:150px"></li>
                    <li class="col-md-3">结束时间：<input  id="stopTime" type="text" onClick="WdatePicker()" class="form-control" style="width:150px"></li>
                    <li class="col-md-1"><button class="btn btn-warning">搜索</button></li>
                </ul>
            </div>
            <div class="row">
            	<h4 class="col-md-2"><strong>详情记录列表</strong></h4>
            </div>
            <table class="table comtable" id="microtab">
            <thead>
            	<tr>
                	<th>序号</th>
                    <th>姓名</th>
                    <th>部门</th>
                    <th>时间</th>
                    <th>服务类别</th>
                    <th>留言内容</th>
                    <th>操作</th>
                </tr>
              </thead>
              <tbody id="micSertbody"></tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal 添加类别弹出-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">微服务回复</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">回复内容:</label>
            <div class="col-sm-8">
              <textarea class="form-control" rows="3"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>


</body>
</html>