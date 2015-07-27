package com.example.assign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ForkJoinPool;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AdjacencyListGraph;

public class Scheduler {

	static Graph graph;
	static AdjacencyListGraph graph2;
	/*public Scheduler(Graph graph)
	{
		this.graph=graph;
	}*/
	
	public static String runForkJoin(ArrayList<Integer> ids,int parallel){
		ForkJoinPool forkJoinPool = new ForkJoinPool(parallel);
    	JobTask myRecursiveTask = new JobTask(ids);
    	return forkJoinPool.invoke(myRecursiveTask);
	}
	public static void runFirst(){
		
		ArrayList<Integer> ids  = new ArrayList<Integer>();
		ids.add(graph.headids.get(0).getNext().getData());
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(1);
    	JobTask myRecursiveTask = new JobTask(ids);
    	 
    	String mergedResult = forkJoinPool.invoke(myRecursiveTask);
    	System.out.println(mergedResult);
	}
	
	public static void runGraph2() throws JsonParseException, JsonMappingException, IOException{
		
		graph2 = ParseJSON.getObjects();
		
		//runfirst
		Iterator<? extends Node> nodes = graph2.getNodeIterator();
		ArrayList<Integer> oneid  = new ArrayList<Integer>();
		oneid.add(Integer.parseInt(nodes.next().getId()));
		
		String mergedResult = runForkJoin(oneid,1); 
		System.out.println(mergedResult);
		
    	HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
		
		while(nodes.hasNext()){
			ArrayList<Integer> ids  = new ArrayList<Integer>();
			Node node = nodes.next();
			
			for(org.graphstream.graph.Edge ed:node.getEachEdge()){
				int id = Integer.parseInt(ed.getTargetNode().getId());
				
				if(!visited.containsKey(id)){
					ids.add(id);
					visited.put(id, 0);
				}
				else {
					System.out.println("Running same job again");
		 			//Log.warn();
		 			//System.exit(1);
					continue;
				} 	
	       }
			
			// 	current system has only 4 cpu core 
			String mergedResult2 = runForkJoin(ids, 4);
	    	System.out.println(mergedResult2);
		}
		
	}
	
	/*public static void runGraph() throws JsonParseException, JsonMappingException, IOException{
		
		graph = ParseJSON.getObjects();
		
		runFirst();
		HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
		
		for( int i=1;i<graph.headids.size();i++){
			
			ArrayList<Integer> ids = new ArrayList<Integer>();
			ListNode node = graph.headids.get(i);
			if(node.getNext().getNext()==null){
				
				int id = node.getNext().getData();
				if(!visited.containsKey(id)){
					ids.add(id);
					visited.put(id, 0);
				}
				else {
					System.out.println("Running same job again");
		 			//Log.warn();
		 			//System.exit(1);
					continue;
				}
					
				
			}else{
				
				ListNode curr = node.getNext();
				while(curr.getNext()!=null){
					int id = curr.getData();
					
					if(!visited.containsKey(id)){
						ids.add(id);
						visited.put(id, 0);
					}
					else {
						System.out.println("Running same job again");
			 			//Log.warn();
			 			//System.exit(1);
						continue;
					}
					
					curr=curr.getNext();
				}
				ids.add(curr.getData());
			}
			
			// current system has only 4 cpu core 
			
	    	ForkJoinPool forkJoinPool = new ForkJoinPool(4);
	    	JobTask myRecursiveTask = new JobTask(ids);
	    	 
	    	String mergedResult = forkJoinPool.invoke(myRecursiveTask);
	    	System.out.println(mergedResult);
		}
	}*/
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
		
		//runGraph();
		runGraph2();
	}
}
