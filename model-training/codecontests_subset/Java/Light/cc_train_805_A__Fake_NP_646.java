//package codeforces;

import java.util.Scanner;

public class Divisors805 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int min = s.nextInt();
		int max = s.nextInt();
		if (max != min){
			System.out.println(2);
		}
		else{
			System.out.println(max);
		}
	}
}
