package com.tm.domain;

public class QueryInfo {

	private int currentpage=1;  //������ҳ��
	private int pagesize=5;    //Ҫ�ֶ���ҳ
	private int startIndex;
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartIndex() {
		
		this.startIndex=(this.currentpage-1)*this.pagesize;
		
		return startIndex;
	}
	
	
	
	

}
