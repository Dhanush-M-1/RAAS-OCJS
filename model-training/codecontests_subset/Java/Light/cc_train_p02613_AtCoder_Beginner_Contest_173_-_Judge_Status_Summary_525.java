import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if ("AC".equals(s)) {
				ac++;
			} else if ("WA".equals(s)) {
				wa++;
			} else if ("TLE".equals(s)) {
				tle++;
			} else if ("RE".equals(s)) {
				re++;
			}
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}