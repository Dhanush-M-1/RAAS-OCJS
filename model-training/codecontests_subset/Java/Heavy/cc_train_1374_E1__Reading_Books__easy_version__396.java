import java.io.*;
import java.util.*;

public class E {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = scn.nextInt(), k = scn.nextInt();
		PriorityQueue<Integer> p1 = new PriorityQueue<>(), p2 = new PriorityQueue<>(), p12 = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int t = scn.nextInt(), f = scn.nextInt(), s = scn.nextInt();
			if (f == 1 && s == 1) {
				p12.add(t);
			} else if (f == 1) {
				p1.add(t);
			} else if (s == 1) {
				p2.add(t);
			}
		}
		int ans = 0;
		boolean bool = false;
		while (k > 0) {
			if (!p1.isEmpty() && !p2.isEmpty() && !p12.isEmpty() && (p1.peek() + p2.peek()) <= p12.peek()) {
				ans += p1.poll();
				ans += p2.poll();
			} else if (!p1.isEmpty() && !p2.isEmpty() && !p12.isEmpty() && (p1.peek() + p2.peek()) > p12.peek()) {
				ans += p12.poll();
			} else if (!p12.isEmpty()) {
				ans += p12.poll();
			} else if (!p1.isEmpty() && !p2.isEmpty()) {
				ans += p1.poll();
				ans += p2.poll();
			} else {
				bool = true;
				break;
			}
			k--;
		}
		sb.append(bool ? -1 : ans);
		sb.append("\n");
		System.out.print(sb);
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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
	}
}