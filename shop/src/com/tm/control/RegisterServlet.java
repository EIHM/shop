package com.tm.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tm.domain.User;
import com.tm.serviceimpl.BusinessServiceImpl;
import com.tm.userexception.ExistUserException;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		BusinessServiceImpl bs=new BusinessServiceImpl();
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		try {
			bs.register(user);
		} catch (ExistUserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", "用户已存在，请重新注册");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}catch(Exception e){
			request.setAttribute("message","服务器问题");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("message","恭喜注册成功");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
