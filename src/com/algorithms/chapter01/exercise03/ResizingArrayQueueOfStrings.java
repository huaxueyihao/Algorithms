package com.algorithms.chapter01.exercise03;

import com.algorithms.booklib.Std.StdOut;

public class ResizingArrayQueueOfStrings {

	private String[] a;
	private int N;

	public ResizingArrayQueueOfStrings(int cap) {
		a = new String[cap];
	}

	public void enqueue(String str) {
		if (N == a.length) {
			resizing(a.length * 2);
		}

		a[N++] = str;
	}

	public String dequeue() {
		String str = a[0];
		for (int i = 0; i < N-1; i++) {
			a[i] = a[i + 1];
		}
		if (N > 0) {
			a[N - 1] = null;
		}
		N--;
		if(N < a.length/4)
			resizing(a.length/2);
		return str;
	}

	private void resizing(int max) {
		String[] arr = new String[max];
		for (int i = 0; i < N; i++) {
			arr[i] = a[i];
		}
		a = arr;
	}

	public static void main(String[] args) {
		
		ResizingArrayQueueOfStrings arr = new ResizingArrayQueueOfStrings(2);
		
		arr.enqueue("a");
		arr.enqueue("b");
		arr.enqueue("c");
		arr.enqueue("d");
		
		StdOut.println(arr.dequeue());
		StdOut.println(arr.dequeue());
		StdOut.println(arr.dequeue());
		StdOut.println(arr.dequeue());

	    StdOut.println(arr.N);
	}
}
