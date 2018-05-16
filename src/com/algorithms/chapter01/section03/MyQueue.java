package com.algorithms.chapter01.section03;

import com.algorithms.booklib.Std.StdOut;

public class MyQueue<Item> {
	
	private Node first;//指向最早添加节点的链接
	
	private Node last;//指向最近缇娜家的节点的链接
	
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return  first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
		}else {
			oldLast.next = last;
		}
		N++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
	
	
	public static void main(String[] args) {
		
		MyQueue<String> myQueue = new MyQueue<String>();
		
		myQueue.enqueue("a");
		myQueue.enqueue("b");
		myQueue.enqueue("c");
		
		StdOut.println(myQueue.dequeue());
		StdOut.println(myQueue);
		
		
	}
	
}
