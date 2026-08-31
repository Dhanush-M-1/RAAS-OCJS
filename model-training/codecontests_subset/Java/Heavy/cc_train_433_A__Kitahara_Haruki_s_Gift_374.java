

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class A {
	/* Designeg by Shoh */
	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		int n = nexInt();
		int a[] = new int[n + 1];
		int k = 0, l = 0;
		for (int i = 1; i <= n; i++) {
			a[i] = nexInt();
			if (a[i] == 100)
				l++;
			else
				k++;
		}
		int p = k % 2;
		if (p == 1) {
			if (l < 2)
				System.out.println("NO");
			else if (l % 2 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		return;
		}
		if(l%2==1)
			System.out.println("NO");
		else
			System.out.println("YES");
		pw.close();
	}

	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static int nexInt() throws IOException {
		return Integer.parseInt(next());
	}

	private static long nexLong() throws IOException {
		return Long.parseLong(next());
	}

	private static double nexDouble() throws IOException {
		return Double.parseDouble(next());
	}

	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}