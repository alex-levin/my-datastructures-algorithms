package sorting;

import java.util.Arrays;

public class MergeSortKoffman {

	public static void mergeSort(int[] arr) {
		if(arr.length > 1) {
			// Split the array into halves
			int halfSize = arr.length / 2;
			int[] left = new int[halfSize];
			int[] right = new int[arr.length - halfSize];
			// Populate the left half
			for(int i = 0; i < halfSize; i++) {
				left[i] = arr[i];
			}
			// Populate the right half
			for(int i = halfSize; i < arr.length; i++) {
				right[i - halfSize] = arr[i];
			}
			// Sort the halves.
			mergeSort(left);
			mergeSort(right);
			// Merge the halves.
			 merge(arr, left, right);
		}
	}
	
	private static void merge(int[] arr, int[] left, int[] right) {
		// Left index
		int i = 0;
		// Right index
		int j = 0;
		// Arr index
		int k = 0;
		// While there is data in both left and right
		while(i < left.length && j < right.length) {
			// Find the smaller and insert it into the output sequence
			if(left[i] < right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			}
			else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		// Copy remaining input from left sequence into the output
		while(i < left.length) {
			arr[k] = left[i];
			k++;
			i++;			
		}
		// Copy remaining input from right sequence into output.
		while(j < right.length) {
			arr[k] = right[j];
			k++;
			j++;			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 8, 6, 3, 7, 4, 9, 1};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}	
}

/*
[2, 5, 8, 6] [3, 7, 4, 9, 1]
[2, 5] [8, 6]
[2] [5]
[2, 5]
[8] [6]
[6, 8]
[2, 5, 6, 8]
[3, 7] [4, 9, 1]
[3] [7]
[3, 7]
[4] [9, 1]
[9] [1]
[1, 9]
[1, 4, 9]
[1, 3, 4, 7, 9]
[1, 2, 3, 4, 5, 6, 7, 8, 9] 
 */
