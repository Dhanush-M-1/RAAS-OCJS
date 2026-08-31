
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			if (n == 1)
				System.out.println(0);
			else {
				int c2 = 0, c3 = 0;
				while (n % 2 == 0) {
					c2++;
					n = n / 2;
				}
				while (n % 3 == 0) {
					c3++;
					n = n / 3;
				}
				if (n != 1)
					System.out.println(-1);
				else {
					if (c2 == c3)
						System.out.println(c2);
					else if (c3 == 0 || c2 > c3)
						System.out.println(-1);
					else if (c2 == 0)
						System.out.println(c3 * 2);
					else
						System.out.println(c2 + 2 * (c3 - c2));
				}
			}
			t--;
		}
	}

}
