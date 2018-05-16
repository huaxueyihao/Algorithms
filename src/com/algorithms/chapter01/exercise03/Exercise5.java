package com.algorithms.chapter01.exercise03;

import java.util.Iterator;
import java.util.Stack;

import com.algorithms.booklib.Std.StdOut;
import com.algorithms.chapter01.section03.MyStack;

/**
 * 打印数字的二进制数
 * @author amao
 *
 */
public class Exercise5 {
	
	public static void main(String[] args) {
		
		printBinary(50);
		
	}

	private static void printBinary(int i) {
		MyStack<Integer> stack = new MyStack<Integer>();
		
		while(i > 0) {
			stack.push(i%2);
			i = i / 2;
		}
		
		Iterator<Integer> it = stack.iterator();
		
		while(it.hasNext()) {
			StdOut.print(it.next());
		}
	}
	
}
