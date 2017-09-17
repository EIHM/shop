<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
  </head>
  
  <body>
   
   <h2>welcome register page</h2><br><br>
   <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
   ${message} <br>
   <input type="text" name="name"> <br>
   <input type="password" name="password"><br>
   <input type="submit"><br>
   
   </form>
  </body>
</html>
