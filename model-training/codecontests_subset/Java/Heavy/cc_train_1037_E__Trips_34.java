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
		return b==0?a:gcd(b,a%b);
	}
	Set<Integer>[] graph;
	void work() {
		int n=in.nextInt();
		int m=in.nextInt();
		int k=in.nextInt();
		int[] degree=new int[n];
		int[][] edge=new int[m][2];
		int[] ret=new int[m];
		graph=(Set<Integer>[])new Set[n];
		for(int i=0;i<n;i++)graph[i]=new HashSet<>();
		for(int i=0;i<m;i++) {
			int n1=in.nextInt()-1;
			int n2=in.nextInt()-1;
			edge[i]=new int[] {n1,n2};
			graph[n1].add(n2);
			graph[n2].add(n1);
			degree[n1]++;
			degree[n2]++;
		}
		int cnt=n;
		LinkedList<Integer> queue=new LinkedList<>();
		boolean[] vis=new boolean[n];
		for(int i=0;i<n;i++) {
			if(degree[i]==0)cnt--;
			else if(degree[i]<k) {
				queue.add(i);
				vis[i]=true;
			}
		}
		for(int i=m-1;i>=0;i--) {
			while(queue.size()>0) {
				int node=queue.poll();
				cnt--;
				degree[node]=0;
				for(int nn:graph[node]) {
					if(vis[nn])continue;
					degree[nn]--;
					graph[nn].remove(node);
					if(degree[nn]<k) {
						queue.add(nn);
						vis[nn]=true;
					}
				}
				graph[node]=new HashSet<>();
			}
			ret[i]=cnt;
			int[] e=edge[i];
			if(!graph[e[0]].contains(e[1]))continue;
			degree[e[0]]--;
			if(degree[e[0]]<k) {
				queue.add(e[0]);
				vis[e[0]]=true;
			}
			degree[e[1]]--;
			if(degree[e[1]]<k) {
				queue.add(e[1]);
				vis[e[1]]=true;
			}
			graph[e[0]].remove(e[1]);
			graph[e[1]].remove(e[0]);
		}
		for(int i=0;i<m;i++)out.println(ret[i]);
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
		if(st==null || !st.hasMoreElements())
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