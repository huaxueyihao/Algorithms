package com.algorithms.chapter01.section03;

import com.algorithms.booklib.Std.StdOut;

public class MainClass {

	public static void main(String[] args) {
		
//		Stack<String> stack = new Stack<>();
		
//		stack.push("aa");
		
//		Stack<String> stack = new Stack<>();
		MyStack<String> myStack = new MyStack<String>();
		
		myStack.push("aa");
		myStack.push("bb");
		myStack.push("cc");
		
		myStack.pop();
		
		
		StdOut.println(myStack.size());
		
	}

}
