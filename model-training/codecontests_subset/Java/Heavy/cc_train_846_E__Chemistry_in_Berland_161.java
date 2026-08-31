import java.util.*;
import java.io.*;
public class cf846e {
static long[] a,b;
static ArrayList<pair>[] adj;
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());
		b=new long[n];
		a=new long[n];
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Long.parseLong(st.nextToken());
		}
		int[] deg=new int[n];
		adj=new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			int x1=Integer.parseInt(st.nextToken())-1;
			long k1=Long.parseLong(st.nextToken());
			adj[x1].add(new pair(i,k1));
			deg[i]++;
		}
		double ans=dfs(0);
		if(ans>=0) {
			out.println("YES");
		}
		else {
			out.println("NO");
		}
		out.close();
	}
	static double dfs(int z) {
		double rem=b[z];
		for(pair p:adj[z]) {
			double q=dfs(p.x);
			if(q>=0) rem+=q;
			else rem+=p.k*q;
			if(rem<=Long.MIN_VALUE) return rem;
		}
		rem-=a[z];
		return rem;
	}
	static class pair{
		int x; long k;
		public pair(int a, long b) {
			x=a;k=b;
		}
	}
}
