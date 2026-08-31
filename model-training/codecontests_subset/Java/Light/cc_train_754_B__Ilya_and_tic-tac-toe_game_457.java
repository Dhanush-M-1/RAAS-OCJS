import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			final int n = 4;
			final String[] a = new String[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextLine();
			}
			System.out.println(solve(a));
		}
	}

	private static String solve(String[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				if (winning(new char[] { a[i].charAt(j), a[i].charAt(j + 1), a[i].charAt(j + 2) })) {
					return "YES";
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (winning(new char[] { a[i].charAt(j), a[i + 1].charAt(j), a[i + 2].charAt(j) })) {
					return "YES";
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (winning(new char[] { a[i].charAt(j), a[i + 1].charAt(j + 1), a[i + 2].charAt(j + 2) })) {
					return "YES";
				}
			}
		}
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				if (winning(new char[] { a[i].charAt(j), a[i - 1].charAt(j + 1), a[i - 2].charAt(j + 2) })) {
					return "YES";
				}
			}
		}
		return "NO";
	}

	private static boolean winning(char[] a) {
		if (a[0] == '.' && a[1] == 'x' && a[2] == 'x' || a[0] == 'x' && a[1] == '.' && a[2] == 'x'
				|| a[0] == 'x' && a[1] == 'x' && a[2] == '.') {
			return true;
		}
		return false;
	}

}
