package com.example.assign;

public class ListNode {

	/**
	 * @param args
	 */
	
	public int data;
	public ListNode next;
	
	public ListNode(int data){
		this.data=data;
		this.next=null;
	}
	public void setData(int data){
		
		this.data=data;
	}
	public int getData(){
		
		return data;
	}
	public void setNext(ListNode next){
		
		this.next= next;
	}
	public ListNode getNext(){
		return this.next;
	}
	
	int ListLength(ListNode headNode){
		
		int length =0;
		ListNode current = headNode;
		while(current!=null){
			length++;
			current=current.next;
		}
		return length;		
	}
}
