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

    <meta name="author" content="jiagnzy,jiangzy@163.com">
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
            <a href="#" class="navArrow">详情页面</a> 
            <a href="#" class="navMenu" id="navMenu"></a>
            <div class="option" id="options" style="display:none">
                <ul>
                    <li>
                        <img src="images/user_center.gif"><small>个人中心</small>
                    </li>
                    <li class="navMenuListBody">
                        <img src="images/homepage.gif"><small>悠悠校园</small>
                    </li>
                    <li>
                        <img src="images/homepage.gif"><small>驾校一点通</small>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">

            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                <c:forTokens items="${carConnSchool.carSchool.carSchoolImg}" delims=";" var="varName" varStatus="vs">
                	<c:if test="${vs.index == 1}">
                	<div class="item active">
                		<img src="images/${varName}" alt="...">
                	</div>
                	</c:if>
                	
                	<c:if test="${vs.index != 1}">
                	<div class="item">
                		<img src="images/${varName}" alt="...">
                	</div>
                	</c:if>
                	
                </c:forTokens>
            <!-- 	<div class="item active">
                        <img src="images/car1.png" alt="...">
                    </div>
                    <div class="item">
                        <img src="images/car2.png" alt="...">

                    </div> -->
                </div>


            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-6" id="schoolName">
                                ${carConnSchool.carSchool.carSchoolName}
                            </div>
                            <div class="col-xs-3" id="collect">
                                <img src="images/collect.png">收藏</div>
                            <div class="col-xs-3" id="share">
                                <img src="images/share.png">分享</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6" id="Price"> <span class="discountPrice"> ${carConnSchool.carSchoolNorprice}元</span><span class="oldPrice">${carConnSchool.carSchool.carSchoolNorOriPrice}元</span>

                            </div>

                            <div class="col-xs-6" id="student">
                                <img src="images/student.png"><strong>${carConnSchool.carSchool.studentNum}</strong>人已购买</div>
                        </div>
                    </div>

                    <div class="row" id="service">
                    <c:forEach var="service" items="${carConnSchool.carSchool.services}">
                    	<div class="col-xs-4" id="bus_service">
                            <img src="images/${service.carServiceImg}">${service.carServiceName}</div>
                    </c:forEach>
                    <!-- <div class="col-xs-4" id="bus_service">
                            <img src="images/bus_service.png">班车接送</div>
                        <div class="col-xs-4" id="order_service">
                            <img src="images/online_order.png">在线预订</div>
                        <div class="col-xs-4" id="campus_contactor">
                            <img src="images/campus_contactor.png">校内联系人</div> -->    
                    </div>

                </div>




            </div>
            <div class="panel panel-default">
                <div class="panel-heading">特色服务</div>
                <div class="panel-body">
                    <div class="container" id="feature">
                        <ul>
                        	<c:forTokens items="${specialServices}" delims=";" var="varName">
                        		<li>${varName}</li>
                        	</c:forTokens>
                            <!-- <li>配备校内服务人员指导</li>
                            <li>报名即有精美礼品赠送</li>
                            <li>5人以上团报立减50元</li> -->
                        </ul>
                    </div>

                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading classGroup" data-toggle="collapse" href="#collapseExample0" aria-expanded="false" aria-controls="collapseExample">
                    <div class="container">
                        <div class="col-xs-4">普通班</div>
                        <div class="col-xs-6 text-right"><span class="oldPrice">${carConnSchool.carSchool.carSchoolNorOriPrice}元</span><span class="discountPrice">${carConnSchool.carSchoolNorprice}元</span>
                        </div>
                        <div class="col-xs-2">
                            <img class="img-responsive foldArrow" src="images/list_fold.png">
                        </div>
                    </div>

                </div>
                <div class="collapse" id="collapseExample0">
                    <div class="well">
                        <p>针对大学生优化，价格比社会人士更加优惠，司车学员一般为本校的同学，驾校推荐。</p>
                    </div>
                </div>

                <div class="panel-heading classGroup" data-toggle="collapse" href="#collapseExample1" aria-expanded="false" aria-controls="collapseExample">
                    <div class="container">
                        <div class="col-xs-4">VIP班</div>
                        <div class="col-xs-6 text-right"><span class="oldPrice">${carConnSchool.carSchool.carSchoolVipOriPrice}元</span><span class="discountPrice"> ${carConnSchool.vipprice}元</span>
                        </div>
                        <div class="col-xs-2">
                            <img class="img-responsive foldArrow" src="images/list_fold.png">
                        </div>
                    </div>

                </div>
                <div class="collapse" id="collapseExample1">
                    <div class="well">
                        <p>针对大学生优化，价格比社会人士更加优惠，司车学员一般为本校的同学，驾校推荐。</p>
                    </div>
                </div>

            </div>
            <div class="panel panel-default">
                <div class="panel-heading">详情评价：</div>
                <div class="panel-body">
                    <div class="container">
                    <!-- <span class="goodTags">预约方便<small>100</small></span>
                        <span class="goodTags">驾校服务态度很好<small>100</small></span>
                        <span class="goodTags">教练水平高<small>100</small></span>
                        <span class="goodTags">学车速度很快<small>100</small></span>
                        <span class="goodTags">预约很方便<small>100</small></span> -->
                    	 <c:forEach var="goodCarConnTag" items="${goodCarConnTags}">
	                        <span class="goodTags">${goodCarConnTag.tag.carTagName}<small>${goodCarConnTag.carTagNum}</small></span>
                        </c:forEach>
                        
                        <c:forEach var="badCarConnTag" items="${badCarConnTags}">
                        	<span class="badTags">${badCarConnTag.tag.carTagName}<small>${badCarConnTag.carTagNum}</small></span>
                        </c:forEach>
                        <!-- <span class="badTags">教练服务态度一般<small>18</small></span>
						
                        <span class="badTags">预约不方便<small>18</small></span>
                        <span class="badTags">学车速度一般<small>18</small></span>

                        <span class="badTags">环境一般<small>18</small></span>

                        <span class="badTags">环境一般<small>18</small></span> -->
                    </div>

                </div>
            </div>
            <div class="panel panel-default">
                <!--                <div class="panel-heading">评论列表</div>-->
                <div class="panel-body commentList">
                    <ul class="list-group" id="commentList">
                    	<%--<c:forEach var="comment" items="${commentList}" >
                    		<li class="list-group-item list-item-container">
	                            <div class="row">
	                                <div class="col-xs-3">
	                                    <img class="img-responsive" src="images/user.gif">
	                                </div>
	                                <div class="col-xs-9">
	                                    <div class="row">${comment.mainUser.username}</div>
	                                    <div class="row">${comment.carCommentContent}</div>
	                                </div>
	                            </div>
	                        </li>
                    	</c:forEach> --%>
                        <!--                            <div class="container">-->
