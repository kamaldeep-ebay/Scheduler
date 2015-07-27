package com.example.assign;


import java.util.ArrayList;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AdjacencyListGraph;
import org.graphstream.graph.implementations.AdjacencyListNode;
import org.graphstream.graph.implementations.SingleGraph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

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
	
	public boolean isCircle(int vertices,ArrayList<Edge> ar)
	  {
		int[] parents = new int[vertices];
		
		for(int i=0;i<vertices;i++)
		      parents[i] = -1;
		
	    for(int i=0;i<ar.size();i++)
	    {
	      int x = ar.get(i).src;
	      int y = ar.get(i).dst;

	      // reevalue this cond
	      if (x == y)
	        return true;

	      if(union(x, y,parents)==true)
	    	  return true;
	    }
	    
	    return false;
	  }
	  
	  // you cant jsut use a hashmap . how will you distinguish btwn 2 edges in a cycle and 2 who arent. 
	  public int find(int v,int[] parents)
	  {
	    if(parents[v]==-1)
	    {
	      return v;
	    }
	    return find(parents[v],parents);
	    
	  }
	  
	  public boolean union(int x,int y,int[] parents )
	  {
	    // you need to make one parent as child of another. 
	    int xset = find(x,parents);
	    int yset = find(y,parents);
	    
	    if(xset==yset)
	    	return true;
	    else {
	    	parents[xset] = yset;
	    	return false;
	    }
	  }

	 public static void main(String[] args) {
		    // TODO Auto-generated method stub
		   
		 AdjacencyListGraph graph = new AdjacencyListGraph("first");
		   graph.addNode("A");
           graph.addNode("B");
           graph.addNode("C");graph.addNode("D");graph.addNode("E");
           graph.addEdge("AB", "A", "B");
           graph.addEdge("BC", "B", "C");
           graph.addEdge("CA", "C", "A");
           graph.addEdge("AD", "A", "D");graph.addEdge("DB", "D", "B");
           
           for (Node e :graph.getNodeSet()){
        	   StringBuffer strbuf = new StringBuffer();
        	   for(org.graphstream.graph.Edge ed:e.getEachEdge()){
        		   if(!ed.getTargetNode().toString().equals(e.toString()))
        		   strbuf.append(ed.getTargetNode().toString());
        	   }
        	   System.out.println(strbuf.toString());
           }
           //System.out.println(e.toString());
           //graph.display();
           
		/* UndirectedGraph<String, DefaultEdge> g =
		            new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

		        String v1 = "v1";
		        String v2 = "v2";
		        String v3 = "v3";
		        String v4 = "v4";

		        // add the vertices
		        g.addVertex(v1);
		        g.addVertex(v2);
		        g.addVertex(v3);
		        g.addVertex(v4);

		        // add edges to create a circuit
		        g.addEdge(v1, v2);
		        g.addEdge(v2, v3);g.addEdge(v2, v4);
		        g.addEdge(v3, v4);
		        g.addEdge(v4, v1);

		        System.out.println(g.toString());*/
		       		 
		 /* 	  Graph g = new Graph(); 
		    
		    g.addNode( 0, 1);
		    g.addNode( 0, 4);
		    g.addNode( 1, 3);
		    g.addNode( 1, 2);
		    g.addNode( 1, 4);
		    g.addNode( 2, 3);
		    g.addNode( 3, 4);
		    g.addNode(5,4);
		     
		    g.printGraph();
		  
		  Edge e1  = new Edge(0, 1);
		  Edge e2  = new Edge(1, 2);
		  Edge e3  = new Edge(2, 3);
		  Edge e4  = new Edge(3, 4);
		  ArrayList<Edge> ar = new ArrayList<Edge>();
		  ar.add(e1);ar.add(e2);ar.add(e3);ar.add(e4);
		  
		  System.out.println(g.isCircle(5, ar));*/
	  }
	  
}
