package com.algorithms.chapter01.exercise03;

import java.util.Stack;

public class Parentheses {
	
	public static void main(String[] args) {
		
		String str = "[()]{}{[()()][]}";
		
		boolean flag = isMatch(str);
		
		System.out.println(flag);
	}

	private static boolean isMatch(String str) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String s = String.valueOf(ch);
			if(s.equals("[") || s.equals("(") || s.equals("{")) {
				stack.push(s);
			} else if(s.equals("]") || s.equals(")") || s.equals("}")) {
				if(stack.size() == 0) {
					return false;
				}
				stack.pop();
			}
		}
		if(stack.size() == 0) {
			return true;
		}
		return false;
	}
	
}
