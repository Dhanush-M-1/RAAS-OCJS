import java.util.*;
import java.io.*;
public class TestClass{
	static PrintWriter out = new PrintWriter(System.out);
	static int v[];
	static ArrayList b;
	static ArrayList d;
	static ArrayList g[];
	static int size=0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1[] = in.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);
		String s2[] = in.readLine().split(" ");
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = Integer.parseInt(s2[i]);
		}
		v = new int[n];
		g = new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			g[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++)
		{
			String s[]= in.readLine().split(" ");
			int u = Integer.parseInt(s[0])-1;
			int v = Integer.parseInt(s[1])-1;
			
			g[u].add(v);
			g[v].add(u);
		}
		int c=0;
		for(int i=0;i<n;i++)
		{
			if(v[i]==0)
			{
				b = new ArrayList();
				d = new ArrayList();
				dfs(i);
				//System.out.println(size);
				/*for(int j=0;j<size;j++)
				{
					System.out.print(b.get(j)+" ");
				}*/
				//System.out.println();
				Collections.sort(b);
				for(int j=0;j<size;j++)
				{
					d.add(a[(int)b.get(j)]);
				}
				Collections.sort(d);
				/*for(int j=0;j<size;j++)
				{
					System.out.print(b.get(j)+" ");
				}*/
				for(int j=size-1;j>=0;j--)
				{
					a[(int)b.get(j)] = (int)d.get(size-1-j);
				}
				size=0;
				
				//c++;
			}
		}
		for(int i=0;i<n;i++)
		{
			out.print(a[i]+" ");
		}
		//out.println(c);
		out.close();
	}
	public static int dfs(int curr)
	{
		//System.out.println(size);
		b.add(curr);
		size++;
		v[curr]=1;
		int i;
		for(i=0;i<g[curr].size();i++)
		{
			int x = (int)g[curr].get(i);
			if(v[x]==0)
			{
				dfs(x);
			}
		}
		return i;
	}
}