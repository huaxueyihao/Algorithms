package com.algorithms.chapter01;

import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {

		// int[] arr = getRandomArrayOfInt(9);
		int[] arr = { 13, 15, 32, 37, 49, 66, 67, 84, 93 };

		// System.out.println(Arrays.toString(arr));
		// Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		int rank = rank(84, arr);
		System.out.println(rank);

	}

	private static int[] getRandomArrayOfInt(int length) {
		Random random = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		return arr;
	}

	public static int rank(int key, int[] a) {
		// 数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			if (key > a[mid])
				lo = mid + 1;
			else if(key == a[mid])
				return mid;
		}
		return -1;
	}

}
