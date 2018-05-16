package com.algorithms.chapter01.section03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item>  {
	
	private Item[] arr;
	private int N;
	
	public FixedCapacityStack(int cap) {
		arr = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void push(Item item) {
		if(N == arr.length) {
			resize(2 * arr.length );
		}
		arr[N++] = item;
	}
	
	public Item pop() {
		Item item = arr[--N];
		arr[N] = null;//防止对象游离
		if(N > 0 && N == arr.length/4) resize(arr.length/2);
		return item;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i = N;
		
		@Override
		public boolean hasNext() {

			return i > 0;
		}

		@Override
		public Item next() {
			if(i<0) throw new NoSuchElementException();
			return arr[--i];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	
}
