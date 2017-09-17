package com.tm.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tm.daoimpl.BookDaoimpl;
import com.tm.domain.Book;

public class DetailsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("id");
		Integer idint=Integer.parseInt(id);
		BookDaoimpl bl=new BookDaoimpl();
		LinkedHashMap<Integer, Book> linkmap=bl.getAllBook();
		Book book=linkmap.get(idint);
		request.setAttribute("bookdetail", book);
		request.getRequestDispatcher("/Details.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
