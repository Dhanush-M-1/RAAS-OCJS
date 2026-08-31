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
	void work() {
		int n=in.nextInt();
		int m=in.nextInt();
		HashSet[] rec=(HashSet<Integer>[])new HashSet[n];
		int[] A=new int[n];
		for(int i=0;i<n;i++)rec[i]=new HashSet<>();
		for(int i=0;i<n;i++)A[i]=in.nextInt()-1;
		for(int i=0;i<m;i++) {
			int s=in.nextInt()-1;
			int e=in.nextInt()-1;
			rec[s].add(e);
		}
		int ret=0;
		ArrayList<Integer> list=new ArrayList<>();
		list.add(A[n-1]);
		out:
		for(int i=n-2;i>=0;i--) {
			int nn=A[i];
			for(int node:list) {
				if(!rec[nn].contains(node)) {
					list.add(nn);
					continue out;
				}
			}
			ret++;
		}
		out.println(ret);
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