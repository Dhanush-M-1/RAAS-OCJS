import java.util.*;
import java.io.*;
import java.text.*;

public class D1334 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long l = sc.nextLong();
			long r = sc.nextLong();
			int curl = 0;
			int curr = 0;
			boolean uu = r == 1l * n * (n - 1) + 1;
			Queue<Long> ans = new LinkedList<Long>();
			for (int i = 1; i <= n-1; i++) {
				int len = 2 * (n - i);
				curl = 1;
				curr = len;
				long intl = Math.max(curl, l);
				long intr = Math.min(curr, r);
				if (intl <= intr) {
					for (long j = intl; j <= intr; j++) {
//						pw.println(intl+" "+intr +" "+i+" "+l+" "+r+" "+curl+" "+curr);
						ans.add(j % 2 == 1 ? i : j / 2 + i);
					}
				}
				l -= len;
				r -= len;
			}
			if (uu)
				ans.add(1l);
			while (!ans.isEmpty()) {
				pw.print(ans.poll() + " ");
			}
			pw.println();
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
