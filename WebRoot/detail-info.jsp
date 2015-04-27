<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>校园淘-详细信息</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/apply-detailinfo.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
  </head>
  <style>

  </style>
  <body>
    <div class="top-nav">
      <span class="glyphicon glyphicon-menu-left"></span>
      <h4 style="display:inline-block">订单详情</h4>
      <div class="right-nav"><img src="<%=basePath%>/images/dotdot.png"/><br clear=all/></div>
    </div>
    <div class="content">
      <c:if test="${carOrderState == 1}">
   	  	<div class="alt"><img src="<%=basePath%>/images/time.png"/>审核中...请耐心等待</div>
      </c:if>

      <div class="row main-head">
        <img class="col-xs-4" src="<%=basePath%>/images/6.png"/>
        <h5 class="col-xs-3 name">${carSchoolName}</h5>
        <span class="col-xs-2"></span>
        <h5 class="col-xs-2 distance">3.5km</h5>
        <h5 class="col-xs-3 price">￥${carSchoolPrice}</h5>
        <span class="col-xs-2"></span>
        <div class="col-xs-3 vir-btn">
        	<c:if test="${carOrderState == 1}">
            	审核中
            </c:if>  	
            <c:if test="${carOrderState != 1}">
            	已审核
            </c:if>	
		</div>
      </div>
      <br clear="all"/>
      <div class="detail-content">
        <ul>
          <li>
            <!-- <span class="glyphicon glyphicon-list-alt"></span> -->
            <img src="<%=basePath%>/images/number.png"/>
            订单号：<span>${carOrderId}</span>
          </li>
          <li>
            <!-- <span class="glyphicon glyphicon-time"></span> -->
            <img src="<%=basePath%>/images/time-stamp.png"/>
            提交时间：<span>${carOrderTimestamp}</span>
          </li>
          <li>
            <!-- <span class="glyphicon glyphicon-user"></span> -->
            <img src="<%=basePath%>/images/user.png"/>
            报名学员：<span>${username}</span>
          </li>
          <li>
            <!-- <span class="glyphicon glyphicon-phone"></span> -->
            <img src="<%=basePath%>/images/phone.png"/>
            电　　话：<span>${phonenum}</span>
          </li>
          <li>
            <!-- <span class="glyphicon glyphicon-map-marker"></span> -->
            <img src="<%=basePath%>/images/location.png"/>
            驾校地址：<span class="address">${carSchoolAddr}</span>
          </li>
          <li class="agent">
            校内联系人：<span>张菁</span>
            <span class="agent-tel">13598702398</span>
        </ul>
      </div>
      <br clear=all/>
    </div>
  </body>
</html>