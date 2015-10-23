<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>征文投票</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <script type="text/javascript">
        var phoneWidth =  parseInt(window.screen.width);
        var phoneScale = phoneWidth/640;
        var ua = navigator.userAgent;
        if (/Android (\d+\.\d+)/.test(ua)){
            var version = parseFloat(RegExp.$1);
            if(version>2.3){
                document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
            }else{
                document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
            }
        } else {
            document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
        }
    </script>
    <meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/check.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/jquery.turndiv.css">
    <script type="text/javascript" src="js/jquery.turndiv.js"></script>
</head>

<body onload="checkSubscribed();hasIdentity();" id="tyds_index">
<!-- banner -->
<div id="banner"></div>
<!-- 规则 -->
<div id="regular" onclick="turnRegular()"></div>
<div id="regular_1"></div>
<div id="vote"></div>
<div id="vote_1">
    <table border="0" cellpadding="10" cellspacing="0" align="center">
        <tr>
            <td></td>
            <td>序号</td>
            <td width="100px" align="center">书名</td>
            <td>作者</td>
            <td>票数</td>
        </tr>
        <tr>
            <td><input type="checkbox" ></td>
            <td>1</td>
            <td width="100px" align="center">Java编程思想</td>
            <td>埃克尔</td>
            <td>0</td>
        </tr>
        <tr>
            <td><input type="checkbox" ></td>
            <td>2</td>
            <td width="100px" align="center">Java编程思想</td>
            <td>埃克尔</td>
            <td>0</td>
        </tr>
        <tr>
            <td><input type="checkbox" ></td>
            <td>3</td>
            <td width="100px" align="center">Java编程思想</td>
            <td>埃克尔</td>
            <td>0</td>
        </tr>
        <tr>
            <td><input type="checkbox" ></td>
            <td>4</td>
            <td width="100px" align="center">Java编程思想</td>
            <td>埃克尔</td>
            <td>0</td>
        </tr>
    </table>
</div>
<!-- <input id="Button1" type="button" value="点击弹出层" onclick="ShowDiv('MyDiv','fade')" /> -->
<!-- 遮罩层 -->
<div id="fade" class="black_overlay"></div>
<!-- 关注公众号弹出层 -->
<div id="MyDiv" class="white_content_small">
    <div style="text-align: center; cursor: default; height: 50%;font-size: 30px">请先关注公众号</div>
    <div style="text-align: center; cursor: default; height: 50%;">
        <span style="font-size: 30px;" onclick="parent.location.href='http://www.baidu.com'">确定</span>
    </div>
</div>
<!-- 身份弹出层 -->
<div id="IdentityDiv" class="white_content_small">
    <div style="text-align: center; cursor: default; height: 50%;font-size: 30px">我是</div>
    <span style="font-size: 30px;" onclick="senddiv()">律师</span>
    <span style="font-size: 30px;" onclick="other()">其他</span>
</div>
<!--提交律师照层-->
<div id="SendDiv" class="white_content_small">
    <div style="text-align: center; cursor: default; height: 50%;font-size: 30px">请选择你的律师资格证照</div>
    <form action="?" enctype="multipart/form-data" method="post">
        <input type="file" id="imgfile">
        <input type="submit" id="submit">
    </form>
</div>
</body>
</html>