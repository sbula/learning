package practice.algorithms.sorting;

import java.util.Scanner;

public class RunningTimeQuicksort {
	private static long quickSwap = 0;
	private static long insertSwap = 0;
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N=in.nextInt();

        int[] inQuick = new int[N];
        int[] inInsert = new int[N];
    	for (int i=0; i<N; i++) {
    		inQuick[i] = in.nextInt();
    		inInsert[i] = inQuick[i];
    	}
    	in.close();
    	
    	quickSort(inQuick, 0, inQuick.length-1);
    	insertionSortPart2(inInsert);
    	
    	System.out.println((insertSwap - quickSwap));
    }


    private static void quickSort(int[] arr, int start, int end) {
    	if (start>=end) return;
    	int pivotIndex = partition(arr, start, end);

    	quickSort(arr, start, pivotIndex-1);
    	quickSort(arr, pivotIndex+1, end);
    }
    
    private static int partition(int[] arr, int start, int end) {
    	int indLess = start-1;
    	for (int i=start; i<end; i++) {
    		if (arr[i]<=arr[end]) {swap(arr, ++indLess, i); quickSwap++;}
    	}
    	swap(arr, ++indLess, end); quickSwap++;
    	return indLess;
    }
    
    private static void swap(int[] arr, int i1, int i2) {
    	if (i1 == i2) return;
    	int tmp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = tmp;
    }

    public static void insertionSortPart2(int[] ar) {
    	for (int i=1; i<ar.length; i++) {
    		int ind = i;
    		int ins = ar[ind--];
            while (ind>=0 && ar[ind]>ins) {
            	ar[ind+1] = ar[ind--]; 
                insertSwap++;
            }
            ar[ind+1] = ins;
    	}
    }  
}
