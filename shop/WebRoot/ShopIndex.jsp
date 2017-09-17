<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>shopping Index</title>
    
	<!-- <script type="text/javascript">
	   window.onload=function(){
	    var btn1=document.getElementById("btn");
	    btn1.onclick=function(){
	         
	         var jump=document.getElementById("jump");
	         jump.submit();
	    
	    }
	    
	}
	</script> -->

  </head>
  
  <body>
  
  
    <h1>商城首页</h1><br>
    欢迎：${userdata.name} 购物<br><br><br><br><br>
    
    <c:forEach var="entry" items="${allbook.hashmap}">   
   ------
     <a href="${pageContext.request.contextPath}/servlet/DetailsServlet?id=${entry.value.id}">${entry.value.bookname}</a><br> 
    
     </c:forEach> 
     
     <br><br><br>
     
     共[${allbook.totalrecord}]条记录,每页[${allbook.pagesize}]条,共[${allbook.totalpage}]页,当前第[${allbook.currentpage}]页,
     
     <a href="${pageContext.request.contextPath}/servlet/ShopIndexServlet?id=${allbook.previouspage}">上一页</a>
     
    <c:forEach var="page" items="${allbook.pagebar}">
               <a href="${pageContext.request.contextPath}/servlet/ShopIndexServlet?id=${page}">${page}</a>
    </c:forEach> 
           
        <a href="${pageContext.request.contextPath}/servlet/ShopIndexServlet?id=${allbook.nextpage}">下一页</a>
      <!--   跳转到<input type="text" name="id" id="jump">页   &nbsp&nbsp  <button  id="btn" value="确定" name="haha"></button>   -->
  </body>
</html>
