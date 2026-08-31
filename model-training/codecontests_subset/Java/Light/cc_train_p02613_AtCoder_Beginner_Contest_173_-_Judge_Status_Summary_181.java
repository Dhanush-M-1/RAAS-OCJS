import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for (int i = 0; i < n; i++) {
			String r = sc.next();
			if ("AC".equals(r)) {
				ac = ac+1;
			} else if ("WA".equals(r)) {
				wa = wa+1;
			} else if ("TLE".equals(r)) {
				tle = tle+1;
			} else if ("RE".equals(r)) {
				re = re+1;
			}
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
		sc.close();
	}
}