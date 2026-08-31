

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cf1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int l = 0; l < test; l++) {
			long n;
			n = sc.nextLong();
			long x = 0, y = 0;
			while(n % 2 == 0) {
				n /= 2;
				x += 1;
			}
			while(n % 3 == 0) {
				n /= 3;
				y += 1;
			}
			if(n == 1 && x <= y) {
				System.out.println(2 * y - x);
			} else {
				System.out.println("-1");
			}
		}
	}
}
