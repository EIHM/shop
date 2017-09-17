package com.tm.serviceimpl;

import java.util.HashMap;

import com.tm.daoimpl.BookDaoimpl;
import com.tm.domain.PageBean;
import com.tm.domain.QueryInfo;
import com.tm.domain.QueryResult;

public class FenyeServiceImpl {

	
	public PageBean getPageBean(QueryInfo qi){
		
		BookDaoimpl bl=new BookDaoimpl();
		QueryResult qr=bl.pageQuery(qi.getStartIndex(),qi.getPagesize());
		
		PageBean pb=new PageBean();
		pb.setHashmap(qr.getHashmap());   //页面数据
		pb.setTotalrecord(qr.getTotalrecord());  //总记录数
		
		pb.setPagesize(qi.getPagesize());
		
		pb.setCurrentpage(qi.getCurrentpage());
		
		
		return pb;
		
	}

}
