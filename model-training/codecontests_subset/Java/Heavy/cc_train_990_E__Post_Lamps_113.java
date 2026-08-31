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
	long mod=998244353;
	long gcd(long a,long b) {
		return a==0?b:gcd(b%a,a);
	}
	void work() {
		int n=ni(),m=ni(),k=ni();
		boolean[] A=new boolean[n];
		for(int i=0;i<m;i++) {
			A[in.nextInt()]=true;
		}
		long[] cost=na(k);
		if(A[0]) {
			out.println(-1);
			return;
		}
		int[] rec=new int[n];
		for(int i=0;i<n;i++) {
			if(A[i]) {
				rec[i]=rec[i-1];
			}else {
				rec[i]=i;
			}
		}
		long ret=-1;
		out:
		for(int i=1;i<=k;i++) {
			long c=cost[i-1];
			long cnt=0;
			for(int j=0;j<n;) {
				int s=rec[j];
				int e=s+i;
				if(e<=j) {
					continue out;
				}
				j=e;
				cnt+=cost[i-1];
			}
			if(ret==-1||ret>cnt) {
				ret=cnt;
			}
		}
		out.println(ret);
	}
	
	
	private int search(ArrayList<Integer> list, int v) {
		int l=0,r=list.size();
		while(l<r) {
			int m=(l+r)/2;
			if(list.get(m)<=v) {
				l=m+1;
			}else {
				r=m;
			}
		}
		return list.get(l-1);
	}
	//input
	private ArrayList<Integer>[] ng(int n, int m) {
		ArrayList<Integer>[] graph=(ArrayList<Integer>[])new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=1;i<=m;i++) {
			int s=in.nextInt()-1,e=in.nextInt()-1;
			graph[s].add(e);
			graph[e].add(s);
		}
		return graph;
	}
	
	private ArrayList<long[]>[] ngw(int n, int m) {
		ArrayList<long[]>[] graph=(ArrayList<long[]>[])new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=1;i<=m;i++) {
			long s=in.nextLong()-1,e=in.nextLong()-1,w=in.nextLong();
			graph[(int)s].add(new long[] {e,w});
			graph[(int)e].add(new long[] {s,w});
		}
		return graph;
	}

	private int ni() {
		return in.nextInt();
	}

	private long nl() {
		return in.nextLong();
	}

	private long[] na(int n) {
		long[] A=new long[n];
		for(int i=0;i<n;i++) {
			A[i]=in.nextLong();
		}
		return A;
	}
	private int[] nia(int n) {
		int[] A=new int[n];
		for(int i=0;i<n;i++) {
			A[i]=in.nextInt();
		}
		return A;
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