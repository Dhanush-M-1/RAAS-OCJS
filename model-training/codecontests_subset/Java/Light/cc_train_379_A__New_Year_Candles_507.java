//package GoodBye_2013;

import java.util.Scanner;

public class NewYearCandles {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		int sum = a;
		a = a - b + 1;
		while(a > 0) {
			a = (a - b) + 1;
			sum++;
		}
		
		System.out.println(sum);
		
		s.close();		
		
	}

}
