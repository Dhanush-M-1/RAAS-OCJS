import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class Abood2B {

	static class SegmentTree {		// 1-based DS, OOP

		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array, sTree;

		SegmentTree(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			build(1,1,N);
		}

		void build(int node, int b, int e)	// O(n)
		{
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				int mid = b + e >> 1;
			build(node<<1,b,mid);
			build(node<<1|1,mid+1,e);
			sTree[node] = sTree[node<<1]+sTree[node<<1|1];
			}
		}


		void update_point(int index, int val)			// O(log n)
		{
			index += N - 1;				
			sTree[index] = val;			
			while(index>1)				
			{
				index >>= 1;
			sTree[index] = sTree[index<<1] + sTree[index<<1|1];		
			}
		}



		int query(int i, int j)
		{
			if(i > j)
				return 0;
			return query(1,1,N,i,j);
		}

		int query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			int mid = b + e >> 1;
			int q1 = query(node<<1,b,mid,i,j);
			int q2 = query(node<<1|1,mid+1,e,i,j);
			return q1 + q2;	

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int q = sc.nextInt();
		
		int N = 1; while(N < n) N <<= 1; //padding
		
		int[] in1 = new int[N + 1];
		int[] in2 = new int[N + 1];
		
		SegmentTree st1 = new SegmentTree(in1);
		SegmentTree st2 = new SegmentTree(in2);

		for (int i = 0; i < q; i++) {
			int t = sc.nextInt();
			int d = sc.nextInt();
			if(t == 1) {
				int v = sc.nextInt();
				st1.update_point(d, Math.min(st1.query(d, d) + v, b));
				st2.update_point(d, Math.min(st2.query(d, d) + v, a));
			} else {
				out.println(st1.query(1, d - 1) + st2.query(d + k, n));
			}
		}

		out.flush();
		out.close();
	}






	static class Scanner 



	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}


		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}



	}

}