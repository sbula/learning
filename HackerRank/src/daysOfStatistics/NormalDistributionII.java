package daysOfStatistics;

import java.util.Scanner;

public class NormalDistributionII {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double mean = in.nextDouble();
		double stdDev = in.nextDouble();
		double higherThan = in.nextDouble();
		double gradeBoarder = in.nextDouble();
		in.close();
		
		System.out.format("%.2f%n", 100* (1 - cumulative(mean, stdDev, higherThan)));
		double Proba60 = cumulative(mean, stdDev, gradeBoarder);
		System.out.format("%.2f%n", 100* (1 - Proba60));
		System.out.format("%.2f%n", 100* Proba60);
	}
	
	private static double cumulative(double mean, double stdDev, double x) {
		return (1 + erf((x-mean)/(stdDev * Math.sqrt(2d)))) / 2d;
	}

	// found @ http://introcs.cs.princeton.edu/java/21function/ErrorFunction.java.html
	// fractional error in math formula less than 1.2 * 10 ^ -7.
    // although subject to catastrophic cancellation when z in very close to 0
    // from Chebyshev fitting formula for erf(z) from Numerical Recipes, 6.2
    private static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }
}
