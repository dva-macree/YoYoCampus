<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>悠悠驾校</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width" />
    <meta name="viewport" content="height=device-height" />
    <meta name="viewport" content="user-scalable=no" />
    <meta name="viewport" content="initial-scale=1,width=device-width" />

    <meta name="author" content="jiangzy,jiangzy@163.com">
    <link rel="stylesheet" href="<%=basePath%>/bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=basePath%>/app2.css">
    <script src="<%=basePath%>/bower_components/jquery/dist/jquery.js"></script>
    <script src="<%=basePath%>/bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script src="<%=basePath%>/gotoTop.js"></script>
</head>


<body>
    <div class="page">
        <header class="appAdvertise" style="display:none">
            <div class="logo">
                <strong>悠悠校园</strong> ——大学生服务中心
            </div>
            <div class="download">
                <button class="btn">直接下载</button>
            </div>
        </header>
        <nav class="navbar nav">
            <a href="#" class="navArrow">驾校一点通</a> 
            
            <div class="option" id="options" style="display:none;">
                <ul>
                    <li>
                        <img src="images/user_center.gif">个人中心</li>
                    <li>
                        <img src="images/homepage.gif">悠悠校园</li>
                    <li>
                        <img src="images/homepage.gif">驾校一点通</li>
                </ul>
            </div>
        </nav>
        <div class="container">

            <div class="panel panel-default">
                <ul class="list-group" id="carSchoolList">
                <c:forEach var="carConnSchool" items="${carConnSchools}" varStatus="vs">
                    <li class="list-group-item schoolList" id="carSchool${vs.index+1}">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-4">
                                    <img class="img-responsive" src="images/car1.png" />
                                </div>
                                <div class="col-xs-8">
                                    <div class="row">
                                        <div class="col-xs-8 schoolName" >${carConnSchool.carSchool.carSchoolName}</div>
                                        <div class="col-xs-4 schoolDistance">${carConnSchool.distance}km</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 discountPrice">￥${carConnSchool.carSchoolNorprice}</div>
                                    </div>
                                    <div class="row">
<!--
                                        <div class="col-xs-3 oldPrice">￥3300</div>
                                        <div class="col-xs-4 discount">8.8折</div>
                                        <div class="col-xs-5 studentNum">已购300人</div>
-->
                                        <span class=" oldPrice">￥${carConnSchool.carSchool.carSchoolNorOriPrice}</span>
                                        <span class="discount">8.8折</span>
                                        <span class="studentNum">已购${carConnSchool.carSchool.studentNum}人</span>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </li>
                    </c:forEach>
                </ul>
            </div>

        </div>

    </div>
    <script>
        var select = $('#navMenu');
        var options = $('#options');
        var popStatus = false;
        select.click(function () {
            //            alert('Hello');
            if (!popStatus) {
                if (!($(this).is(":animated"))) {
                    options.slideDown();
                } else {
                    options.css("display", "none");
                }
                popStatus = true;
            } else {
                if (!($(this).is(":animated"))) {
                    options.slideUp();
                } else {
                    $(this).stop(true, true);
                    options.css("display", "");
                }
                popStatus = false;
            }
        });

    </script>
    <script>
    	$(function (){
    		$("#carSchoolList").children().bind('click',function(e){
    			var id = e.currentTarget.attributes['id'].value.substring(9);
    			console.log(e.currentTarget.attributes['id'].value.substring(9));
    			window.location.href= "carschool/"+id+"/detail.html";	
    		});
    	});
    </script>
</body>


</html>