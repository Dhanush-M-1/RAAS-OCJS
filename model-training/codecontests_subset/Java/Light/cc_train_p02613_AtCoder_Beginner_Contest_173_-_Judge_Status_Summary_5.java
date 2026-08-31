import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ac = 0, wa = 0, tle = 0, re = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (s.equals("AC")) ac++;
			if (s.equals("WA")) wa++;
			if (s.equals("TLE")) tle++;
			if (s.equals("RE")) re++;
		}
		System.out.format("AC x %d\n", ac);
		System.out.format("WA x %d\n", wa);
		System.out.format("TLE x %d\n", tle);
		System.out.format("RE x %d\n", re);
	}

}

