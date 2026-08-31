import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int c[] = new int[4];
		Arrays.fill(c, 0);

		for (int i = 0; i < n; i++) {
			String s = sc.next();

			if ("AC".equals(s)) {
				c[0]++;
			} else if ("WA".equals(s)) {
				c[1]++;
			} else if ("TLE".equals(s)) {
				c[2]++;
			} else {
				c[3]++;
			}
		}

		System.out.println("AC x  " + c[0]);
		System.out.println("WA x  " + c[1]);
		System.out.println("TLE x  " + c[2]);
		System.out.println("RE x  " + c[3]);

		sc.close();
	}

}
