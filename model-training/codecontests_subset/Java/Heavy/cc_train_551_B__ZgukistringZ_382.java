
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZgukistringZ1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		int counta[] = new int[26];
		int countb[] = new int[26];
		int countc[] = new int[26];

		for (int i = 0; i < a.length(); i++)
			counta[a.charAt(i) - 'a']++;
		for (int i = 0; i < b.length(); i++)
			countb[b.charAt(i) - 'a']++;

		for (int i = 0; i < c.length(); i++)
			countc[c.charAt(i) - 'a']++;

		int maxb = 1000000;

		for (int i = 0; i < b.length(); i++)
			maxb = Math.min(maxb, counta[b.charAt(i) - 'a'] / countb[b.charAt(i) - 'a']);

		int maxc = 100000;
		int ans = 0;
		int maxbb = 0;
		int maxcc = 0;
		for (int i = 0; i <= maxb; i++) {

			for (int j = 0; j < 26; j++) {
				if (countc[j] > 0) {
					maxc = Math.min(maxc, (counta[j] - countb[j] * i) / countc[j]);
				}
			}
			if (i + maxc > ans) {
				ans = i + maxc;
				maxbb = i;
				maxcc = maxc;

			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxbb; i++)
			sb.append(b);

		for (int i = 0; i < maxcc; i++)
			sb.append(c);

		for (int i = 0; i < counta.length; i++) {
			int x = counta[i] - (countb[i] * maxbb + countc[i] * maxcc);
			if (x > 0)
				for (int j = 0; j < x; j++)
					sb.append((char) (i + 'a'));

		}
		System.out.println(sb.toString());
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream System) {
			br = new BufferedReader(new InputStreamReader(System));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() {
			for (long i = 0; i < 3e9; i++)
				;
		}
	}
}
