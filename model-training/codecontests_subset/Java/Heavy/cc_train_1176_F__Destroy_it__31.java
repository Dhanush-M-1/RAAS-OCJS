import java.io.*;
import java.util.*;

public class tr0 {
	static PrintWriter out;
	static StringBuilder sb;
	static long mod = 1000000007;
	static int inf = 1000000000;
	static long[] fac;
	static int[] si;
	static int n, k;
	static long[][] memo;
	static long[][] a;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		n = sc.nextInt();
		memo = new long[n + 1][11];
		a = new long[n][6];
		for (int i = 0; i < n; i++) {
			k = sc.nextInt();
			PriorityQueue<Long> pq = new PriorityQueue<>();
			long two = 0;
			long three = 0;
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				if (x == 2)
					two = Math.max(two, sc.nextInt());
				else if (x == 3)
					three = Math.max(three, sc.nextInt());
				else
					pq.add(sc.nextLong());
				if (pq.size() > 3)
					pq.remove();
			}
			a[i][4] = three;
			a[i][3] = two;
			PriorityQueue<Long> pq1 = new PriorityQueue<>((op,op1)->(int)(op1-op));
			for(long t:pq)
				pq1.add(t);
			if (!pq1.isEmpty())
				a[i][2] = pq1.poll();
			if (!pq1.isEmpty())
				a[i][1] = pq1.remove();
			if (!pq1.isEmpty())
				a[i][0] = pq1.remove();
		}
	    long [][]dp=new long[n+1][11];
	    for(int i=n-1;i>=0;i--) {
	    	for(int m=0;m<10;m++) {
	    		long ans=dp[i+1][m];
	    		if (m == 9) {
	    			if(a[i][4]!=0)
	    			ans = Math.max(ans, 2 * a[i][4] + dp[i+1][(m+1)%10]);
	    			if(a[i][3]!=0)
	    			ans = Math.max(ans, 2 * a[i][3] + dp[i+1][(m+1)%10]);
	    			if(a[i][2]!=0)
	    			ans = Math.max(ans, 2 * a[i][2] + dp[i+1][(m+1)%10]);
	    			if (a[i][2] != 0 && a[i][3] != 0)
	    				ans = Math.max(ans, 2 * Math.max(a[i][2], a[i][3]) + Math.min(a[i][2], a[i][3]) + dp[i+1][(m+2)%10]);
	    			if (a[i][2] != 0 && a[i][1] != 0)
	    				ans = Math.max(ans, 2 * a[i][2] + a[i][1] + dp[i+1][(m+2)%10]);
	    			if (a[i][2] != 0 && a[i][1] != 0 && a[i][0] != 0)
	    				ans = Math.max(ans, 2 * a[i][2] + a[i][1] + a[i][0] + dp[i+1][(m+3)%10]);
	    		} else if (m == 8) {
	    			if(a[i][4]!=0)
		    			ans = Math.max(ans,  a[i][4] + dp[i+1][(m+1)%10]);
		    			if(a[i][3]!=0)
		    			ans = Math.max(ans,  a[i][3] + dp[i+1][(m+1)%10]);
		    			if(a[i][2]!=0)
		    			ans = Math.max(ans,  a[i][2] + dp[i+1][(m+1)%10]);
		    			if (a[i][2] != 0 && a[i][3] != 0)
		    				ans = Math.max(ans, 2 * Math.max(a[i][2], a[i][3]) + Math.min(a[i][2], a[i][3]) + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0)
		    				ans = Math.max(ans, 2 * a[i][2] + a[i][1] + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0 && a[i][0] != 0)
		    				ans = Math.max(ans, 2 * a[i][2] + a[i][1] + a[i][0] + dp[i+1][(m+3)%10]);
	    		} else if (m == 7) {
	    			if(a[i][4]!=0)
		    			ans = Math.max(ans,  a[i][4] + dp[i+1][(m+1)%10]);
		    			if(a[i][3]!=0)
		    			ans = Math.max(ans,  a[i][3] + dp[i+1][(m+1)%10]);
		    			if(a[i][2]!=0)
		    			ans = Math.max(ans,  a[i][2] + dp[i+1][(m+1)%10]);
		    			if (a[i][2] != 0 && a[i][3] != 0)
		    				ans = Math.max(ans,  Math.max(a[i][2], a[i][3]) + Math.min(a[i][2], a[i][3]) + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0)
		    				ans = Math.max(ans,  a[i][2] + a[i][1] + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0 && a[i][0] != 0)
		    				ans = Math.max(ans, 2 * a[i][2] + a[i][1] + a[i][0] + dp[i+1][(m+3)%10]);
	    		} else if(m<7){
	    			if(a[i][4]!=0)
		    			ans = Math.max(ans,  a[i][4] + dp[i+1][(m+1)%10]);
		    			if(a[i][3]!=0)
		    			ans = Math.max(ans,  a[i][3] + dp[i+1][(m+1)%10]);
		    			if(a[i][2]!=0)
		    			ans = Math.max(ans,  a[i][2] + dp[i+1][(m+1)%10]);
		    			if (a[i][2] != 0 && a[i][3] != 0)
		    				ans = Math.max(ans,  Math.max(a[i][2], a[i][3]) + Math.min(a[i][2], a[i][3]) + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0)
		    				ans = Math.max(ans,  a[i][2] + a[i][1] + dp[i+1][(m+2)%10]);
		    			if (a[i][2] != 0 && a[i][1] != 0 && a[i][0] != 0)
		    				ans = Math.max(ans,  a[i][2] + a[i][1] + a[i][0] + dp[i+1][(m+3)%10]);
	    		}
	    		dp[i][m]=ans;
	    	}
	    }
	    out.print(dp[0][0]);
		out.flush();
	}

	static long dp(int i, int m) {
		if (i == n)
			return 0l;
		if (memo[i][m] != -1l)
			return memo[i][m];
		long ans = 0;
		long[] ma = new long[3];
		for (int id = 0; id < 3; id++) {
				ma[id] = a[i][id];
		}
		if (m == 9) {
			if(a[i][4]!=0)
			ans = Math.max(ans, 2 * a[i][4] + dp(i + 1, (m + 1) % 10));
			if(a[i][3]!=0)
			ans = Math.max(ans, 2 * a[i][3] + dp(i + 1, (m + 1) % 10));
			if(ma[2]!=0)
			ans = Math.max(ans, 2 * ma[2] + dp(i + 1, (m + 1) % 10));
			if (ma[2] != 0 && a[i][3] != 0)
				ans = Math.max(ans, 2 * Math.max(ma[2], a[i][3]) + Math.min(ma[2], a[i][3]) + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0)
				ans = Math.max(ans, 2 * ma[2] + ma[1] + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0 && ma[0] != 0)
				ans = Math.max(ans, 2 * ma[2] + ma[1] + ma[0] + dp(i + 1, (m + 3) % 10));
		} else if (m == 8) {
			if(a[i][4]!=0)
			ans = Math.max(ans, a[i][4] + dp(i + 1, (m + 1) % 10));
			if(a[i][3]!=0)
			ans = Math.max(ans, a[i][3] + dp(i + 1, (m + 1) % 10));
			if(ma[2]!=0)
			ans = Math.max(ans, ma[2] + dp(i + 1, (m + 1) % 10));
			if (ma[2] != 0 && a[i][3] != 0)
				ans = Math.max(ans, 2 * Math.max(ma[2], a[i][3]) + Math.min(ma[2], a[i][3]) + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0)
				ans = Math.max(ans, 2 * ma[2] + ma[1] + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0 && ma[0] != 0)
				ans = Math.max(ans, 2 * ma[2] + ma[1] + ma[0] + dp(i + 1, (m + 3) % 10));
		} else if (m == 7) {
			if(a[i][4]!=0)
				ans = Math.max(ans, a[i][4] + dp(i + 1, (m + 1) % 10));
				if(a[i][3]!=0)
				ans = Math.max(ans, a[i][3] + dp(i + 1, (m + 1) % 10));
				if(ma[2]!=0)
				ans = Math.max(ans, ma[2] + dp(i + 1, (m + 1) % 10));
			if (ma[2] != 0 && a[i][3] != 0)
				ans = Math.max(ans, Math.max(ma[2], a[i][3]) + Math.min(ma[2], a[i][3]) + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0)
				ans = Math.max(ans, ma[2] + ma[1] + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0 && ma[0] != 0)
				ans = Math.max(ans, 2 * ma[2] + ma[1] + ma[0] + dp(i + 1, (m + 3) % 10));
		} else if(m<7){
			if(a[i][4]!=0)
				ans = Math.max(ans, a[i][4] + dp(i + 1, (m + 1) % 10));
				if(a[i][3]!=0)
				ans = Math.max(ans, a[i][3] + dp(i + 1, (m + 1) % 10));
				if(ma[2]!=0)
				ans = Math.max(ans, ma[2] + dp(i + 1, (m + 1) % 10));
			if (ma[2] != 0 && a[i][3] != 0)
				ans = Math.max(ans, Math.max(ma[2], a[i][3]) + Math.min(ma[2], a[i][3]) + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0)
				ans = Math.max(ans, ma[2] + ma[1] + dp(i + 1, (m + 2) % 10));
			if (ma[2] != 0 && ma[1] != 0 && ma[0] != 0)
				ans = Math.max(ans, ma[2] + ma[1] + ma[0] + dp(i + 1, (m + 3) % 10));
		}
		return memo[i][m] = ans;
	}

	static class pair implements Comparable<pair> {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}

		public int compareTo(pair o) {
			return y - o.y;
		}
	}

	static long inver(long x) {
		int a = (int) x;
		long e = (mod - 2);
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				// System.out.println(res*a);
				res = (int) ((1l * res * a) % mod);
			}
			a = (int) ((1l * a * a) % mod);
			e >>= 1;
		}
		// out.println(res+" "+x);
		return res % mod;
	}

	static long fac(int n) {
		if (n == 0)
			return fac[n] = 1;
		if (n == 1)
			return fac[n] = 1;
		long ans = 1;
		for (int i = 1; i <= n; i++)
			fac[i] = ans = (i % mod * ans % mod) % mod;
		return ans % mod;
	}

	static long gcd(long a, long b) {

		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static class sol {
		boolean st;
		int l;
		int r;
		char s;

		sol(boolean st, int l, int r, char s) {
			this.st = st;
			this.l = l;
			this.r = r;
			this.s = s;
		}

		public String toString() {
			return st + " " + l + " " + r + " " + s;
		}
	}

	static class unionfind {
		int[] p;
		int[] size;

		unionfind(int n) {
			p = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {
				p[i] = i;
			}
			Arrays.fill(size, 1);
		}

		int findSet(int v) {
			if (v == p[v])
				return v;
			return p[v] = findSet(p[v]);
		}

		boolean sameSet(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return true;
			return false;
		}

		int max() {
			int max = 0;
			for (int i = 0; i < size.length; i++)
				if (size[i] > max)
					max = size[i];
			return max;
		}

		void combine(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return;
			if (size[a] > size[b]) {
				p[b] = a;
				size[a] += size[b];

			} else {
				p[a] = b;
				size[b] += size[a];
			}
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}