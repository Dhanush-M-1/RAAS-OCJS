
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZgukistringZ {

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		final int ALPHA = 26, oo = 1 << 27;
		String s = sc.next(), a = sc.next(), b = sc.next();
		int n = s.length(), m = a.length(), k = b.length();
		int[] original = new int[ALPHA], aa = new int[ALPHA], bb = new int[ALPHA];
		for (int i = 0; i < n; i++)
			original[s.charAt(i) - 'a']++;
		for (int i = 0; i < m; i++)
			aa[a.charAt(i) - 'a']++;
		for (int i = 0; i < k; i++)
			bb[b.charAt(i) - 'a']++;
		int min = oo;
		for (int i = 0; i < m; i++)
			min = Math.min(min, original[a.charAt(i) - 'a'] / aa[a.charAt(i) - 'a']);
		int ans = -oo, as = 0, bs = 0;
		for (int i = 0; i <= min; i++) {
			int[] remain = new int[ALPHA];
			for (int j = 0; j < ALPHA; j++)
				remain[j] = original[j] - (i * aa[j]);
			int remainAns = oo;
			for (int j = 0; j < ALPHA; j++)
				if (bb[j] > 0)
					remainAns = Math.min(remainAns, remain[j] / bb[j]);
			int maybe = remainAns + i;
			if (maybe > ans) {
				as = i;
				bs = remainAns;
				ans = maybe;
			}
		}
		for (int i = 0; i < as; i++)
			out.print(a);
		for (int i = 0; i < bs; i++)
			out.print(b);
		for (int i = 0; i < 26; i++) {
			original[i] -= ((as * aa[i]) + (bs * bb[i]));
			for (int j = 0; j < original[i]; j++)
				out.print((char) (i + 'a'));
		}
		out.flush();
		out.close();
	}

	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;

		public MyScanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public MyScanner(String file) throws IOException {
			br = new BufferedReader(new FileReader(new File(file)));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
