import java.io.*;
import java.util.Scanner;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		String s = sc.next();
		int n = s.length();

		String keyence = "keyence";

		for (int i = 0; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				String tmp = s.substring(0, i);
				tmp += s.substring(j, n);
				
				if (tmp.equals(keyence)) {
					pr.println("YES");
					return;
				}
			}
		}

		pr.println("NO");
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);
			
		solve();
			
		pr.close();
		sc.close();
	}

	static class Printer extends PrintWriter {
		Printer(OutputStream out) {
			super(out);
		}
	}
}
