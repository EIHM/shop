<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
   
  </head>
  
  <body>
  
   欢迎来到登录界面<br>
   
     ${message}
     <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
     
     <input type="text" name="name">
     <input type="password" name="password">
     <input type="submit">
     
     </form>
   
  </body>
</html>
