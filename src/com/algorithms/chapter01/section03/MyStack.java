package com.algorithms.chapter01.section03;

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
	
	
	
	
}
