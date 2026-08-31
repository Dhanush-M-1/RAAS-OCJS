import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VentureFD {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int q = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		
		int N = (int) Math.pow(2, Math.ceil(Math.log(n)/Math.log(2)));	//padding
		long[] in = new long[N+1];
		long[] in2 = new long[N+1];
		SegmentTree st = new SegmentTree(in);
		SegmentTree st2 = new SegmentTree(in2);

		
		

		for(int i=0; i<q; i++){
			int t = sc.nextInt();
			
			if(t == 1)
			{
				int d = sc.nextInt();
				int o = sc.nextInt();

//				in[d[p]] = Math.min(o[p],a);
//				in2[d[p]] = Math.min(o[p],b);
				int pa = (int)st.query(d, d);
				int pb = (int)st2.query(d, d);
				
				int pa2 = Math.min(a, pa + o);
				int pb2 = Math.min(b, pb + o);
				
				st.update_point(d, -pa + pa2);
				st2.update_point(d, -pb + pb2);
				

			}
			else
			{
				
				int period = sc.nextInt();
				
				
				long after = st.query(period + k, n);
				long before = st2.query(1, period-1);
//				System.out.println(after+" "+before);
//				int res = st.query(per[p2]+k+1, N) + st2.query(0, per[p2]-1);
				out.println(after+before);
				
			}
		}
		out.flush();
		out.close();
//		for(int i=1; i<n; i++){
//			preCalcD[i] += preCalcD[i-1];
//			preCalcA[i] += preCalcA[i-1];
//		}
//		System.out.println(Arrays.toString(preCalcD));
//		System.out.println(Arrays.toString(preCalcA));
		
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
	static class SegmentTree {		// 1-based DS, OOP
		
		int N; 			//the number of elements in the array as a multipls of 2 (i.e. after padding)
		long[] array, sTree, lazy;
		
		SegmentTree(long[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new long[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new long[N<<1];
			build(1,1,N);
		}
		
		void build(int node, int b, int e)	// O(n)
		{
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				build(node<<1,b,(b+e)/2);
				build((node<<1)+1,(b+e)/2+1,e);
				sTree[node] = sTree[node<<1]+sTree[(node<<1)+1];
			}
		}
		
		
		void update_point(int index, int val)			// O(log n)
		{
			index += N - 1;				
			sTree[index] += val;			
			while(index>1)				
			{
				index >>= 1;
				sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
			}
		}
		
		
		void update_range(int i, int j, int val)		// O(log n) 
		{
			update_range(1,1,N,i,j,val);
		}
		
		void update_range(int node, int b, int e, int i, int j, int val)
		{
			if(i > e || j < b)		
				return;
			if(b >= i && e <= j)		
			{
				sTree[node] += (e-b+1)*val;			
				lazy[node] += val;				
			}							
			else		
			{
				propagate(node, b, e);
				update_range(node<<1,b,(b+e)/2,i,j,val);
				update_range((node<<1)+1,(b+e)/2+1,e,i,j,val);
				sTree[node] = sTree[node<<1] + sTree[(node<<1)+1];		
			}
			
		}
		void propagate(int node, int b, int e)		
		{
			int mid = (b+e)/2;
			lazy[node<<1] += lazy[node];
			lazy[(node<<1)+1] += lazy[node];
			sTree[node<<1] += (mid-b+1)*lazy[node];		
			sTree[(node<<1)+1] += (e-mid)*lazy[node];		
			lazy[node] = 0;
		}
		
		long query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		long query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			propagate(node, b, e);
			return query(node<<1,b,(b+e)/2,i,j) + query((node<<1)+1,(b+e)/2+1,e,i,j);	
					
		}
		
		
	
		
	}
}
