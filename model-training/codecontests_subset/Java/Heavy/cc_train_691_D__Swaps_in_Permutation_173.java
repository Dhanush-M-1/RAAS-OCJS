import java.io.*;
import java.util.*;

public class ProD {
	static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static int nextInt() throws IOException    
	{  
	    in.nextToken();    
	    return (int)in.nval;     
	}
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
	static int n,m,ee,a,b,pos;
	static int[] mm=new int[1000005];
	static int[] aa=new int[1000005];
	static int[] bb=new int[1000005];
	static int[] vis=new int[1000005];
	static int[] ans=new int[1000005];
	static int[] head=new int[1000005];
	static int[] edge=new int[2000005];
	static int[] next=new int[2000005];
	static void add(int a,int b)
	{
		edge[ee]=b;next[ee]=head[a];
		head[a]=ee++;
	}
	static void dfs(int u)
	{
		vis[u]=1;aa[pos]=u;bb[pos++]=mm[u];
		for(int i=head[u];i!=-1;i=next[i])
		{
			int v=edge[i];
			if(vis[v]==0) dfs(v);
		}
	}

	public static void main(String[] args) throws IOException {
		//Scanner in=new Scanner(System.in);
		n=nextInt();m=nextInt();
		for(int i=1;i<=n;i++)
			mm[i]=nextInt();
		Arrays.fill(head,-1);ee=0;
		for(int i=1;i<=m;i++)
		{
			a=nextInt();b=nextInt();
			add(a,b);add(b,a);
		}
		for(int i=1;i<=n;i++)
		{
			if(vis[i]==1) continue;
			pos=0;dfs(i);
			Arrays.sort(aa,0,pos);
			Arrays.sort(bb,0,pos);
			for(int k=0;k<pos;k++)
				ans[aa[k]]=bb[pos-1-k];
		}
		for(int i=1;i<=n;i++)
			out.print(ans[i]+" ");
		out.flush();
	}
}
