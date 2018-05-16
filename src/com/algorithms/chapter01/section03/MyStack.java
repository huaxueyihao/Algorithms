package com.algorithms.chapter01.section03;

import java.util.Iterator;

/**
 * 下压堆栈（链表实现）
 * @author amao
 *
 * @param <Item>
 */
public class MyStack<Item> {
	private Node first;
	
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		//向栈顶添加元素
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		//从栈顶添加元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek() {
		return first == null ? null : first.item;
	}
	
	public MyStack<Item> copy(MyStack<Item> stack){
		MyStack<Item> st = new MyStack<Item>();
		Iterator<Item> it = stack.iterator();
		while(it.hasNext()) {
			st.push(it.next());
		}
		return st;
	}
	
	public Iterator<Item> iterator() {
		return new HisIterator();
	}
	
	private class HisIterator implements Iterator<Item>{

		private Node current = first;
		
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
