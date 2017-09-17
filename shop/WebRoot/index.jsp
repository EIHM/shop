<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>	
  </head>
  <body>
 

    <a href="${pageContext.request.contextPath}/servlet/LoginUI">登陆</a>
    <a href="${pageContext.request.contextPath}/servlet/RegisterUI">注册</a>
  </body>
</html>
