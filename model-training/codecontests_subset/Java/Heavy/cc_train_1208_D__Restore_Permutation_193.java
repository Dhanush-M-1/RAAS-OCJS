import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
 
 
public class  gym{
	static public class SegmentTree {		// 1-based DS, OOP
		
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		pair[] array, sTree;
		
		long[]lazy;
		
		SegmentTree(pair[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new pair[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new long[N<<1];
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
				if(sTree[node<<1].compareTo(sTree[node<<1|1])<=0) {
					sTree[node]=new pair(sTree[node<<1].n,sTree[node<<1].idx);
				}
				else {
					sTree[node]=new pair(sTree[node<<1|1].n,sTree[node<<1|1].idx);
				}	
			}
		}
		
		
		
		void update_range(int i, int j, long val)		// O(log n) 
		{
			update_range(1,1,N,i,j,val);
		}
		
		void update_range(int node, int b, int e, int i, int j, long val)
		{
			if(i > e || j < b)		
				return;
			if(b >= i && e <= j)		
			{
				sTree[node].n += val;			
				lazy[node] += val;				
			}							
			else		
			{
				int mid = b + e >> 1;
				propagate(node, b, mid, e);
				update_range(node<<1,b,mid,i,j,val);
				update_range(node<<1|1,mid+1,e,i,j,val);
				if(sTree[node<<1].compareTo(sTree[node<<1|1])<=0) {
					sTree[node]=new pair(sTree[node<<1].n,sTree[node<<1].idx);
				}
				else {
					sTree[node]=new pair(sTree[node<<1|1].n,sTree[node<<1|1].idx);
				}		
			}
			
		}
		void propagate(int node, int b, int mid, int e)		
		{
			lazy[node<<1] += lazy[node];
			lazy[node<<1|1] += lazy[node];
			sTree[node<<1].n += lazy[node];		
			sTree[node<<1|1].n += lazy[node];		
			lazy[node] = 0;
		}
		
		pair query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		pair query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return inf;		
			if(b>= i && e <= j)
				return sTree[node];
			int mid = b + e >> 1;
			propagate(node, b, mid, e);
			pair q1 = query(node<<1,b,mid,i,j);
			pair q2 = query(node<<1|1,mid+1,e,i,j);
			if(q1.compareTo(q2)<=0) {
				return q1;
			}
			else {
				return q2;
			}		
					
		}
	}
	static pair inf=new pair(100000000000l,100000000);
	static class pair implements Comparable<pair>{
		long n;int idx;
		pair(long x,int y){
			n=x;idx=y;
			
		}
		@Override
		public int compareTo(pair o) {
			if(n!=o.n) {
				if(n>o.n)return 1;
				return -1;
			}
			return idx-o.idx;
		}
		public String toString() {
			return n+" "+idx;
		}
		
	}
	public static void main(String[] args) throws Exception{
    	MScanner sc = new MScanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int n = sc.nextInt();
		int N = 1; while(N < n) N <<= 1; //padding
		pair[] in = new pair[N + 1];
		for(int i = 1; i <= n; i++)
			in[i] = new pair(sc.nextLong(),-i);
		for(int i=n+1;i<=N;i++) {
			in[i]=inf;
		}
        int[]ans=new int[n];
        SegmentTree st=new SegmentTree(in);
        for(int i=1;i<=n;i++) {
        	pair p=st.query(1, n);
        	int indx=-p.idx;
        	//System.out.println(indx+" "+p.n);
        	ans[indx-1]=i;
        	st.update_range(indx, indx, 100000000000l);
        	if(indx!=n) {
        		st.update_range(indx+1, n, -i);
        	}
        	/*if(i==1) {
        		System.out.println(st.query(4, 5));
        		System.out.println(Arrays.toString(st.sTree));
        	}*/
        }
        for(int i:ans)pw.print(i+" ");
        pw.flush();
    }
    static class MScanner {
		StringTokenizer st;
		BufferedReader br;
 
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
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