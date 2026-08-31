import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {
	public static void main(String[] args) throws IOException {
		FastScanner in= new FastScanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		
		int n= in.nextInt();
		int k= in.nextInt();
		int p= in.nextInt();
		
		int [] pos= new int[n];
		for (int i = 0; i < pos.length; i++) {
			pos[i]= in.nextInt();
		}
		int [] key= new int[k];
		for (int i = 0; i < key.length; i++) {
			key[i]= in.nextInt();
		}
		
		Arrays.sort(pos);
		Arrays.sort(key);
		
		long res=Long.MAX_VALUE;
		for (int i = 0; i <= k-n; i++) {
			//slide set
			long cur= 0;
			for (int j = 0; j < n; j++) {
				cur= Math.max(cur, Math.abs(p-key[i+j])+Math.abs(pos[j]-key[i+j]));
			}
			res= Math.min(res, cur);
		}
		System.out.println(res);
	}
	static class p implements Comparable<p>{
		int st;
		int occ;
		int len;
		String res;
		public p(int a, int b, int c, String d) {
			st=a;
			occ=b;
			len= c;
			res= d;
		}
		public int compareTo(p o) {
			if(this.st-o.st==0) {
				if(this.occ-o.occ==0) {
					return this.len-o.len;
				}
				return this.occ-o.occ;
			}
			return this.st-o.st;
		}
	}
	static class FenwickTree {
		long[] ft;
		public FenwickTree(int n) {
			ft = new long[n + 1];
		}

		int rsq(int b) {
			int sum = 0;
			for (; b > 0; b -= (b & (-b)))
				sum += ft[b];
			return sum;
		}

		int rsq(int a, int b) {
			return rsq(b) - (a == 1 ? 0 : rsq(a - 1));
		}

		void update(int k, int v) {
			for (; k < ft.length; k += (k & (-k)))
				ft[k] += v;
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}

		public String next() throws IOException {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				return next();
			}
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}