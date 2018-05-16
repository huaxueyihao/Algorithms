package com.algorithms.chapter01.section03;

import com.algorithms.booklib.Std.StdOut;

public class FixedCapacityStackOfStrings {
	
	private String[] str;
	
	private int size;
	
	public FixedCapacityStackOfStrings(int cap){
		str = new String[cap];
		size  = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(String item) {
		str[size++] = item;
	}
	
	public String pop() {
		return str[--size];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		
		return size == str.length;
	}
	public static void main(String[] args) {
		
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
	
		stack.push("a");
		stack.push("b");
		stack.push("b");
		stack.push("b");
		StdOut.println(stack.isFull());
		
	}
	
	
}
