import java.io.*;
import java.math.BigInteger;
import java.util.*;


 
public class Main{
	/*
	 * use Integer for sorting
	 * avoid object comparison
	 * List/char array instead of strings
	 * 
	 */
	public static class FastReader {
		BufferedReader br;
		StringTokenizer root;
		
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (root == null || !root.hasMoreTokens()) {
				try {
					root = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return root.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static long mod = (long) (1e9+7);
	static long cf = 998244353;
    static final long MAX = (long) 1e8;
    public static List<Integer>[] edges;
    public static int[][] parent;
    public static long[] fac;
    public static int N = 400000+200;
    public static int x = 0;
    public static boolean[] visited;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt(), m = sc.nextInt();
		int Q = sc.nextInt();
		DJSet ds = new DJSet(n+m);
		for(int i = 0;i < Q;i++){
			ds.union(sc.nextInt()-1, sc.nextInt()-1+n);
		}
		out.println(ds.count()-1);
		out.close();
	}
	
	public static class DJSet {
		public int[] upper;
 
		public DJSet(int n) {
			upper = new int[n];
			Arrays.fill(upper, -1);
		}
 
		public int root(int x) {
			return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
		}
 
		public boolean equiv(int x, int y) {
			return root(x) == root(y);
		}
 
		public boolean union(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y) {
				if (upper[y] < upper[x]) {
					int d = x;
					x = y;
					y = d;
				}
				upper[x] += upper[y];
				upper[y] = x;
			}
			return x == y;
		}
 
		public int count() {
			int ct = 0;
			for (int u : upper)
				if (u < 0)
					ct++;
			return ct;
		}
	}
	}