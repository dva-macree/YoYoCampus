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
    <title>校园淘-报名</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/apply-detailinfo.css" rel="stylesheet">    
    <script type="text/javascript" src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
  </head>
  <body style="background-color: #fff;">
    <div class="top-nav">
      <span class="glyphicon glyphicon-menu-left"></span>
      <h4 style="display:inline-block">发表评论</h4>
      <div class="right-nav"><img src="<%=basePath%>/images/dotdot.png"/><br clear=all/></div>
    </div>
    <div class="content">
      <div class="row main-head">
        <img class="col-xs-4" src="<%=basePath%>/images/6.png"/>
        <h5 class="col-xs-3 name" >school</h5>
        <span class="col-xs-2"></span>
        <h5 class="col-xs-2 distance">3.5km</h5>
        <h5 class="col-xs-3 price">￥3100</h5>
      </div>
      <div class="middle-content">
        <ul class="label-list">
          
          <li><input type="radio" checked="checked" name="enviroment" id="enviroment_1" ></input><label name="a" for="enviroment_1"><img src='<%=basePath%>/images/get.png'/>a</label></li>
          <li><input type="radio" checked="checked" name="subscript" id="subscript_1" ></input><label name="d" for="subscript_1"><img src='<%=basePath%>/images/get.png'/>d</label></li>
          <li><input type="radio" checked="checked" name="coach" id="coach_1" ></input><label name="g" for="coach_1"><img src='<%=basePath%>/images/get.png'/>g</label></li>
          <li><input type="radio" name="enviroment" id="enviroment_2" ></input><label name="b" for="enviroment_2">b</label></li>
          <li><input type="radio" name="subscript" id="subscript_2" ></input><label name="e" for="subscript_2">e</label></li>
          <li><input type="radio" name="coach" id="coach_2" ></input><label name="h" for="coach_2">h</label></li>
          <li><input type="radio" name="enviroment" id="enviroment_3"></input><label name="c" for="enviroment_3">c</label></li>
          <li><input type="radio" name="subscript" id="subscript_3" ></input><label name="f" for="subscript_3">f</label></li>
          <li><input type="radio" name="coach" id="coach_3" ></input><label name="i" for="coach_3">i</label></li>
        </ul>
      </div>

      <div class="comments">
        <textarea rows="3" placeholder="说点什么吧..." class="publish"></textarea>
        <input type="button" value="发布" id="publish-btn" />
      </div>


    </div>
  </body>
  <script type="text/javascript">
  Date.prototype.Format = function(fmt)   
  { //author: meizz   
    var o = {   
      "M+" : this.getMonth()+1,                 //月份   
      "d+" : this.getDate(),                    //日   
      "h+" : this.getHours(),                   //小时   
      "m+" : this.getMinutes(),                 //分   
      "s+" : this.getSeconds(),                 //秒   
      "q+" : Math.floor((this.getMonth()+3)/3), //季度   
      "S"  : this.getMilliseconds()             //毫秒   
    };   
    if(/(y+)/.test(fmt))   
      fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
    for(var k in o)   
      if(new RegExp("("+ k +")").test(fmt))   
    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
    return fmt;   
  }  
  
    $(document).ready(function(){
      $("#publish-btn").click(function(){
        var contentList = {
      	  "carSchoolName" : $(".name")[0].innerHTML,
          "enviroment" : $("input:radio[name='enviroment']:checked + label").attr("name"),
          "subscript" : $("input:radio[name='subscript']:checked + label").attr("name"),
          "coach" : $("input:radio[name='coach']:checked + label").attr("name"),
          "comment" : $(".publish").val(),
          "commentTimestamp" : (new Date()).Format("yyyy-MM-dd hh:mm:ss")
        }
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"1/commentSub.html",
            data:contentList,
            success:function(json){
              alert(json["validateString"]);
            }
          });
      });

      $(".label-list li:lt(3)").addClass("li-good");
      $(".label-list li:gt(2)").addClass("li-bad");
      $("input:radio[name='enviroment'] + label").click(function(){
        var obj = $("input:radio[name='enviroment'] + label");
        for (var i = 0; i < obj.length; ++i){
          if(obj[i].firstChild.nodeType != 3)
            $(obj[i].firstChild).remove();
        }

        if(this.parentNode.firstChild.id == "enviroment_1"){
            this.innerHTML = "<img src='<%=basePath%>/images/get.png'/>" + this.innerHTML;
        }
        else 
          this.innerHTML = "<img src='<%=basePath%>/images/get-bad.png'/>" + this.innerHTML;
          
      });
      $("input:radio[name='subscript'] + label").click(function(){
        var obj = $("input:radio[name='subscript'] + label");
        for (var i = 0; i < obj.length; ++i){
          if(obj[i].firstChild.nodeType != 3)
            $(obj[i].firstChild).remove();
        }

        if(this.parentNode.firstChild.id == "subscript_1"){
            this.innerHTML = "<img src='<%=basePath%>/images/get.png'/>" + this.innerHTML;
        }
        else 
          this.innerHTML = "<img src='<%=basePath%>/images/get-bad.png'/>" + this.innerHTML;
          
      });
      $("input:radio[name='coach'] + label").click(function(){
        var obj = $("input:radio[name='coach'] + label");
        for (var i = 0; i < obj.length; ++i){
          if(obj[i].firstChild.nodeType != 3)
            $(obj[i].firstChild).remove();
        }

        if(this.parentNode.firstChild.id == "coach_1"){
            this.innerHTML = "<img src='<%=basePath%>/images/get.png'/>" + this.innerHTML;
        }
        else 
          this.innerHTML = "<img src='<%=basePath%>/images/get-bad.png'/>" + this.innerHTML;
          
      });
    });

  </script>
</html>