package practice.daysOfStatistics;

import java.util.Scanner;

public class GeometricDistributionI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double defectProba = (double)in.nextInt()/(double)in.nextInt();
		int firstDefect = in.nextInt();
		in.close();
		
		double fourndDefProba = 0;
		for (int i=1; i<=firstDefect; i++) {
			fourndDefProba += Math.pow(1-defectProba, i-1) * defectProba;
		}
		System.out.format("%.3f", fourndDefProba);
	}
}
