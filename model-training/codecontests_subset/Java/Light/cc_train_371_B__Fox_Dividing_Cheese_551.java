/*

*/

import java.util.Scanner;
import java.util.Arrays;

public class TaskB {
	
	public static void divisorCount (int number, int[] digit) {
		int currNum = number;
		while (number % 2 == 0) {
			digit[1]++;
			number = number / 2;
		}
		while (number % 3 == 0) {
			digit[2]++;
			number = number / 3;
		}
		while (number % 5 == 0) {
			digit[3]++;
			number = number / 5;
		}
		digit[0] = (int)(currNum / (Math.pow(2, digit[1]) * Math.pow(3, digit[2]) * Math.pow(5, digit[3])));
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int counter;
		int[] digit1 = new int[4];
		int[] digit2 = new int[4];
		digit1[0] = 1;
		digit2[0] = 1;
		if (a == b) {
			counter = 0;
		} else {
			divisorCount(a, digit1);
			divisorCount(b, digit2);
			if (digit1[0] != digit2[0]) {	
				counter = -1;
			} else {
				counter = Math.abs(digit1[1] - digit2[1]) + Math.abs(digit1[2] - digit2[2]) + Math.abs(digit1[3] - digit2[3]); 
			}
		}
		System.out.println(counter);
	}
}
