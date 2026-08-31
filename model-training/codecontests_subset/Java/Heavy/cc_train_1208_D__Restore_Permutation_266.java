import java.util.*;
import java.math.*;
import java.io.*;

public class CF1208D {
	class BIT {
		int n; long table[];
		public BIT(int nn) { table = new long[n = nn + 10]; }
		void update(int i, long delta) {
			while(i < n) {
				table[i] += delta;
				i += i & -i;
			}
		}
		long sum(int i) {
			long sum = 0;
			while(i > 0) {
				sum += table[i];
				i -= i & -i;
			}
			return sum;
		}
		long rangeSum(int i, int j) {
			return sum(j) - sum(i - 1);
		}
		int next(long target) {
			long sum = 0;
			int res = 0;
			for(int bit = 20 ; bit >= 0 ; bit--) {
				int power = 1 << bit;
				if(res + power >= n) continue;
				if(sum + table[res + power] <= target) {
					sum += table[res + power];
					res += power;
				}
			}
			return res;
		}
	}
	public CF1208D() {
		FS scan = new FS();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt();
		long[] p = new long[n];
		for(int i = 0 ; i < n ; i++) p[i] = scan.nextLong();
		BIT bit = new BIT(n);
		for(int i = 1 ; i <= n ; i++) bit.update(i, i);
		int[] res = new int[n];
		for(int i = n - 1 ; i >= 0 ; i--) {
			int next = bit.next(p[i]) + 1;
			res[i] = next;
			bit.update(next, -next);
		}
		for(int i = 0 ; i < n ; i++) out.print(res[i] + " ");
		out.println();
		out.close();
	}
	class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		public String next() {
			while(!st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
	public static void main(String[] args) { new CF1208D(); }
}