<!--                        <li class="list-group-item list-item-container">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img class="img-responsive" src="images/user.gif">
                                </div>
                                <div class="col-xs-9">
                                    <div class="row">马大哈</div>
                                    <div class="row">感觉教练水平棒棒哒，大家踊跃报名哟</div>
                                </div>
                            </div>

                        </li>
                        <li class="list-group-item list-item-container">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img class="img-responsive" src="images/user.gif">
                                </div>
                                <div class="col-xs-9">
                                    <div class="row">马大哈</div>
                                    <div class="row">感觉教练水平棒棒哒，大家踊跃报名哟</div>
                                </div>
                            </div>

                        </li>
                        <li class="list-group-item list-item-container">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img class="img-responsive" src="images/user.gif">
                                </div>
                                <div class="col-xs-9">
                                    <div class="row">马大哈</div>
                                    <div class="row">感觉教练水平棒棒哒，大家踊跃报名哟</div>
                                </div>
                            </div>

                        </li>
                        <li class="list-group-item list-item-container">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img class="img-responsive" src="images/user.gif">
                                </div>
                                <div class="col-xs-9">
                                    <div class="row">马大哈</div>
                                    <div class="row">感觉教练水平棒棒哒，大家踊跃报名哟</div>
                                </div>
                            </div>

                        </li> --> 

                    </ul>
                    <div class="row text-center">
                        <button class="btn btn-default" id="loadMoreComment">更多评论</button>
                    </div>

                </div>

            </div>
            <div class="panel panel-default">
                <!-- Nav tabs -->
                <ul class="navtab" role="tablist">
                    <li role="presentation" class="active col-xs-4 tab-head"><a href="#description" aria-controls="description" role="tab" data-toggle="tab" class="selected">简介</a>
                    </li>
                    <li role="presentation" class="col-xs-4 tab-body"><a href="#learningprocedure" aria-controls="learningprocedure" role="tab" data-toggle="tab">学习流程</a>
                    </li>
                    <li role="presentation" class="col-xs-4 tab-tail"><a href="#bustimetable" aria-controls="bustimetable" role="tab" data-toggle="tab">班车时刻表</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="description">
                   <c:out value=" ${carConnSchool.carSchool.description}" default="空空" /></div>
                    <div role="tabpanel" class="tab-pane" id="learningprocedure">
                   <c:out value="${carConnSchool.carSchool.procedure}" default="空空" /></div>
                    <div role="tabpanel" class="tab-pane" id="bustimetable">
                    <c:out value="${carConnSchool.carSchool.timetable}" default="空空" /></div>
                </div>
            </div>
