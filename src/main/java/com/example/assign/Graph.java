package com.example.assign;

import java.util.ArrayList;

public class Graph {

	ArrayList<ListNode> headids;
	
	public Graph(){
		headids = new ArrayList<ListNode>();
	}
	
	public void addNode(int src, int dest){
		
		int i=0;
		for( i=0;i<headids.size();i++){
			  if(headids.get(i).getData()==src)
				  break;
		  }
		  
		  if(i==headids.size()){
			  ListNode l = new ListNode(src);
			    headids.add(l);
			    ListNode r = new ListNode(dest);
			    l.setNext(r);l.getNext().setNext(null);
		  }else{
			  
				ListNode curr = headids.get(i);
				while(curr.getNext()!=null)
			      {        
			        curr = curr.getNext();
			      }
			      curr.setNext(new ListNode(dest));curr.getNext().setNext(null);
		  }
		
	}
	
	public void printGraph()
	  {

		for(int i=0;i<headids.size();i++)
	    {
	      ListNode curr = headids.get(i);
	      while(curr!=null)
	      {
	        System.out.print(curr.getData()+"->");
	        
	        if(curr.getNext()==null)
	        {
	          curr=null;continue;
	        }
	        
	        curr=curr.getNext();
	        
	      }
	      System.out.print("\n");
	    }
	   
	  }
	
}
