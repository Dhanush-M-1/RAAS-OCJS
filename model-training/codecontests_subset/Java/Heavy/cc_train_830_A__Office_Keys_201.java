import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), k = sc.nextInt(), office = sc.nextInt();
		int [] people = new int[n];
		int [] keys = new int[k];
		for (int i = 0; i < n; i++) {
			people[i] = sc.nextInt();
		}
		for (int i = 0; i < k; i++) {
			keys[i] = sc.nextInt();
		}
		shuffle(people);
		shuffle(keys);
		Arrays.sort(people);
		Arrays.sort(keys);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i+n-1 < keys.length; i++) {
			int tmp = 0;
			for (int j = i; j-i < n; j++) {
				tmp = Math.max(tmp, Math.abs(keys[j]-people[j-i])+Math.abs(keys[j]-office));
			}
			ans = Math.min(ans, tmp);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	static void shuffle(int[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			int r = i + (int)(Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
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
