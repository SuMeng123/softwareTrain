<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>信息管理</title>
<link href="/tsgl/new/css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
<script src="/tsgl/new/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="/tsgl/new/js/jquery-accordion-menu.js" type="text/javascript"></script>
<script type="text/javascript">

jQuery(document).ready(function () {
	jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
	
});

$(function(){	
	//顶部导航切换
	$("#demo-list li").click(function(){
		$("#demo-list li.active").removeClass("active")
		$(this).addClass("active");
	})	
})	
</script>
</head>
<body>
    <div class="big">
        <!--左边的导航-->
        

        <!--右边的内容-->
        <div class="right">
            <div class="right_top">
               <%--  <span>学生信息管理系统</span>
                <a href="http://localhost:54436/zhuxiao.ashx">退出系统</a> --%>
            </div>
            <div class="right_addnew">
                <h2>缺书管理</h2>
            </div>
            <!--以上的不变-->
            <form id="form1" action="<%=basePath%>bookAction!addQsDj.action" method="post">
               <input type="hidden" id ="userID" name="dj.userId" value ="${user.userId }"/>
             
                <div class="name">
                    <label>书名<input type="text" id ="Name" name="dj.djName" value =""/></label><label id="Name1" style="color:#ff0000; margin-left:0px"></label>
                </div>
                <div class="name">
                    <label>作者<input type="text" id ="Phone" name="dj.djAu" value =""/></label><label id="High1" style="color:#ff0000; margin-left:0px"></label>
                </div>
                 <div class="right_addchengyuanbtn">
                    <a class="chengyuanbtn01" href="#" id="TJ">确定</a>
                    <a class="chengyuanbtn02" href="#">取消</a>
                </div>
                </form>
            </div><!--right-->
    </div>
    <input type="hidden" id ="flag" value="${flag }"/>
<script type="text/javascript">
    $("#TJ").click(function () {
    	if($("#Name").val() == null || $("#Name").val() == '' )
    	{
    		alert("姓名不能为空");
    		
    	}
    	else if($("#Phone").val() == null || $("#Phone").val() == '' )
    	{
    		alert("电话不能为空");
    		
    	}
    	else
    	{
    		$("#form1").submit();
    	}
    	

    });
</script>
<script type="text/javascript">
$(function() {
  alert($("#flag").val());
});
</script>
</body>
</html>
