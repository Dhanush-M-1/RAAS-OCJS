import static java.lang.Math.*; 

import java.io.*; 
import java.util.*; 

public class Template {
	BufferedReader in; 
	PrintWriter out;
	StringTokenizer st; 

	String next() {
		while (st==null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {}
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
	
	long[] tr, ad, ma, a; 
	long ll, rr; 

	void build(int v, int l, int r) {
		if (r<l) return;
		if (l==r) {
			tr[v] = a[l]; 
			ma[v] = a[l]; 
			ad[v] = 0;
			return;
		} 

		int m = (l+r) / 2; 

		build(v*2, l, m);
		build(v*2+1, m+1, r);
		ma[v] = Math.max(ma[v*2], ma[v*2+1]);
	}

	void push(int v) {
		if (ad[v] != 0) {
			tr[v]+=ad[v];
			ad[v*2]+=ad[v]; 
			ad[v*2+1]+=ad[v]; 
			ma[v*2]+=ad[v]; 
			ma[v*2+1]+=ad[v];
			ad[v] = 0;
		}
	}

	void add(int v, int l, int r, long x) {
		if (r<l || r < ll || l > rr) return;
		
		if (ll <= l && r <= rr) {
			ad[v]+=x; 
			ma[v]+=x;
			return;
		}
		push(v);
		int m = (l+r) / 2; 

		add(v*2, l, m, x);
		add(v*2+1, m+1, r, x);
		ma[v] = Math.max(ma[v*2], ma[v*2 + 1]);
	}

	long max(int v, int l, int r) {
		if (r<l || r < ll || l > rr) return Long.MIN_VALUE/20;
		
		if (ll <= l && r <= rr) {
			return ma[v]; 
		}
		push(v);
		int m = (l+r) / 2; 
		return Math.max(max(v*2, l, m), max(v*2+1, m+1, r));
	}

	public void run() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Long start = System.currentTimeMillis();

		int n = nextInt();
		int m = nextInt(); 

		long[] t = new long[m]; 
		long[] l = new long[m]; 
		long[] r = new long[m]; 
		long[] f = new long[m]; 


		tr = new long[n*6]; 
		ma = new long[n*6]; 
		ad = new long[n*6];
		a = new long[n];

		for (int i=0; i<m; i++) {
			t[i] = nextLong();
			l[i] = nextLong() - 1;
			r[i] = nextLong() - 1;
			f[i] = nextLong(); 	
		}


		for (int i=0; i<n; i++) {
			long add=0, mm = 1000000000;
			for (int j=0; j<m; j++) if (l[j] <= i && i <= r[j]){
				if (t[j]==1) {
					add += f[j]; 
				} else {
					mm = min(mm, f[j] - add);
				}
			}
			a[i] = mm; 
		}
		//System.err.println(Arrays.toString(a));
		build(1, 0, n-1);

		boolean ok=true;
		for (int i = 0;  i<m; i++) {
			if (t[i]==1) {
				ll = l[i]; 
				rr = r[i]; 
				//System.err.println("asd " + ll + " "+ rr + " " + f[i]);
				add(1, 0, n-1, f[i]);
			} else {
				ll = l[i]; 
				rr = r[i]; 
				long mx = max(1, 0, n-1);
				//System.err.println(mx + " " + ll + " " + rr);
				if (mx!=f[i]) ok = false; 
			}
		}

		for (int i=0; i<n; i++) if (abs(a[i]) > 1000000000L) ok=false; 

		if (ok) {
			out.println("YES");
			for (int i=0; i<n; i++) out.print(a[i] + " ");
		} else out.println("NO");

		Long end = System.currentTimeMillis();
		//System.out.println((end - start) / 1000.0);
		out.close(); 
	}

	public static void main(String[] args) throws Exception {
		new Template().run(); 
	}
}