<!--
                <div class="backTop">
                    <img src="images/backTop.png">
                </div>
-->


            <nav class="navbar  navbar-default navbar-fixed-bottom orderNav">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-7">
                            <span class="discountPrice"> 3100元</span><span class="oldPrice">3300元</span>
                        </div>
                        <div class="col-xs-5">
                            <button class="btn btn-default">立即报名</button>
                        </div>
                    </div>

                </div>
            </nav>
        </div>

    </div>

    <script>
        //var collapseArray = $('.collapse');
         //        console.log(collapseArray[0]);

        $(".navtab li a").click(function () {
            $(this).addClass("selected").parent().siblings().children().removeClass();
        })

         for (var i = 0; i < $('.collapse').length; i++) {
            $('#collapseExample' + i).on('show.bs.collapse', function (e) {
                //                    $('#collapseExample'+i)
                $(this).prev().children().children()[2].children[0].src = "images/list_unfold.png";
                console.log(e);
            });
            $('#collapseExample' + i).on('hide.bs.collapse', function (e) {
                //                    $('#collapseExample'+i)
                $(this).prev().children().children()[2].children[0].src = "images/list_fold.png";
                console.log(e);
            });

        }
    </script>
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
            return false;
        });

    </script>
    <script type="text/javascript">

        
        var BackTop = new BackTop();
	</script>
	<script type="text/javascript">
		$(function(){
			function init(count,start){
				$.ajax({
					type:"GET",
					dataType:"json",
					url:"comment/"+id+"/list.html",
					data:{"pageNo":start},
					success:function(json){
						var str = "";
						$.each(json,function(index,array){
							var str ="<li class='list-group-item list-item-container'>"+
										"<div class='row'>"+
											"<div class='col-xs-3'>"+
												"<img class='img-responsive' src='"+array['commentUserImg']+"'>"+
											"</div>"+
											"<div class='col-xs-9'>"+
												"<div class='row'>"+array['commentUserName']+"</div>"+
												"<div class='row'>"+array['commentContent']+"</div>"+
											"</div>"+			
                                		"</div>"+
				                      "</li>";
				            $("#commentList").append(str);         	
							
						});
						if(json.length == 0)
							$("#loadMoreComment").html("没有更多了");							
					}
				});
			}
			var start = -1;
			var count = 3;
			var id = ${carConnSchool.conn_id};
			$("#loadMoreComment").click(function(){
				start += 1;
				init(count,start);
			});
		});
	</script>
</body>

</html>
