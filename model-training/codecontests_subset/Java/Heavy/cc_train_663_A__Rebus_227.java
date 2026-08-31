import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s = br.readLine();
		int pos = s.indexOf("=");
		int n = Integer.parseInt(s.substring(pos+2));
		s = s.substring(0, pos);
		int minus = 0, plus = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='?') {
				if (i==0 || s.charAt(i-2)=='+')
					plus++;
				else
					minus++;
			}
		}
		long sum_p = 1l*n*plus;
		long sum_m = minus;
		long[]a = new long[plus+1];
		long[]b = new long[minus+1];
		Arrays.fill(a, n);
		Arrays.fill(b, 1);
		for (int i = 1; i <= plus; i++) {
			if (sum_p-n+1-sum_m >= n) {
				sum_p -= n;
				sum_p++;
				a[i] = 1;
			}
			else {
				a[i] = n-sum_p+n+sum_m;
				if (a[i] > n || a[i] < 1) {
					System.out.println("Impossible");
					return;
				}
				sum_p -= n;
				sum_p += a[i];
				break;
			}
		}
		for (int i = 1; i <= minus; i++) {
			if (sum_p-sum_m+1-n >= n) {
				b[i] = n;
				sum_m -= 1;
				sum_m += n;
			}
			else {
				b[i] = sum_p-sum_m+1-n;
				if (b[i] < 1 || b[i] > n) {
					System.out.println("Impossible");
					return;
				}
				sum_m -= 1;
				sum_m += b[i];
				break;
			}
		}
		if (sum_p-sum_m != n) {
			System.out.println("Impossible");
			return;
		}
		int p = 1, m = 1;
		System.out.println("Possible");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='?') {
				if (i==0 || s.charAt(i-2)=='+')
					pw.print(a[p++]);
				else
					pw.print(b[m++]);
			}
			else
				pw.print(s.charAt(i));
		}
		pw.println("= "+n);
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
