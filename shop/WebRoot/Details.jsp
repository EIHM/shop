<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
   
   <h1>书籍的详细信息</h1>
  
   ${bookdetail.bookname}<br>
     ${bookdetail.author}<br>
       ${bookdetail.description}<br>
       
       
       <a href="${pageContext.request.contextPath}/servlet/BuyServlet?id=${bookdetail.id}">加入购物车</a>
       <a href="${pageContext.request.contextPath}/servlet/ShopIndexServlet">回到商城主页</a>
   
  </body>
</html>
