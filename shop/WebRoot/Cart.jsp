<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Cart.jsp' starting page</title>
    
  </head>
  
  <body>
   <h1>购物车页面</h1>
   
   
   <c:forEach items="${Cartlist}" var="list">
          ${list.bookname}
   </c:forEach>
   <br><br><br>
   
   <a href="${pageContext.request.contextPath}/servlet/CartSendShopServlet">回到商城主页</a>
     
      
   
   
  </body>
</html>
