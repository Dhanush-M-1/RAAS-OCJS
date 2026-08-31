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
		return b==0?a:gcd(b,a%b);
	}
	int[] id;
	ArrayList<Integer>[] rec;
	void work() {
		int n=in.nextInt();
		int m=in.nextInt();
		int q=in.nextInt();
		id=new int[m];
		for(int i=0;i<m;i++)id[i]=i;
		rec=(ArrayList<Integer>[])new ArrayList[n];
		for(int i=0;i<n;i++)rec[i]=new ArrayList<>();
		int c1=0,c2=0;
		boolean[] col=new boolean[m];
		for(int i=0;i<q;i++) {
			int r=in.nextInt()-1;
			int c=in.nextInt()-1;
			rec[r].add(c);
			if(rec[r].size()==1)c1++;
			col[c]=true;
		}
		for(int i=0;i<m;i++) {
			if(col[i])c2++;
		}
		for(int i=0;i<n;i++) {
			for(int j=1;j<rec[i].size();j++) {
				union(rec[i].get(j),rec[i].get(j-1));
			}
		}
		int cnt=0;
		for(int i=0;i<m;i++) {
			if(id[i]==i&&col[i])cnt++;
		}
		out.println(n-c1+m-c2+cnt-1);
	}
	private void union(int p, int q) {
		int proot=find(p);
		int qroot=find(q);
		id[proot]=qroot;
	}
	private int find(int p) {
		if(id[p]!=p) {
			id[p]=find(id[p]);
		}
		return id[p];
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