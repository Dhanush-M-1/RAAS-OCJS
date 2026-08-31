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
	int[] count;
	void work() {
		int n=in.nextInt();
		int m=in.nextInt();
		HashSet<Integer>[] rec=(HashSet<Integer>[])new HashSet[n];
		TreeSet<Integer> set=new TreeSet<>();
		for(int i=0;i<n;i++) {
			set.add(i);
			rec[i]=new HashSet<>();
		}
		for(int i=0;i<m;i++) {
			int s=in.nextInt()-1;
			int e=in.nextInt()-1;
			rec[s].add(e);
			rec[e].add(s);
		}
		
		boolean[] vis=new boolean[n];
		ArrayList<Integer> ret=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(!vis[i]) {
				int cnt=0;
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				queue.add(i);
				set.remove(i);
				while(queue.size()>0) {
					int q=queue.poll();
					cnt++;
					vis[q]=true;
					ArrayList<Integer> list=new ArrayList<>();
					for(int s:set) {
						if(!rec[q].contains(s)) {
							list.add(s);
							queue.add(s);
						}
					}
					for(int l:list)set.remove(l);
				}
				ret.add(cnt);
			}
			
		}
		Collections.sort(ret);
		out.println(ret.size());
		for(int r:ret)out.print(r+" ");
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