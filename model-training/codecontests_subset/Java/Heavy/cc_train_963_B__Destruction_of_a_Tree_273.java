import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		work();
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return a==0?b:b>=a?gcd(b%a,a):gcd(b,a);
	}
	int[] count;
	ArrayList<Integer>[] graph;
	void work() {
		int n=in.nextInt();
		if(n%2==0) {
			out.println("NO");
			return;
		}else {
			out.println("YES");
		}
		count=new int[n];
		graph=(ArrayList<Integer>[])new ArrayList[n];
		for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int s=in.nextInt()-1;
			if(s==-1)continue;
			graph[s].add(i);
			graph[i].add(s);
		}
		dfs1(0,new boolean[n]);
		dfs2(0,new boolean[n]);
	}
	private void dfs2(int node, boolean[] vis) {
		vis[node]=true;
		for(int nn:graph[node]) {
			if(!vis[nn]&&count[nn]%2==0) {
				dfs2(nn,vis);
			}
		}
		out.println(node+1);
		for(int nn:graph[node]) {
			if(!vis[nn]&&count[nn]%2==1) {
				dfs2(nn,vis);
			}
		}
	}
	private int dfs1(int node, boolean[] vis) {
		vis[node]=true;
		int cnt=1;
		for(int nn:graph[node]) {
			if(!vis[nn]) {
				cnt+=dfs1(nn,vis);
			}
		}
		count[node]=cnt;
		return cnt;
	}
}	



class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}


	public String next() 
	{
		while(st==null || !st.hasMoreElements())//回车，空行情况
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}