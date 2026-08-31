import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class D1208 {
	static class Scanner {
		BufferedReader br;
		StringTokenizer tk = new StringTokenizer("");

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public int nextInt() throws IOException {
			if (tk.hasMoreTokens())
				return Integer.parseInt(tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			return nextInt();
		}

		public long nextLong() throws IOException {
			if (tk.hasMoreTokens())
				return Long.parseLong(tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			return nextLong();
		}

		public String next() throws IOException {
			if (tk.hasMoreTokens())
				return (tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			return next();
		}

		public String nextLine() throws IOException {
			tk = new StringTokenizer("");
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			if (tk.hasMoreTokens())
				return Double.parseDouble(tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			return nextDouble();
		}

		public char nextChar() throws IOException {
			if (tk.hasMoreTokens())
				return (tk.nextToken().charAt(0));
			tk = new StringTokenizer(br.readLine());
			return nextChar();
		}

		public int[] nextIntArray(int n) throws IOException {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n) throws IOException {
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArrayOneBased(int n) throws IOException {
			int a[] = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextLongArrayOneBased(int n) throws IOException {
			long a[] = new long[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextLong();
			return a;
		}


	}

	public static void main(String args[]) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					solve();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();

	}
	static class SegmentTree
	{
		int n;
		long tree[];
		int start[];
		int end[];
		long lazy[];
		public SegmentTree(long a[])
		{
			n=a.length+1;
			tree=new long[4*n+1];
			start=new int[4*n+1];
			end=new int[4*n+1];
			lazy=new long[4*n+1];
			initialize(1,0,n-2,a);
		}
		void initialize(int node,int s,int e,long a[])
		{
			start[node]=s;
			end[node]=e;
			if(s==e)
			{
				tree[node]=a[s];
				return;
			}

			int mid=(s+e)/2;
			initialize(node<<1,s,mid,a);
			initialize((node<<1)|1,mid+1,e,a);
			tree[node]=Math.min(tree[node<<1], tree[(node<<1)|1]);
		}
		void lazyPropagation(int node)
		{
			lazy[node<<1]+=lazy[node];
			lazy[(node<<1)|1]+=lazy[node];
			lazy[node]=0;
		}
		void update(int node)
		{
			long leftValue=tree[node<<1]+lazy[node<<1];
			long rightValue=tree[(node<<1)|1]+lazy[(node<<1)|1];
			tree[node]=Math.min(leftValue,rightValue);
		}
		void incrementRange(int l,int r,long value)
		{
			incrementRange(1,l,r,value);
		}
		void incrementRange(int node,int l,int r,long value)
		{
			if(start[node]>r||end[node]<l)
				return;
			if(start[node]>=l&&end[node]<=r)
			{
				lazy[node]+=value;
				return;
			}
			lazyPropagation(node);
			incrementRange(node<<1,l,r,value);
			incrementRange((node<<1)|1,l,r,value);
			update(node);

		}
		int query()
		{
			return query(1);
		}
		int query(int node)
		{
			if(tree[node]+lazy[node]!=0)
				return -1;
			if(start[node]==end[node])
				return start[node];
			lazyPropagation(node);
			update(node);
			int rightValue=query((node<<1)|1);
			if(rightValue!=-1)
				return rightValue;
			return query(node<<1);
		}
	}
	static void solve() throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=in.nextInt();
		long p[]=in.nextLongArray(n);
		SegmentTree st=new SegmentTree(p);
		int a[]=new int[n];
		for(int i=1;i<=n;i++){
			int index=st.query();
			a[index]=i;
			if(index!=n-1){
				st.incrementRange(index+1, n-1, -i);
			}
			st.incrementRange(index,index,1000000000000l);
		}
		for(int i=0;i<n;i++){
			out.print(a[i]+" ");
		}
		out.println();
		out.close();

	}
}
