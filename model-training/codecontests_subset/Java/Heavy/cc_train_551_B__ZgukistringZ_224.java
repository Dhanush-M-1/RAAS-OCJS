import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class P {

	static int numOfSubs(int[] occA, int[] occB) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++)
			if (occB[i] > 0)
				min = Math.min(min, occA[i] / occB[i]);
		return min;
	}

	static StringBuilder addC(int[] occA, int[] occC, String s2) {
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < s2.length(); i++)
			occA[s2.charAt(i) - 'a']--;
		ans.append(s2);
		return ans;
	}

	static StringBuilder addB(int[] occA, int[] occB, String s1) {
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < s1.length(); i++)
			occA[s1.charAt(i) - 'a']--;
		ans.append(s1);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[3];
		int[][] occ = new int[3][26];
		for (int i = 0; i < 3; i++) {
			s[i] = sc.nextLine();
			int N = s[i].length();
			for (int j = 0; j < N; j++)
				occ[i][s[i].charAt(j) - 'a']++;
		}
		int bInA = numOfSubs(occ[0], occ[1]);
		int cInA = numOfSubs(occ[0], occ[2]);
		StringBuilder ans = new StringBuilder();
		while (bInA + cInA != 0) {

			if (bInA > cInA)
				ans.append(addB(occ[0], occ[1], s[1]));
			else
				ans.append(addC(occ[0], occ[2], s[2]));

			bInA = numOfSubs(occ[0], occ[1]);
			cInA = numOfSubs(occ[0], occ[2]);

		}

		for (int i = 0; i < 26; i++)
			for (int j = 0; j < occ[0][i]; j++)
				ans.append((char) ('a' + i));

		System.out.println(ans);

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] nextIntArray1(int n) throws IOException {
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] shuffle(int[] a, int n) {
			int[] b = new int[n];
			for (int i = 0; i < n; i++)
				b[i] = a[i];
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				int t = b[i];
				b[i] = b[j];
				b[j] = t;
			}
			return b;
		}

		public int[] nextIntArraySorted(int n) throws IOException {
			int[] a = nextIntArray(n);
			a = shuffle(a, n);
			Arrays.sort(a);
			return a;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArray1(int n) throws IOException {
			long[] a = new long[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArraySorted(int n) throws IOException {
			long[] a = nextLongArray(n);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				long t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			Arrays.sort(a);
			return a;
		}
	}
}