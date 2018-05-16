package com.algorithms.chapter02.page76;

import java.util.Stack;

import com.algorithms.booklib.Std.StdIn;
import com.algorithms.booklib.Std.StdOut;

public class Evaluate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("(")) {

			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				Double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(s));
			}
			StdOut.println(vals.pop());
		}

	}
}
