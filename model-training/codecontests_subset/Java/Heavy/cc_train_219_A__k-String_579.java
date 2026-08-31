import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	PrintWriter out;

	public void solution() throws IOException {
		int k = nextInt();
		String s = nextToken();
		String ans = "";
		int used[] = new int[100];
		for (int i = 0; i < s.length(); i++) {
			used[(int) (s.charAt(i) - 'a')]++;
		}
		for (int i = 0; i < 100; i++) {
			if (used[i] > 0) {
				if (used[i] % k != 0) {
					System.out.println(-1);
					System.exit(0);
				} else {
					for (int j = 0; j < used[i] / k; j++) {
						ans += (char) (i + 'a');
					}
				}
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(ans);
		}

	}

	String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(bf.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String args[]) throws IOException {
		new A().solution();
	}
}