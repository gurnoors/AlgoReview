package com.gurnoors.dsalgo;

import java.util.Arrays;

public class ArraysSort {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 8, 1, 3, 5, 8, 0, 0 };
		// selectionSort(arr);
//		selectionSortRecursive(arr, 0);
		arr = mergeSort(arr);
		for (int el : arr) {
			System.out.println(el);
		}
	}

	public static void selectionSort(int[] unsorted) {
		for (int i = 0; i < unsorted.length; i++) {
			// find min
			int minPos = i;
			for (int j = i + 1; j < unsorted.length; j++) {
				if (unsorted[j] < unsorted[minPos]) {
					minPos = j;
				}
			}
			// swap
			int temp = unsorted[i];
			unsorted[i] = unsorted[minPos];
			unsorted[minPos] = temp;
		}
	}

	public static void selectionSortRecursive(int[] unsorted, int startPos) {
		if (startPos < unsorted.length) {
			int minPos = startPos;
			for (int j = startPos + 1; j < unsorted.length; j++) {
				if (unsorted[j] < unsorted[minPos]) {
					minPos = j;
				}
			}
			// swap
			int temp = unsorted[startPos];
			unsorted[startPos] = unsorted[minPos];
			unsorted[minPos] = temp;

			// recurse
			selectionSortRecursive(unsorted, startPos + 1);
		}
	}

	public static int[] mergeSort(int[] arr) {
		if (arr.length == 1)
			return arr;

		int mid = arr.length / 2;

		// check ending condn and mid >1
		int[] half1 = Arrays.copyOfRange(arr, 0, mid);
		half1 = mergeSort(half1);
		int[] half2 = Arrays.copyOfRange(arr, mid, arr.length);
		half2 = mergeSort(half2);

		arr = merge(half1, half2);
		return arr;
	}

	private static int[] merge(int[] half1, int[] half2) {
		int[] merged = new int[half1.length + half2.length];
		int j = 0, k = 0;
		for (int i = 0; i < merged.length; i++) {
			if (j == half1.length) {
				// copy half2 from k to len-1
				appendFrom(merged, i, half2, k);
			} else if (k == half2.length) {
				appendFrom(merged, i, half1, j);
			} else {
				// merge
				if (half1[j] < half2[k]) {
					merged[i] = half1[j];
					j++;
				} else {
					merged[i] = half2[k];
					k++;
				}
			}
		}
		return merged;
	}

	/**
	 * copy half2 from k till the end. Then append into merged starting from
	 * index i
	 * 
	 * @param merged
	 * @param startI
	 * @param half2
	 * @param startK
	 */
	private static void appendFrom(int[] merged, int startI, int[] half2, int startK) {
		for (int i = startI; i < merged.length; i++) {
			merged[i] = half2[startK];
			startK++;
		}
	}

}
