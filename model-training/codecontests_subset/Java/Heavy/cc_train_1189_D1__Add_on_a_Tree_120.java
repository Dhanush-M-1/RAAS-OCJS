import java.io.*;
import java.util.*;

public class tr0 {
	static PrintWriter out;
	static StringBuilder sb;
	static final double EPS = 1e-9;
	static int mod = 1000000007;
	static int inf = (int) 1e9 + 2;
	static long[] fac;
	static int[] si;
	static ArrayList<Integer> primes;
	static ArrayList<Integer>[] ad;
	static int[] ans;
	static int m, k;
	static HashMap<Integer, Integer> t;
	static boolean f;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int n=sc.nextInt();
	    ad=new ArrayList[n];
	    for(int i=0;i<n;i++)
	    	ad[i]=new ArrayList<>();
	    for(int i=0;i<n-1;i++) {
	    	int a=sc.nextInt()-1;
	    	int b=sc.nextInt()-1;
	    	ad[a].add(b);
	    	ad[b].add(a);
	    }
	    for(int i=0;i<n;i++)
	    	if(ad[i].size()==2) {
	    		System.out.println("NO");
	    		return;
	    	}
	    out.println("YES");
		out.close();
	}
	static class seg implements Comparable<seg> {
		int s;
		int e;
        int num;
        int id;
		seg(int s, int e) {
			this.s = s;
			this.e = e;
		}

		public String toString() {
			return s + " " + e+" "+num+" "+id;
		}

		@Override
		public int compareTo(seg o) {
			if(o.s==s)
				return o.e-e; 
			return s - o.s;
		}
	}

	static public class SegmentTree { // 1-based DS, OOP

		int N; // the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array, sTree, lazy,candies;

		SegmentTree(int[] in) {
			array = in.clone();
			N = in.length - 1;
			sTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new int[N << 1];
			candies = new int[N << 1];
			build(1, 1, N);
			build2(1, 1, N);
		}
         public String toString() {
        	 return Arrays.toString(sTree)+"\n"+Arrays.toString(candies);
         }
		void build(int node, int b, int e) // O(n)
		{
			if (b == e)
				sTree[node] = array[b];
			else {
				int mid = b + e >> 1;
				build(node << 1, b, mid);
				build(node << 1 | 1, mid + 1, e);
				sTree[node] = (sTree[node << 1] + sTree[node << 1 | 1])%10;
				if(sTree[node<<1]+sTree[node << 1 | 1]>=10)
					candies[node]++;
			}
		}

		void build2(int node, int b, int e) // O(n)
		{
			if (b == e)
				b=e;
			else {
				int mid = b + e >> 1;
				build(node << 1, b, mid);
				build(node << 1 | 1, mid + 1, e);
				candies[node] = (candies[node << 1] + candies[node << 1 | 1]);
			}
		}

		
		void update_point(int index, int val) // O(log n)
		{
			index += N - 1;
			sTree[index] += val;
			while (index > 1) {
				index >>= 1;
				sTree[index] = sTree[index << 1] + sTree[index << 1 | 1];
			}
		}

		void update_range(int i, int j, int val) // O(log n)
		{
			update_range(1, 1, N, i, j, val);
		}

		void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				sTree[node] += (e - b + 1) * val;
				lazy[node] += val;
			} else {
				int mid = b + e >> 1;
				propagate(node, b, mid, e);
				update_range(node << 1, b, mid, i, j, val);
				update_range(node << 1 | 1, mid + 1, e, i, j, val);
				sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
			}

		}

		void propagate(int node, int b, int mid, int e) {
			lazy[node << 1] += lazy[node];
			lazy[node << 1 | 1] += lazy[node];
			sTree[node << 1] += (mid - b + 1) * lazy[node];
			sTree[node << 1 | 1] += (e - mid) * lazy[node];
			lazy[node] = 0;
		}
 //  static int c=0;
		int query(int i, int j) {
	//		c=0;
			return query(1, 1, N, i, j);
		}
   
		int query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return candies[node];
			int mid = b + e >> 1;
			//propagate(node, b, mid, e);
			int q1 = query(node << 1, b, mid, i, j);
			int q2 = query(node << 1 | 1, mid + 1, e, i, j);
			return q1+q2;
		}
	}
	static int x, y, d;

	static long power(int i) {
		// if(i==0)
		// return 1;
		long a = 1;
		for (int k = 0; k < i; k++)
			a *= i;
		return a;
	}

	static void extendedEuclid(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			d = a;
			return;
		}
		extendedEuclid(b, a % b);
		int x1 = y;
		int y1 = x - a / b * y;
		x = x1;
		y = y1;
	}


	static void dfs(int u) {
		int counter = 1;
		for (int v : ad[u])
			if (ans[v] == 0) {
				if (counter == ans[u]) {
					counter++;
					ans[v] = counter;
				} else
					ans[v] = counter++;
				if (counter > k)
					f = false;
				dfs(v);
			}
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList();
		q.add(s);
		ans[s] = 1;
		while (!q.isEmpty()) {
			int u = q.remove();
			int c = 1;
			for (int v : ad[u]) {
				if (ans[v] == 0) {
					// System.out.println(u);
					if (c == ans[u]) {
						c++;
						ans[v] = c++;
					} else
						ans[v] = c++;
					// System.out.println(v+" "+c);
					if (ans[v] > k)
						f = false;
					q.add(v);
				}
			}
		}
	}

	static void seive() {
		si = new int[1000001];
		primes = new ArrayList<>();
		int N = 1000001;
		si[1] = 1;
		for (int i = 2; i < N; i++) {
			if (si[i] == 0) {
				si[i] = i;
				primes.add(i);
			}
			for (int j = 0; j < primes.size() && primes.get(j) <= si[i] && (i * primes.get(j)) < N; j++)
				si[primes.get(j) * i] = primes.get(j);

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

	static int gcd(int a, int b) {

		if (b == 0)
			return a;
		return gcd(b, a % b);
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