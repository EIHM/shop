package com.tm.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tm.daoimpl.BookDaoimpl;
import com.tm.daoimpl.UserDaoimpl;
import com.tm.domain.Book;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDaoimpl bd = new BookDaoimpl();
		String id = request.getParameter("id");
		Integer idInt = Integer.parseInt(id);
		LinkedHashMap<Integer, Book> linkmap = bd.getAllBook();
		Book book = linkmap.get(idInt);// 获取传递过来的书

		HttpSession session = request.getSession();

		List<Book> listcart = (List) session.getAttribute("Cartlist");
		if (listcart == null) {
			listcart = new ArrayList<Book>();

		}
		listcart.add(book);
		session.setAttribute("Cartlist", listcart);
		response.sendRedirect(request.getContextPath()+"/Cart.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
