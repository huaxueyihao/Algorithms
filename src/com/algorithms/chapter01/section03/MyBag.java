package com.algorithms.chapter01.section03;

import java.util.Iterator;

/**
 * 先进后出
 * @author amao
 *
 * @param <Item>
 */
public class MyBag<Item> {
	
	private Node first;
	private int N;
	
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	
	public void add(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		N++;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current  = first;
		
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	
}
