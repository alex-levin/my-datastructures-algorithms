package sorting;

import java.util.Arrays;

/*
 	[2, 5, 8, 6, 3, 7, 4, 1]
 	[2, 5, 8, 6] [3, 7, 4, 1]
 	[2, 5] [8, 6]
 	[2] [5]
 	[2, 5]
 	[8] [6]
 	[6, 8]
 	[2, 5, 6, 8]
 	[3, 7] [4, 1]
 	[3] [7]
 	[3, 7]
 	[4] [1]
 	[1, 4]
 	[1, 3, 4, 7]
 	[1, 2, 3, 4, 5, 6, 7, 8]
 	
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 0, 8) 	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 0, 4) 	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 0, 2) 	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 0, 1) 	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 0, 0)	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 1, 1)	// (2)
 	
 	merge([2, 5, 8, 6, 3, 7, 4, 1], 0, 0, 1)	// (3)
 	p=0,q=0,r=1
 	merging [p,q] and [q+1,r]
 	merging two arrays with indexes [0,0] and [1,1] or
 	merging two arrays with single elements[2] and [5]
 	
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 2, 3)	// (2)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 2, 2)	// (1)
 	
 	merge([2, 5, 8, 6, 3, 7, 4, 1], 2, 2, 3)	// (3)
 	merging two arrays with indexes [2,2] and [3,3] or
 	merging two arrays with single elements[8] and [6]
 	
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 3, 4)	// (2)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 3, 3)	// (1)
 	mergeSort([2, 5, 8, 6, 3, 7, 4, 1], 4, 4)	// (2)
 	
 	merge([2, 5, 6, 8, 3, 7, 4, 1], 0, 1, 3)	// (3)
 	merging two arrays with indexes [0,1] and [2,3] or
 	merging two arrays with elements[2, 5] and [6, 8]
 	
 */

public class MergeSortCormen {
	
	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	private static void mergeSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			// Sorting left side
			mergeSort(arr, p, q);		// (1)
			// Sorting right side
			mergeSort(arr, q + 1, r);	// (2)
			// Merging left and right side that are sorted
			merge(arr, p, q, r);		// (3)
		}
	}
	
	private static void merge(int[] arr, int p, int q, int r) {
		int n1 = q + 1 - p;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		for(int i = 0; i < n1; i++) {
			left[i] = arr[p + i];
		}
		for(int j = 0; j < n2; j++) {
			right[j] = arr[q + 1 + j];
		}
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i = i + 1;
			}
			else {
				arr[k] = right[j];
				j = j + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 8, 6, 3, 7, 4, 1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}	
}
