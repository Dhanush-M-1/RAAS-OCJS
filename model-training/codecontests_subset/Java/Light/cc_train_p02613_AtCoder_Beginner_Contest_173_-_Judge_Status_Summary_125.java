
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (s.equals("AC")) {
				ac++;
			}
			if (s.equals("WA")) {
				wa++;
			}
			if (s.equals("TLE")) {
				tle++;
			}
			if (s.equals("RE")) {
				re++;
			}

		}

		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);

	}
}
