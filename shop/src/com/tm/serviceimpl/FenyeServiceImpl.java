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
		pb.setHashmap(qr.getHashmap());   //ҳ������
		pb.setTotalrecord(qr.getTotalrecord());  //�ܼ�¼��
		
		pb.setPagesize(qi.getPagesize());
		
		pb.setCurrentpage(qi.getCurrentpage());
		
		
		return pb;
		
	}

}
