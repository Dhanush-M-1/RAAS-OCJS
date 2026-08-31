import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			final int n = in.nextInt();
			final int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			out.println(solve(a));
		}
	}

	private static int solve(int[] a) {
		int m = 0;
		for (int i : a) {
			m = Math.max(m, i <= 500_000 ? i - 1 : 1_000_000 - i);
		}
		return m;
	}

}
