package com.tm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.tm.dao.BookDao;
import com.tm.domain.Book;
import com.tm.domain.QueryResult;



public class BookDaoimpl implements BookDao {
   static Connection conn=null;
   static PreparedStatement ps=null;
   static ResultSet rs=null;
   
  
   public LinkedHashMap<Integer, Book> getAllBook(){
	   LinkedHashMap<Integer,Book> linkmap=new LinkedHashMap<Integer, Book>();
	   conn=com.tm.utils.UtilTools.getCon();
	   String sql="SELECT id,bookname,author,description FROM book ";
	   try {
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			Book book=new Book();
			book.setId(rs.getInt(1));
			book.setBookname(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setDescription(rs.getString(4));
			linkmap.put(rs.getInt(1),book);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return linkmap;
	   
   }
   
   public QueryResult pageQuery(int startindex,int pagesize){
	   conn=com.tm.utils.UtilTools.getCon();
	   String sql="SELECT id,bookname,author,description FROM book limit ?,? ";
	  
	   QueryResult qr=new QueryResult();
	   HashMap hashmap=new LinkedHashMap();
	   try {
		ps=conn.prepareStatement(sql);
		ps.setInt(1, startindex);
		ps.setInt(2, pagesize);
		rs=ps.executeQuery();
		while(rs.next()){
			Book book=new Book();
			book.setId(rs.getInt(1));
			book.setBookname(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setDescription(rs.getString(4));
			hashmap.put(rs.getInt(1),book);
			
		}
		qr.setHashmap(hashmap);
		
	    sql="SELECT count(*) FROM book";
	    ps=conn.prepareStatement(sql);
	    rs=ps.executeQuery();
	    if(rs.next()){
	    	qr.setTotalrecord(rs.getInt(1));
	    }
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return qr;
	   
   }
}
