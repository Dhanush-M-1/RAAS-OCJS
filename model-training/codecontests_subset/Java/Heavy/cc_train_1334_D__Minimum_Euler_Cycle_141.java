import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		for(int q=ni();q>0;q--) {
			work();
			out.println();
		}
		out.flush();
	}
	long mod=998244353L;
	long inf=Long.MAX_VALUE;
	long gcd(long a,long b) {
		return a==0?b:gcd(b%a,a);
	}
	void work() {
		long n=nl(),l=nl(),r=nl();
		long c=1;
		long sum=0;
		while(sum+(n-c)*2<l&&c<n) {
			sum+=(n-c)*2;
			c++;
		}
//		System.out.println(c);
		long c2=(l+1-sum)/2+c;
		if((l-sum)%2==0) {
			out.print(c2+" ");
			l++;
			c2++;
			if(c2>n) {
				c++;
				c2=c+1;
			}
		}
		while(l<=Math.min(n*(n-1), r)) {
			out.print(c+" ");
			l++;
			if(l>r)break;
			out.print(c2+" ");
			c2++;
			if(c2>n) {
				c++;
				c2=c+1;
			}
			l++;
		}
		if(l<=r) {
			out.print(1+" ");
		}
	}
	



	//input
	@SuppressWarnings("unused")
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
			graph[(int)s].add(new long[] {e,w,i});
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
	
	private String ns() {
		return in.next();
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
