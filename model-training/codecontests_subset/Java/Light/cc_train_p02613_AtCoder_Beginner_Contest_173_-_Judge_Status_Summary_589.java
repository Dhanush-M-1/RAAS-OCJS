import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ac = 0; int wa = 0; int tle = 0; int re = 0;

		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			String s = sc.next();
			ac += s.equals("AC") ? 1 : 0;
			wa += s.equals("WA") ? 1 : 0;
			tle += s.equals("TLE") ? 1 : 0;
			re += s.equals("RE") ? 1 : 0;
		}

		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}