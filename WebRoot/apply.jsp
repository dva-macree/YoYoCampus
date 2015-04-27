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
    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/css/apply-detailinfo.css" rel="stylesheet">    
    <script type="text/javascript" src="<%=basePath%>/js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="top-nav">
      <span class="glyphicon glyphicon-menu-left"></span>
      <h4 style="display:inline-block">报名信息</h4>
      <div class="right-nav"><img src="<%=basePath%>/images/dotdot.png"/><br clear=all/></div>
    </div>
    <div class="content apply-content">
      <ul>
        <li>
          驾校名称：&nbsp;&nbsp;&nbsp;<span id="schoolName">school</span>
        </li>
        <li>
          姓　　名：&nbsp;&nbsp;&nbsp;<input type="text" id="username" class="apply-input"></input>
        </li>
        <li>
          手　　机：&nbsp;&nbsp;&nbsp;<input type="text" id="phonenum" class="apply-input"></input>
        </li>
        <li>
          班级分类：&nbsp;&nbsp;&nbsp;
          <input type="radio" checked="checked" name="classify" id="normal"></input>
          <label name="normal" class="checked" for="normal">常规班　　<span>3100</span>元/人</label>
          <br/>
          　　　　　&nbsp;&nbsp;&nbsp;
          <input type="radio" name="classify" id="vip"></input>
          <label name="vip" for="vip">ＶIP班　　<span>3500</span>元/人</label>
        </li>
      </ul>
      <input type="button" value="立即报名" id="apply" class="sub-btn" data-toggle="modal"/>

      <div class="modal" id="sub-success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-content">
          <div class="tel-display">
            <span>13009877348</span>
          </div>
          <h5 id="resultDisplay"></h5>
        </div>
      </div>
    </div>
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

      $(function() {
        $('label').click(function(){
          var radioId = $(this).attr('name');
          $('label').removeAttr('class') && $(this).attr('class', 'checked');
          $('input[type="radio"]').removeAttr('checked') && $('#' + radioId).attr('checked', 'checked');
        });
        
        $("#sub-success").click(function(){
            $("#sub-success").fadeOut();
            $("body").css("overflow","auto");
            $("#username").val("");
            $("#phonenum").val("");
          });
        
        $("#apply").click(function(){
          var checkedId = $("input:radio[name='classify']:checked").attr("id");
          var selectStr = "label[name='"+checkedId+"'] span";

          var orderList = {
            "carSchoolName" : $("#schoolName")[0].innerHTML,
            "userName" : $("#username").val(),
            "phonenum" : $("#phonenum").val(),
            "carSchoolClass" : checkedId,
            "carSchoolPrice" : $(selectStr)[0].innerHTML,
            "carOrderTimestamp" : (new Date()).Format("yyyy-MM-dd hh:mm:ss")
          };
		  
          $.ajax({
            type:"GET",
            dataType:"json",
            url:"apply/apply.html",
            data:orderList,
            success:function(json){
            	console.log(json+"---成功");
              $("#resultDisplay")[0].innerHTML = "　　客官您好，您在小时光预约的信息已成功。待驾校人员联系你后，携带身份证前去办理相关手续。若有疑问，请联系校内负责人：145-5654-3533";
              $("body").css("overflow","hidden");
              $("#sub-success").fadeIn();
            }
          });
          
        });
      });
    </script>
  </body>

</html>