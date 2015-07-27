package com.example.assign;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.graphstream.graph.implementations.AdjacencyListGraph;


/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import com.example.test.TestJSON;

public class ParseJSON {

	//private static final Logger LOG = LoggerFactory.getLogger(ParseJSON.class);
	
	static List<Job> objects ;
	static HashMap<String,String> map ;
	static ArrayList<Edge> edges;
	
	//public static HashMap<String,ArrayList<Job>> getObjects() throws JsonParseException, JsonMappingException, IOException{
	//public static Graph getObjects() throws JsonParseException, JsonMappingException, IOException {
	public static AdjacencyListGraph getObjects() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	
	File file = new File(TestJSON.class.getClassLoader().getResource("test.json").getFile());
	 
	 //List<Job> 
	 objects = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(
             List.class, Job.class));
	 
	 	map = new HashMap<String, String>();
	 	edges = new ArrayList<Edge>();
	 	
	 	for(Job job:objects){
	 	
	 		if(!map.containsKey(job.getId())){
	 			map.put(job.getId(), job.getCommand());
	 		}
	 		else{
	 			System.out.println("multiple command for single id , invalid data");
	 		}
	 		
	 		if(!job.getParent().equals("null")){
	 			int parent = Integer.valueOf(job.getParent());
	 			int child = Integer.valueOf(job.getId());
		 		edges.add(new Edge(parent,child));
	 		}else{
	 			edges.add(new Edge(-1,Integer.valueOf(job.getId())));
	 		}
	 			
	 		/*if(!map.containsKey(job.getParent())){
	 			ArrayList<Job> ar = new ArrayList<Job>();ar.add(job);
	 			map.put(job.getParent(), ar);
	 		}else{
	 			ArrayList<Job> ar = map.get(job.getParent());
	 			ar.add(job);
	 			map.put(job.getParent(), ar);
	 		}*/
	 	}
		
	 	/*Graph g = new Graph();
	 	for(Edge e:edges){
	 		g.addNode(e.getSrc(), e.getDest());
	 	}*/
	 	
	 	AdjacencyListGraph graph = new AdjacencyListGraph("scheduler");
		for(Map.Entry<String, String> entry:map.entrySet()){
			graph.addNode(entry.getKey());
		}
		graph.addNode("-1");
		for(Edge e:edges){
			String src = String.valueOf(e.getSrc());
			String dst = String.valueOf(e.getDest());
			graph.addEdge(src.concat(dst),src,dst);
		}
		
		/*Graph g = new Graph();
	 	if(g.isCircle(map.size(), edges)){
	 		System.out.println("Detected cycle in the process graph .. Exiting");
	 		//Log.warn()
	 		System.exit(1);
	 	}else{
	 		for(Edge e:edges){
		 		g.addNode(e.getSrc(), e.getDest());
		 	}
	 	}*/
	 	
		//g.printGraph();
	 	
	 	//return g;
		return graph;
	}
}
