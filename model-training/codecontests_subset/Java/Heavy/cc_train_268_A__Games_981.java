import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.*;

public class B {

	// @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new BufferedOutputStream(System.out));
		int n = sc.nextInt();
		int[] h = new int[n], g = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
			g[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i != j)
					if (h[i] == g[j])
						ans++;
		System.out.println(ans);
		ps.flush();
		ps.close();
		sc.close();
	}

	static class FastReader {
		BufferedReader r;

		FastReader() {
			r = new BufferedReader(new InputStreamReader(System.in));
		}

		long nl() throws NumberFormatException, IOException {
			return Long.parseLong(r.readLine());
		}

		String nxtLine() throws IOException {
			return r.readLine();
		}
	}

	static long g(long a, long b) {
		if (b == 0)
			return a;
		return g(b, a % b);
	}
}
