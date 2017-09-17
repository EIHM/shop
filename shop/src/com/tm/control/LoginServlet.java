package com.tm.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tm.domain.User;
import com.tm.serviceimpl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String name=request.getParameter("name");
           String password=request.getParameter("password");
           BusinessServiceImpl bs=new BusinessServiceImpl();
           User user=bs.login(name, password);
           if(user.getName()==null){
        	   request.setAttribute("message", "用户名不存在请重新输入");
        	   request.getRequestDispatcher("/login.jsp").forward(request, response);
        	  
           }else{
        	   HttpSession session=request.getSession();
        	   session.setAttribute("userdata",user);
        	   request.getRequestDispatcher("/servlet/ShopIndexServlet").forward(request, response);
           }
		
	}

}
