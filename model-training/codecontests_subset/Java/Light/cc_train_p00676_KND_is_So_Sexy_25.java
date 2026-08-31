import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static final double EPS = 1e-10;
	
	public static final double heron(double a, double b, double c){
		double s = (a + b + c) / 2;
		
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()){
			final int a = sc.nextInt();
			final int l = sc.nextInt();
			final int x = sc.nextInt();
			
			final double a_harf = a / 2.0;
			double area = Math.sin(Math.acos(a_harf / l)) * l * a_harf;
			//System.out.println(area);
			
			final double max_len = l + x;
			double hi = (l + x) / 2.0 - EPS;
			double low = EPS;
			while(hi - low > EPS){
				final double upper = (hi * 2 + low) / 3;
				final double lower = (hi + low * 2) / 3;
				//System.out.println(upper + " " + lower);
				
				final double upper_value = heron(l, upper, max_len - upper);
				final double lower_value = heron(l, lower, max_len - lower);
				
				//System.out.println(upper_value + " " + lower_value);
				
				if(Double.isNaN(lower_value) || upper_value > lower_value){
					low = lower;
				}else{
					hi = upper;
				}
			}
			
			final double value = (low + hi) / 2;
			area += heron(l, value, max_len - value) * 2;
			
			System.out.printf("%.10f\n", area);
		}
	}

}