<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="../static/js/department.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-2">
        	<ul class="side_nav">
            	<li><a href="#" class="side_nav_on">部门管理</a>
                	<ul>
                        <li class="active"><a href="#">部门管理</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="row">
            	<h4 class="col-md-2"><strong>部门列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" id="addtype" data-toggle="modal" data-target="#myModal">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <table class="table comtable" id="departmenttab">
            <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">部门名称</th>
                    <th>部门描述</th>
                    <th width="140" class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="departmentbody"></tbody>
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
        <h4 class="modal-title" id="myModalLabel">添加部门</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">部门名称：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="inputEmail3" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">部门描述:</label>
            <div class="col-sm-9">
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