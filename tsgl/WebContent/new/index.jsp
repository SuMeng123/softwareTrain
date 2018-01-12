<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>推荐书目</title>
    <link href="/tsgl/new/css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/tsgl/new/css/main.css">
    <script src="/tsgl/new/js/jquery-1.11.2.min.js" type="text/javascript"></script>
    <script src="/tsgl/new/js/jquery-accordion-menu.js" type="text/javascript"></script>
    <script src="/tsgl/new/js/ajax.js" type="text/javascript"></script>

</head>
<body>
    <div class="big">
        <!--左边的导航-->
      <s:include value="/new/left.jsp" />

        <!--右边的内容-->
        <div class="right">
        	<div style="margin-top:80px;margin-bottom:10px;"></div>
            <%-- <div class="right_top">
                <span>图书管理系统</span>
                <a href="http://localhost:54436/zhuxiao.ashx">退出系统</a>
            </div> --%>
            <%-- <div class="search-content" style="margin-top:10px;margin-bottom:10px;margin-left:200px;">
				<form id = "form1"
					action="<%=basePath%>bookAction!getBooks.action"
					method="post">
					<label>图书类别：</label> 
					<select name="mySelect" id="mySelect" style="height:25px;width:100px;">
							<option value="-1" >全部</option>
						<s:iterator value="cls" var="cl">
						
							<option value="${cl.clid }" <c:if test="${mySelect eq cl.clid}" >selected = "selected"</c:if>>${cl.clNum }</option>					
						
						
						</s:iterator>
					</select> 
					<label style="margin-left:80px;">图书名称：</label><input id="num" type="text" class="w150" name="num"
						value="${num }"  style="height:25px;"> 
				  <input type="button" id="TJ" value="查询"style="margin-left:80px;height:25px;width:80px;"> 
					 <c:if test="${upBooks == null || fn:length(upBooks) == 0}">
               			<a href="<%=basePath%>bookAction!toNewLogin.action?bookId=-1&isJy=缺书"style="margin-left:80px;height:25px;width:80px;">缺书登记</a>  					
               		</c:if>
				</form>
			</div> --%>
          
            <table class="tb04" id="TId">
                <tr>
                <th class="w10">图书编码</th>
                    <th class="w10">图书名称</th>
                    <th class="w10">图书作者</th>
                    <th class="w10">图书状态</th>
                    
                </tr>
               <s:iterator value="tuijians" var="jh">
                <tr>
                 <td>
                        <span class="">${jh.BNum }</span>
                    </td>
                    <td>
                        <span class="">${jh.BName }</span>
                    </td>
                    <td>
                        <span class="">${jh.BAu }</span>
                    </td>
                    <td>
                        <span class="">${jh.BStatus }</span>
                    </td>
                   
                    
                </tr>
               </s:iterator>
            </table>

            <div class="sum-btn">
			<div class="page">${pageHtml}</div>


        </div>
    </div>
    <input type="hidden" id ="flag" value="${flag }"/>
<script type="text/javascript">
    $("#TJ").click(function () {
    	if($("#mySelect").find("option:selected").text() == '全部' &&($("#num").val() == null || $("#num").val() == ''))
    	{
    		alert("选择图书类别或填写图书名称");
    	}
    	else
    	{
    		
    		$("#form1").submit();
    	}
    	

    });
</script>
<script type="text/javascript">
$(function() {
	if($("#flag").val() != null && $("#flag").val() != '')
	{
		alert($("#flag").val());
	}
  
});
</script>
</body>
</html>
