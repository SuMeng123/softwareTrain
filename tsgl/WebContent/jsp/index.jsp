<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>图书管理系统</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='/tsgl/jsp/img/windows.ico'>
    <script type="text/javascript" src="/tsgl/jsp/js/jquery-2.2.4.min.js"></script>
    <link href="./css/animate.css" rel="stylesheet">
    <script type="text/javascript" src="/tsgl/jsp/component/layer-v3.0.3/layer/layer.js"></script>
    <link rel="stylesheet" href="/tsgl/jsp/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="/tsgl/jsp/css/default.css" rel="stylesheet">
    <script type="text/javascript" src="/tsgl/jsp/js/win10.js"></script>
    <style>
        * {
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu
        }

        /*磁贴自定义样式*/
         .win10-block-content-text {
             line-height: 44px;
             text-align: center;
             font-size: 16px;
         }
    </style>
    <script>
        Win10.onReady(function () {

            //设置壁纸
            Win10.setBgUrl({
                main: '/tsgl/jsp/img/wallpapers/main.jpg',
                mobile: '/tsgl/jsp/img/wallpapers/mobile.jpg',
            });

            Win10.setAnimated([
                'animated flip',
                'animated bounceIn',
            ], 0.01);
        });
    </script>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="win10-shortcuts" class="shortcuts-hidden">
            <div class="shortcut" onclick='Win10.openUrl("<%=basePath%>userAction.action","<i class=\"fa fa-user icon black-green\"></i>登录页")'>
                <i class="fa fa-user icon black-green"></i>
                <div class="title">登录</div>
            </div>
            <div class="shortcut" onclick='Win10.openUrl("<%=basePath%>bookAction.action","图书查询")'>
                <img class="icon" src="/tsgl/jsp/img/icon/blogger.png"/>
                <div class="title">查询</div>
            </div>
        </div>
        <div id="win10-desktop-scene"></div>
    </div>
    <div id="win10-menu" class="hidden">
        <div class="list win10-menu-hidden animated animated-slideOutLeft">
            <div class="item"
                 onclick="Win10.exit()">
                <i class="black icon fa fa-power-off fa-fw"></i><span class="title">关闭</span>
            </div>
        </div>
        <div class="blocks">
            <div class="menu_group">
                <div class="title">Welcome</div>
                <div class="block" loc="1,1" size="6,4">
                    <div class="content">
                        <div style="font-size:100px;line-height: 132px;margin: 0 auto ;display: block"
                             class="fa fa-fw fa-windows win10-block-content-text"></div>
                        <div class="win10-block-content-text" style="font-size: 22px">Welcome</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="win10-menu-switcher"></div>
    </div>
    <div id="win10_command_center" class="hidden_right">
        <div class="title">
            <h4 style="float: left">消息中心 </h4>
            <span id="win10_btn_command_center_clean_all">全部清除</span>
        </div>
        <div class="msgs"></div>
    </div>
    <div id="win10_task_bar">
        <div id="win10_btn_group_left" class="btn_group">
            <div id="win10_btn_win" class="btn"><span class="fa fa-windows"></span></div>
            <div class="btn" id="win10-btn-browser"><span class="fa fa-internet-explorer"></span></div>
        </div>
        <div id="win10_btn_group_middle" class="btn_group"></div>
        <div id="win10_btn_group_right" class="btn_group">
            <div class="btn" id="win10_btn_time"></div>
            <div class="btn" id="win10_btn_command"><span id="win10-msg-nof" class="fa fa-comment-o"></span></div>
            <div class="btn" id="win10_btn_show_desktop"></div>
        </div>
    </div>
</div>
</body>
</html>