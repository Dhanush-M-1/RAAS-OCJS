import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

    public class B {
    	
    	public static void main(String[] args) throws IOException{
     
    		Scanner sc = new Scanner(System.in);
    		PrintWriter out = new PrintWriter(System.out);
    		int n = sc.nextInt(), k = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), q = sc.nextInt();
    		int N = 1; while(N < n) N <<= 1;
    		int[] in = new int[N + 1];
    		SegmentTree optimal = new SegmentTree(in);
    		SegmentTree defect = new SegmentTree(in);
    		for(int i = 0; i < q; i++)
    		{
    			int t = sc.nextInt();
    			if(t == 1)
    			{
    				int d = sc.nextInt(), val = sc.nextInt();
    				optimal.update_point(d, Math.min(val, a), a);
    				defect.update_point(d, Math.min(val, b), b);
    			}
    			else
    			{
    				int p = sc.nextInt();
    				out.println(defect.query(1, p-1) + optimal.query(p + k, n));
    			}
    		}
    		out.flush();
			out.close();
    	}
    	
    	static class SegmentTree {
    		
    		int N; 		
    		int[] array, sTree, lazy;
    		
    		SegmentTree(int[] in)		
    		{
    			array = in; N = in.length - 1;
    			sTree = new int[N<<1];		
    			lazy = new int[N<<1];
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
    		
    		void update_point(int index, int val, int max)			// O(log n)
    		{
    			index += N - 1;				
    			sTree[index] = Math.min(max, sTree[index] + val);			
    			while(index>1)				
    			{
    				index >>= 1;
    				sTree[index] = sTree[index<<1] + sTree[index<<1|1];		
    			}
    		}
    		
    		int query(int i, int j)
    		{
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
    	
    	static class Scanner 
    	{
    		StringTokenizer st;
    		BufferedReader br;
     
    		public Scanner(InputStream System){	br = new BufferedReader(new InputStreamReader(System));	}
    		public String next() throws IOException 
    		{
    			while (st == null || !st.hasMoreTokens()) 
    				st = new StringTokenizer(br.readLine());
    			return st.nextToken();
    		}
    		public String nextLine()throws IOException{return br.readLine();}
    		public int nextInt() throws IOException {return Integer.parseInt(next());}
    		public double nextDouble() throws IOException {return Double.parseDouble(next());}
    		public char nextChar()throws IOException{return next().charAt(0);}
    		public Long nextLong()throws IOException{return Long.parseLong(next());}
    		public boolean ready() throws IOException{return br.ready();}
    		public void waitForInput(){for(long i = 0; i < 3e9; i++);}
    	}
    }