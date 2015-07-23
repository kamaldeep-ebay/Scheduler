package com.example.del;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.example.assign.Job;

class Graph1
{
	//convert to ar list later
  ProcessNode[] heads;
  int headlen;
  int graphsize;
  
  public Graph1(int graphsize)
  {
    headlen=0;
    this.graphsize=graphsize;
    heads = new ProcessNode[graphsize];

    for(int i=0;i<graphsize;i++)
    {
      heads[i] = null;
    }
  }
   
  public void addNode(Job src, Job dest)
  {
	  int i=0;
	  for( i=0;i<headlen;i++){
		  if(heads[i]!=null && heads[i].getData().getId().equals(src.getId()))
			  break;
	  }
	  
	  if(i==headlen){
		  ProcessNode newhead = new ProcessNode(src); 
		  heads[headlen++] = newhead;
	      ProcessNode r = new ProcessNode(dest);
	      newhead.setNext(r);
	      newhead.getNext().setNext(null);
		  
	  }else{
		  
		  ProcessNode curr = heads[i];
	      while(curr.getNext()!=null)
	      {        
	        curr = curr.getNext();
	      }
	         curr.setNext(new ProcessNode(dest));curr.getNext().setNext(null);
	  }
	  
  }
  
  /*public void dfscorrect( int i)
  {
	  System.out.println(i);
	  visited[i]=1;
	  if(heads[i].getNext()!=null)
	  {
		  ProcessNode curr = heads[i].getNext();
		  while(curr!=null)
		  {
			  if(visited[curr.data]==0)
			  {
				  dfscorrect(curr.getData());
			  }
			  curr=curr.getNext();
		  }
	  }
	  else
		  return;
  }
  public void dfscorrectwrap()
  {
	  
	  for( int i=0;i<6;i++)
	  {
		  if(this.heads[i].data!=-1 && visited[heads[i].data]==0)
		  {
			  dfscorrect(heads[i].data);
		  }
			  
	  }
  }
  */
  
  public void printGraph()
  {
	  // max vertex since we made it taht way
    for(int i=0;i<headlen;i++)
    {
      ProcessNode curr = heads[i];
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

public class GraphListWrapper {

  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    // TODO Auto-generated method stub
   
	  //100 max. number of vertices 
	  // vertex   max vertex number
    Graph1 g = new Graph1(4); 
    
    /*g.addNode( 0, 1);
    g.addNode( 0, 4);
    g.addNode( 1, 3);
    g.addNode( 1, 2);
    g.addNode( 1, 4);
    g.addNode( 2, 3);
    g.addNode( 3, 4);
    g.addNode(5,4);
    */ 

    //    List<Job> input = ParseJSON.getObjects();
    //HashMap<String,ArrayList<Job>> map = ParseJSON.getObjects();
    // "1" ,job
    //  "2"  list<jobs>
    
    /*for(Map.Entry<String, ArrayList<Job>> entry:map.entrySet()){
    	
    	if(entry.getKey().equals("null")){
    		g.heads[0]= new ProcessNode(entry.getValue().get(0));g.headlen++;
    	}else{
    		
    			ArrayList<Job> ar = entry.getValue();
    			for( int i=0;i<ar.size();i++){
    				
    				//g.addNode(job, dest);
    			}
       	}
    }*/
    
    
    
    
    g.printGraph();
   
    //g.dfs(g.vertex);
    
   // g.dfscorrectwrap();  
    
  }

}
