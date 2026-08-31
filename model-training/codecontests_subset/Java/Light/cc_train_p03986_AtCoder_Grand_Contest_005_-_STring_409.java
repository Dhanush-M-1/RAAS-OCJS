import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String x = sc.next();
		int n = x.length();
		int countS = 0;
		int pairCount = 0;

		for (int i=0; i<n; i++) {
			if (x.charAt(i)=='T') {
				if (countS > 0) {
					countS--;
					pairCount++;
				}
			} else if (x.charAt(i)=='S') {
				countS++;
			}
		}

		n = n - pairCount*2;

		sc.close();

		System.out.println(n);
	}
}
