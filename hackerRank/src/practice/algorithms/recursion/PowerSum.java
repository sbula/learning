package practice.algorithms.recursion;

import java.util.Scanner;

public class PowerSum {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int X = in.nextInt();
    	int N = in.nextInt();
    	in.close();
    	
    	int n = (int)Math.floor(Math.pow((double)X, 1.0/(double)N));
    	int[] powArray = new int[n];
    	for (int i=0; i<n; i++) {
    		powArray[i] = (int)Math.pow(i+1, N);
    	}
    	
    	int cnt = countSums(X, powArray, 0);
    	System.out.println(cnt);
    }
    
    private static int countSums(int sum, int[] powArray, int index) {
		if (sum == 0) return 1;
		if (sum<0 || index >= powArray.length) return 0;
		
		int counter = 0;
		counter += countSums(sum, powArray, index+1);
		counter += countSums(sum-powArray[index], powArray, index+1);
		return counter;
	}
}
