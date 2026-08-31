import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long ax = sc.nextLong(), ay = sc.nextLong();
		long bx = sc.nextLong(), by = sc.nextLong();
		long cx = sc.nextLong(), cy = sc.nextLong();
		long dist1 = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
		long dist2 = (cx - bx) * (cx - bx) + (cy - by) * (cy - by);
		long dist3 = (cx - ax) * (cx - ax) + (cy - ay) * (cy - ay);
//		System.out.println(dist1 + " " + dist2 + " " + dist3);
		boolean colinear = (bx-ax)*(cy-ay) == (by-ay)*(cx-ax);
		if (dist1 == dist2 && !colinear) // ab = bc && a b c are not colinear
			out.println("yes");
		else
			out.println("no");
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] ans = new int[n];
			for (int i = 0; i < n; i++)
				ans[i] = nextInt();
			return ans;
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

	}
}