package com.tm.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tm.daoimpl.BookDaoimpl;
import com.tm.domain.Book;
import com.tm.domain.PageBean;
import com.tm.domain.QueryInfo;
import com.tm.serviceimpl.FenyeServiceImpl;

public class ShopIndexServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		//String pagesizeString=request.getParameter("pagesizeString");
		QueryInfo qi=new QueryInfo();
		
		if(id==null){
			qi.setCurrentpage(qi.getCurrentpage());  //拿到默认值
		    qi.setPagesize(qi.getPagesize());
		}else{
		Integer idInt=Integer.parseInt(id);
		//Integer pagesize=Integer.parseInt(pagesizeString);
		qi.setCurrentpage(idInt);
	    qi.setPagesize(qi.getPagesize());
		}
	   
	    FenyeServiceImpl fl=new FenyeServiceImpl();
	    PageBean pb= fl.getPageBean(qi);   //获取页面的数据
		
		
		
		HttpSession session=request.getSession();
		request.setAttribute("allbook",pb);
		//response.sendRedirect(request.getContextPath()+"/ShopIndex.jsp");
		request.getRequestDispatcher("/ShopIndex.jsp").forward(request, response);
		
	
		/*BookDaoimpl bookdaoimpl=new BookDaoimpl();
		LinkedHashMap<Integer,Book> linkmap=bookdaoimpl.getAllBook();
		HttpSession session=request.getSession();
		session.setAttribute("allbook",linkmap);
		response.sendRedirect(request.getContextPath()+"/ShopIndex.jsp");*/
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		/*BookDaoimpl bookdaoimpl=new BookDaoimpl();
		LinkedHashMap<Integer,Book> linkmap=bookdaoimpl.getAllBook();*/
		
		
		
		/*String id=request.getParameter("id");
		String pagesizeString=request.getParameter("pagesizeString");
		QueryInfo qi=new QueryInfo();
		
		if(id==null||pagesizeString==null){
			qi.setCurrentpage(qi.getCurrentpage());  //拿到默认值
		    qi.setPagesize(qi.getPagesize());
		}else{
		Integer idInt=Integer.parseInt(id);
		Integer pagesize=Integer.parseInt(pagesizeString);
		qi.setCurrentpage(idInt);
	    qi.setPagesize(pagesize);
		}
	   
	    FenyeServiceImpl fl=new FenyeServiceImpl();
	    PageBean pb= fl.getPageBean(qi);   //获取页面的数据
		
		
		
		HttpSession session=request.getSession();
		session.setAttribute("allbook",pb);
		response.sendRedirect(request.getContextPath()+"/ShopIndex.jsp");*/
	}

}
