package com.example.assign;

public class Edge {

	  int src ;
	  int dst;
	  
	  int wt;
	  
	  public Edge(int src,int dst,int wt)
	  {
	    this.src= src;
	    this.dst=dst;
	    this.wt=wt;
	    
	  }
	  public Edge(int src,int dst)
	  {
	    this.src= src;
	    this.dst=dst;
	    this.wt=-1;
	  }
	  public int getSrc(){
		  return src;
	  }
	  public int getDest(){
		  return dst;
	  }
	  public void setDest(int dst){
		  this.dst=dst;
	  }
	  public void setSrc(int src){
		  this.src=src;
	  }
}
