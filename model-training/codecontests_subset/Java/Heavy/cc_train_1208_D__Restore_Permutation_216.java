import java.util.*;
import java.io.*;

public class MAN19D
{

	public static void main(String[] args) throws IOException
	{
		FastScanner scan = new FastScanner(System.in);
		int n = scan.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextLong();
		}
		SegmentTree s = new SegmentTree(arr);
		int[] ans = new int[n];
		for(int i = 1; i <= n; i++){
			s.rmq(0, n-1);
			int idx = s.idx[1];
			ans[idx] = i;
			s.inc(idx+1, n-1, -i);
			s.inc(idx, idx, Long.MAX_VALUE-1);
		}
		for(int i = 0; i < n; i++){
			System.out.print(ans[i]+" ");
		}
	}

	static class SegmentTree{
		int n;
		int[] lo, hi;
		long[] min, delta;
		int[] idx;

		SegmentTree(int t){
			n = t;
			lo = new int[4*n+1];
			hi = new int[4*n+1];
			min = new long[4*n+1];
			idx = new int[4*n+1];
			delta = new long[4*n+1];
			init(1, 0, n-1);
		}
		SegmentTree(long[] arr){
			this(arr.length);
			for(int i = 0; i < n; i++)
				inc(i, i, arr[i]);
		}
		void init(int n, int l, int r) {
			lo[n] = l;
			hi[n] = r;
			if(l == r) return;
			int m = (l+r)/2;
			init(2*n, l, m);
			init(2*n+1, m+1, r);
		}

		void prop(int t) {
			delta[2*t] += delta[t];
			delta[2*t+1] += delta[t];
			delta[t] = 0;
		}

		long rmq(int l, int r) {
			return rmq(1, l, r);
		}

		long rmq(int t, int l, int r) {
			if(r < lo[t] || hi[t] < l) return Long.MAX_VALUE;
			if(l <= lo[t] && hi[t] <= r) return min[t]+delta[t];
			prop(t);
			long minL = rmq(2*t, l, r);
			long minR = rmq(2*t+1, l, r);
			update(t);
			return Math.min(minL, minR);
		}

		void inc(int l, int r, long v) {
			inc(1, l, r, v);
		}
		void inc(int t, int l, int r, long v) {
			if(r < lo[t] || hi[t] < l) return;
			if(l <= lo[t] && hi[t] <= r) {
				delta[t] += v;
				if(l == r) idx[t] = r;
				return;
			}
			prop(t);
			inc(2*t, l, r, v);
			inc(2*t+1, l, r, v);
			update(t);
		}
		
		void update(int t) {
//			if(min[2*t]+delta[2*t] == min[2*t+1]+delta[2*t+1]){
//				idx[t] = Math.max(idx[2*t], idx[2*t]+1);
//				min[t] = min[2*t]+delta[2*t];
//			}
//			else 
			if(min[2*t]+delta[2*t] < min[2*t+1]+delta[2*t+1]){
				min[t] = min[2*t]+delta[2*t];
				idx[t] = idx[2*t];
			}
			else{
				min[t] = min[2*t+1]+delta[2*t+1];
				idx[t] = idx[2*t+1];
			}
		}
	}

	static class FastScanner{

		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream i) {
			br = new BufferedReader(new InputStreamReader(i));
			st = new StringTokenizer("");
		}

		public String next() throws IOException{
			if(st.hasMoreTokens()) return st.nextToken();
			else st = new StringTokenizer(br.readLine());
			return next();
		}
		
		public long nextLong() throws IOException{
			return Long.parseLong(next());
		}

		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
	}
}
