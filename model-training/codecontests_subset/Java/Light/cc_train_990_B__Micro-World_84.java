import java.util.*;
import java.io.*;

public class B990 {
	public static void main(String[] args) throws Exception {
		int n = i(), k = i();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] a = new int[n];
		int eaten = 0;

		for (int i = 0; i < n; i++) {
			pq.offer(i());
		}

		for (int i = 0; i < n; i++) {
			a[i] = pq.poll();
		}

		int j = 0;
		for (int i = 1; i < n; i++) {
			while (i > j && a[i] > a[j] + k) {
				j++;
			}

			while (i > j && a[i] > a[j] && a[i] <= a[j] + k) {
				eaten++;
				j++;
			}
		}


		out.println(n - eaten);

		out.close();
	}

	static BufferedReader in;
	static StringTokenizer st = new StringTokenizer("");
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = new BufferedReader(new FileReader("cf.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static void check() throws Exception {
		if (!st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
	}
	static int i() throws Exception {check(); return Integer.parseInt(st.nextToken());}
	static String s() throws Exception {check(); return st.nextToken();}
	static double d() throws Exception {check(); return Double.parseDouble(st.nextToken());}
	static long l() throws Exception {check(); return Long.parseLong(st.nextToken());}
}
