<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style>
        #win10-login {
            background: url('/tsgl/jsp/img/wallpapers/login.jpg') no-repeat fixed;
            width: 100%;
            height: 100%;
            background-size: 100% 100%;
            position: fixed;
            z-index: -1;
            top: 0;
            left: 0;
        }

        #win10-login-box {
            width: 300px;
            overflow: hidden;
            margin: 0 auto;
        }

        .win10-login-box-square {
            width: 105px;
            margin: 0 auto;
            border-radius: 50%;
            background-color: darkgray;
            position: relative;
            overflow: hidden;
        }

        .win10-login-box-square::after {
            content: "";
            display: block;
            padding-bottom: 100%;
        }

        .win10-login-box-square .content {
            position: absolute;
            width: 100%;
            height: 100%;
        }

        input {
            width: 90%;
            display: block;
            border: 0;
            margin: 0 auto;
            line-height: 36px;
            font-size: 20px;
            padding: 0 1em;
            border-radius: 5px;
            margin-bottom: 11px;
        }

        .login-username, .login-password {
            width: 91%;
            font-size: 13px;
            color: #999;
        }

        .login-password {
            width: calc(91% - 54px);
            -webkit-border-radius: 2px 0 0 2px;
            -moz-border-radius: 2px 0 0 2px;
            border-radius: 5px 0 0 5px;
            margin: 0px;
            float: left;
        }

        .login-submit {
            margin: 0px;
            float: left;
            -webkit-border-radius: 0 5px 5px 0;
            -moz-border-radius: 0 5px 5px 0;
            border-radius: 0 5px 5px 0;
            background-color: #009688;
            width: 54px;
            display: inline-block;
            height: 36px;
            line-height: 36px;
            padding: 0 auto;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border: none;
            cursor: pointer;
            opacity: .9;
            filter: alpha(opacity=90);

        }
    </style>
</head>
<body>
<div id="win10-login">
    <div style="height: 10%;min-height: 120px"></div>
    <div id="win10-login-box">
        <div class="win10-login-box-square">
            <img src="/tsgl/jsp/img/avatar.jpg" class="content"/>
        </div>
        <p style="font-size: 24px;color: white;text-align: center">学生</p>
        <form id = "form1" target="_self" method="post" action="<%=basePath%>loginAction.action" >
            <!--用户名-->
            <input type="text" id="userName" name="userName" placeholder="请输入登录名"  class="login-username">
            <!--密码-->
            <input type="password" id = "password" name = "password" placeholder="请输入密码" class="login-password">
            <!--登陆按钮-->
            <input type="button"  onclick="check()" value="登录" id="btn-login" class="login-submit"/>
        </form>
    </div>
</div>
<script src="/tsgl/js/confirm/jquery-1.9.1.min.js"></script>
	<script src="/tsgl/js/laydate/laydate.js"></script>
	<script src="/tsgl/select2/js/select2.full.js"></script>
	<script src="/tsgl/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
        function check() {
        	if($("#userName").val() == null || $("#userName").val() == '' )
        	{
        		alert("登录名不能为空");
        		
        	}
        	else if($("#password").val() == '' || $("#password").val() == null)
        	{
        		alert("密码不能为空");
        		
        	}
        	else
        	{
        		
            	var userName = $("#userName").val();
            	var password = $("#password").val();
            	$.ajax({
    				type : "POST",
    		        url:"<%=basePath%>loginAction!checklogin.action?userName="+ userName+"&password="+password,
    				success : function(jsons) {
    											if(jsons == null || jsons == '')
    											{
    												$("#form1").submit();
    											}
    											else
    											{
    												alert(jsons);
    											}
    										}
    		        
    					});
        	}
        	
        }
</script>
</body>
</html>