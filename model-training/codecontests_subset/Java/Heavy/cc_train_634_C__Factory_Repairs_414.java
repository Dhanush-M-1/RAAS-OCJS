import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {


	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), k = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), q = sc.nextInt();
		FenwickTree fa = new FenwickTree(n), fb = new FenwickTree(n);
		for(int i = 1; i <= n; ++i)
		{
			fa.update(i, a);
			fb.update(i, b);
		}
		while(q-->0)
			if(sc.nextInt() == 1)
			{
				int day = sc.nextInt(), orders = sc.nextInt();
				fa.decrement(day, orders);
				fb.decrement(day, orders);
			}
			else
			{
				int l = sc.nextInt(), r = l + k - 1;
				int ans = 0;
				if(l > 1)
					ans += b * (l - 1) - fb.query(1, l - 1);
				if(r < n)
					ans += a * (n - r) - fa.query(r + 1, n);
				out.println(ans);
			}
		out.flush();
		out.close();
	}

	static class FenwickTree
	{
		int[] ft;

		FenwickTree(int n) { ft = new int[n + 1]; }
		
		void decrement(int k, int d)
		{
			int val = query(k, k);
			update(k, -Math.min(d, val));
		}
		
		void update(int k, int val)
		{
			while(k < ft.length)
			{
				ft[k] += val;
				k += k & -k;
			}
		}
		
		int query(int k)
		{
			int sum = 0;
			while(k > 0)
			{
				sum += ft[k];
				k ^= k & -k;
			}
			return sum;
		}
		
		int query(int l, int r) { return query(r) - query(l - 1); }
		
	}
			

	static class Scanner 
	{
		StringTokenizer st;	
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){	br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();}


	}
}