

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class N149C {
	static PrintWriter out;
	static Scanner sc;
	static ArrayList<Integer>q,w;
	static ArrayList<Integer>adj[];
	static HashSet<Integer>primesH;
	static Boolean dp[][][];
	//static ArrayList<Integer>a;
	static HashSet<Long>h,tmp;
	static boolean[]vis;
	static int[]a,b,c,d,max,dist;
	static int[][]g;
	static long[]l;
	static char[][]mp;
	static int n,m;
	static int[]dx=new int[] {0,0,-1,-1,1,1,-1,1};
	static int[]dy=new int[] {-1,1,1,0,0,-1,-1,1};
	public static void main(String[]args) throws IOException {
		sc=new Scanner(System.in);
		out=new PrintWriter(System.out);
		int x0=ni(),y0=ni(),x1=ni(),y1=ni();
		n=ni();
		TreeSet<Triple>p=new TreeSet();
		TreeMap<Triple, Integer>vis=new TreeMap();
		for(int i=0;i<n;i++) {
			int r=ni(),st=ni(),en=ni();
			for(int j=st;j<=en;j++) {
				p.add(new Triple(r, j, -1));
				vis.put(new Triple(r, j, -1), -1);
			}
		}
		//Set<Pair<Integer,Integer>>vis=new HashSet();
		Queue<Triple>q=new LinkedList<Triple>();;
		q.add(new Triple(x0,y0,-1));
		vis.put(new Triple(x0,y0,-1),0);
		while(!q.isEmpty()) {
			Triple cur=q.remove();
			int x=cur.a,y=cur.b;
			//vis.put(new Triple(x,y,-1),);
			
			for(int i=0;i<8;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
			    Triple t=new Triple(nx,ny,-1);
				if(p.contains(t)) {
					if(vis.get(t)==-1) {
						q.add(t);
						vis.put(t, vis.get(cur)+1);
					}
					
				}
			}
			
		}
		out.println(vis.get(new Triple(x1,y1,-1)));
		out.close();
	}
		
	
	static boolean valid(int i,int j) {
		return i>=1&&i<=(int)1e9&&j>=1&&j<=(int)1e9;
	}
	private static int dfs(int u, int ct) {
		vis[u]=true;
		if(a[u]==1)ct++;
		if(ct>m)return 0;
		//boolean cons=ct==m;
		int ans=0,tmp;
		boolean leaf=true;
		for(int v:adj[u]) {
			if(!vis[v]){
				tmp=a[v]==1?ct:0;
				ans+=dfs(v,tmp);
				leaf=false;
			}
		}
		return leaf?1:ans;
		
	}



	private static void disp(int[] revl) {
		for(int i=0;i<revl.length;i++) {
			out.print(revl[i]+" ");
		}
		out.println();
	}
	  static class Pair<A, B>{
	        public A x; 
	        public B y;
	 
	        Pair(A x, B y){
	            this.x = x;
	            this.y = y;
	        }
	 
	        @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;
	            if (o == null || getClass() != o.getClass()) return false;
	            Pair<?, ?> pair = (Pair<?, ?>) o;
	            if (!x.equals(pair.x)) return false;
	            return y.equals(pair.y);
	        }
	 
	        @Override
	        public int hashCode() {
	            int result = x.hashCode();
	            result = 31 * result + y.hashCode();
	            return result;
	        }
	 
	    }
	static class Triple implements Comparable<Triple>{
		int a,b,c;
		Triple(int a,int b,int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(Triple p) {
			return a!=p.a?a-p.a:b-p.b;
		}
		public String toString() {
			return "("+a+" "+b+")";
		}
	}
	static int ni() throws IOException {
		return sc.nextInt();
	}
	static double nd() throws IOException {
		return sc.nextDouble();
	}
	static long nl() throws IOException {
		return  sc.nextLong();
	}
	static String ns() throws IOException {
		return sc.next();
	}
	static int[] nai(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		return a;
	}
	static long[] nal(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		return a;
	}
	static int[][] nmi(int n,int m) throws IOException{
		int[][]a=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		return a;
	}

	static long[][] nml(int n,int m) throws IOException{
		long[][]a=new long[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextLong();
			}
		}
		return a;
	}
	static void o(String x) {
		out.print(x);
	}
	static void ol(String x) {
		out.println(x);
	}
	static void ol(int x) {
		out.println(x);
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
		public boolean hasNext() {return st.hasMoreTokens();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
			
		public boolean ready() throws IOException {return br.ready(); }
		

	}
}
