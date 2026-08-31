/*

*/

import java.util.Scanner;

public class Task379A {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] candle = new int[b];
		candle[0] = (a-1) + (b-1);
		for (int i = 1; i < candle.length; i++) {
			candle[i] = candle[i-1] - 1;
		}
		int counter = 0;
		boolean flag = true;
		while (flag) {
			for (int i = 0; i < candle.length; i++) {
				candle[i] -= (b-1);
				if (candle[i] < 0) {
					System.out.println(counter);
					flag = false;
					break;
				} else {
					counter++;
				}
			}
		}
	}
}
