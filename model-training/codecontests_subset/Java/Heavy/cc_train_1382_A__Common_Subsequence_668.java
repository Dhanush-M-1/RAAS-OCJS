import java.util.*;
import java.io.*;

public class CF {
	
	
	public static void main(String[] args) throws IOException {
		F scn = new F(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			HashSet<Integer> a = new HashSet<>();
			for(int i=0;i<n;i++) a.add(scn.nextInt());
			
			boolean ans = false;
			int v = -1;
			for(int i=0;i<m;i++) {
				int x = scn.nextInt();
				if(a.contains(x)) {
					ans = true;
					v = x;
				}
			}
			if(ans) pw.println("YES\n" + 1 + " " + v);
			else pw.println("NO");
		}
		pw.flush();
	}
	
	
	
	
	static PrintWriter pw = new PrintWriter(System.out);
	static class F {
		StringTokenizer st;
		BufferedReader br;

		public F(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public F(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] in = new int[n];
			for (int i = 0; i < n; i++)
				in[i] = nextInt();
			return in;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] in = new long[n];
			for (int i = 0; i < n; i++)
				in[i] = nextLong();
			return in;
		}

		public int[] nextIntSortedArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			Arrays.sort(a);
			return a;
		}

		public long[] longSortedArr(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			Arrays.sort(a);
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] in = new Integer[n];
			for (int i = 0; i < n; i++)
				in[i] = nextInt();
			return in;
		}

		public Long[] nextLongArray1(int n) throws IOException {
			Long[] in = new Long[n];
			for (int i = 0; i < n; i++)
				in[i] = nextLong();
			return in;
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
		
		final static long M = 1000000007L;
		
		final static long power(long base, long exp) {
			long ans = 1;
			while(exp > 0) {
				if(exp%2 == 1) ans = (ans * base) % M; 
				exp/=2;
				base = (base * base) % M;
			}
			return ans;
		}
		
		final static long gcd(long a,long b) {
		    return b == 0 ? a : gcd(b, a%b);
		}
	}
}