package com.tm.domain;

import java.util.HashMap;
import java.util.List;

public class PageBean {

	private HashMap hashmap;
    private int totalrecord;
    private int pagesize;
    
    private int totalpage;
    
    private int currentpage;
   
    private int previouspage;
    private int nextpage;
    
    private int[] pagebar;
    
    
	public HashMap getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap hashmap) {
		this.hashmap = hashmap;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		if(this.totalrecord%this.pagesize==0){
			this.totalpage=this.totalrecord/this.pagesize;
		}else{
			this.totalpage=this.totalrecord/this.pagesize+1;
		}
		
		return totalpage;
	}
	
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
	
	public int getPreviouspage() {
		if(this.currentpage<=1){
			this.previouspage=1;
		}else{
			this.previouspage=this.currentpage-1;
		}
		
		
		return previouspage;
	}
	
	public int getNextpage() {
		if(this.currentpage>=totalpage){
			this.nextpage=totalpage;
		}else{
			this.nextpage=this.currentpage+1;
		}
		
		
		return nextpage;
	}
	
	public int[] getPagebar() {
		int pagebar[]=new int[this.totalpage];
		
		for(int i=1;i<=this.totalpage;i++){
			pagebar[i-1]=i;
		}
		return pagebar;
	}
	
    
    
    

}
