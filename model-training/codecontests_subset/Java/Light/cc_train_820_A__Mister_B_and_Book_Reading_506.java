

import java.util.Scanner;

public class A820 {

	static Scanner sc = new Scanner(System.in);
	static int c, v0, v1, a, l, days;

	public static void main(String[] args) {
		c = sc.nextInt();
		v0 = sc.nextInt();
		v1 = sc.nextInt();
		a = sc.nextInt();
		l = sc.nextInt();
		days = 1;
		c -= v0;
		while (c > 0) {
			c = c - (Math.min(v1, v0 + days * a) - l);
			days++;
		}
		System.out.println(days);

	}

}
