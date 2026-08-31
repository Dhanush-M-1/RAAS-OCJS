import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class C {
	
	public static void main(String[] args) {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		int t = 1;
		while(t-->0) solver.solve(1, scan, out);
		out.close();
	}
	
	static class Task {
		static long[] a;
		static long INF = Long.MAX_VALUE/100;
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			int n = scan.nextInt();
			a = new long[n];
			for(int i = 0; i < n; i++) a[i] = scan.nextLong();
			SegmentTree tree = new SegmentTree(0, n-1);
			int[] res = new int[n];
			for(int i = 1; i <= n; i++) {
				int get = tree.walk();
				res[get] = i;
				if(get != n-1) tree.update(get+1, n-1, -i);
				tree.update(get, get, INF);
			}
			for(int i : res) out.print(i + " ");
		}
		
		static class SegmentTree {
			int s, e;
			long modify;
			long minVal;
			SegmentTree left, right;
			
			public SegmentTree(int ss, int ee) {
				s = ss;
				e = ee;
				modify = 0;
				if(s == e) {
					minVal = a[s];
					left = null;
					right = null;
				}
				else {
					int mid = (s+e)/2;
					left = new SegmentTree(s, mid);
					right = new SegmentTree(mid+1, e);
					minVal = Math.min(left.minVal, right.minVal);
				}
			}
			
			public void update(int start, int end, long val) {
				push();
				if(s > end || e < start) return;
				if(s >= start && e <= end) {
					modify += val;
					return;
				}
				if(s != e) {
					left.update(start, end, val);
					right.update(start, end, val);
					minVal = Math.min(left.minVal+left.modify, right.minVal+right.modify);
				}
			}
			
			public int walk() {
				push();
				if(s == e) return s;
				if(right.minVal + right.modify == 0) {
					return right.walk();
				}
				if(left.minVal + left.modify == 0) {
					return left.walk();
				}
				return -1;
			}
			
			public void push() {
				minVal += modify;
				if(s != e) {
					left.modify += modify;
					right.modify += modify;
				}
				modify = 0;
			}
		}
	}
	
	static void shuffle(int[] a) {
		Random get = new Random();
		for(int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	static void shuffle(long[] a) {
		Random get = new Random();
		for(int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
 
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
 
}