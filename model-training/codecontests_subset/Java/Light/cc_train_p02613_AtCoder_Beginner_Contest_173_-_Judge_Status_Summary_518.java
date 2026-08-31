import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int a = 0;
		int w = 0;
		int t = 0;
		int r = 0;
		for (int i = 0; i < N; i++) {
			String S = scanner.next();
			if (S.equals("AC")) {
				a += 1;
			} else if (S.equals("WA")) {
				w += 1;
			} else if (S.equals("TLE")) {
				t += 1;
			} else {
				r += 1;
			}
		}
		System.out.println("AC x " + a);
		System.out.println("WA x " + w);
		System.out.println("TLE x " + t);
		System.out.println("RE x " + r);
	}
}