import java.io.*;
import java.util.*;
public class Main
{
	private void solve()throws IOException
	{
		int n=nextInt();
		int m=nextInt();
		Fenwick ans=new Fenwick(m);
		Pair list[]=new Pair[n+1];
		for(int i=1;i<=n;i++)
		{
			int l=nextInt();
			int r=nextInt();
			list[i]=new Pair(l,r);
			ans.update(1,r-l+1,1);
		}
		Arrays.sort(list,1,n+1,new Comparator<Pair>(){
			public int compare(Pair a,Pair b){
				return a.size-b.size;
			}
		});
		Fenwick dp=new Fenwick(m);
		for(int i=1,j=1;i<=m;i++)
		{
			while(j<=n && list[j].size<i)
			{
				dp.update(list[j].l,list[j].r,1);
				j++;
			}
			for(int k=i;k<=m;k+=i)
				ans.update(i,i,dp.read(k));
		}
		for(int i=1;i<=m;i++)
			out.println(ans.read(i));
	}
	class Pair{
	    int l,r,size;
	    Pair(int a,int b){
	        l=a;
	        r=b;
	        size=r-l+1;
	    }
	}
	class Fenwick
	{
		int tree[],n;
		Fenwick(int n)
		{
			tree=new int[n+1];
			this.n=n;
		}
		int read(int i){
			int ret=0;
			while(i>0){
				ret+=tree[i];
				i-=i&(-i);
			}
			return ret;
		}
		
		void update(int i,int diff){
			while(i<=n){
				tree[i]+=diff;
				i+=i&(-i);
			}
		}
		void update(int l,int r,int diff)
		{
			update(l,diff);
			update(r+1,-diff);
		}
	}

	 
	///////////////////////////////////////////////////////////

	public void run()throws IOException
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=null;
		out=new PrintWriter(System.out);

		solve();
		
		br.close();
		out.close();
	}
	public static void main(String args[])throws IOException{
		new Main().run();
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	String nextToken()throws IOException{
		while(st==null || !st.hasMoreTokens())
		st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine()throws IOException{
		return br.readLine();
	}
	int nextInt()throws IOException{
		return Integer.parseInt(nextToken());
	}
	long nextLong()throws IOException{
		return Long.parseLong(nextToken());
	}
	double nextDouble()throws IOException{
		return Double.parseDouble(nextToken());
	}
}