import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Rough{
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
	static int mod = (int) (1e9+7);
	static long cf = 998244353;
    static final int MAX = (int) (1e6+1);
    public static long[] Bit;
    public static List<Integer>[] edges;
	public static int[][] parent;
	public static int col = 20;
	public static FastReader sc = new FastReader();
	public static void main(String[] args) {
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;++i) a[i] = sc.nextInt();
		long min = 0, max = 0;
		int ans = 0;
		for(int i = 0;i < n;i++){
			if(a[i] == 0){
				if(max < 0){
					ans++; min = 0; max = d;
				}else{
					min = Math.max(min, 0);
				}
			}else{
				min += a[i];
				max += a[i];
				max = Math.min(max, d);
				if(max < min){
					ans = -1;
					break;
				}
			}
		}
		out.println(ans);
		out.close();

	}
	
	
	
	
	
}