package practice.algorithms.sorting;

import java.util.Scanner;

public class QuicksortInPlace {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N=in.nextInt();
        
        int[] input = new int[N];
    	for (int i=0; i<N; i++) {
    		input[i] = in.nextInt();
    	}
    	in.close();
    	
    	sort(input, 0, input.length-1);
    }


    private static void sort(int[] arr, int start, int end) {
    	if (start>=end) return;
    	int pivotIndex = partition(arr, start, end);

    	printArray(arr);
    	sort(arr, start, pivotIndex-1);
    	sort(arr, pivotIndex+1, end);
    }
    
    private static int partition(int[] arr, int start, int end) {
    	int indLess = start-1;
    	for (int i=start; i<end; i++) {
    		if (arr[i]<=arr[end]) swap(arr, ++indLess, i);
    	}
    	swap(arr, ++indLess, end);
    	return indLess;
    }
    
    private static void swap(int[] arr, int i1, int i2) {
    	if (i1 == i2) return;
    	int tmp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = tmp;
    }
    
    private static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
    	for (int elem : arr) {
    		if (sb.length()>0) sb.append(" ");
    		sb.append(elem);
    	}
		System.out.println(sb.toString());
    }
}
