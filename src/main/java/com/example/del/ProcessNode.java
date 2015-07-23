package com.example.del;

import com.example.assign.Job;

public class ProcessNode {

	/**
	 * @param args
	 */
	
	Job job;
	ProcessNode next;
	
	public ProcessNode(){
		
	}
	public ProcessNode(Job job){
		this.job=job;
		this.next=null;
	}
	public void setData(Job job){
		
		this.job=job;
	}
	public Job getData(){
		
		return job;
	}
	public void setNext(ProcessNode next){
		
		this.next= next;
	}
	public ProcessNode getNext(){
		return this.next;
	}
	
	int ListLength(ProcessNode headNode){
		
		int length =0;
		ProcessNode current = headNode;
		while(current!=null){
			length++;
			current=current.next;
		}
		return length;		
	}
	
}
