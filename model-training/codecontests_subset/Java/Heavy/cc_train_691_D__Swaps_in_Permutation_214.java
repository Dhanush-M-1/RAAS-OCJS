import java.io.*;
import java.util.*;
public final class swaps
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static ArrayList<Integer>[] al;
	static List<Integer> list1,list2;
	static int[] a,res;
	static int n,m;
	static boolean[] v;
	
	static void dfs(int u)
	{
		v[u]=true;
		list1.add(u);list2.add(a[u]);
		for(int x:al[u])
		{
			if(!v[x])
			{
				dfs(x);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception
	{
		n=sc.nextInt();m=sc.nextInt();a=new int[n];res=new int[n];al=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			al[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			al[u].add(v);
			al[v].add(u);
		}
		v=new boolean[n];
		for(int i=0;i<n;i++)
		{
			if(!v[i])
			{
				list1=new ArrayList<Integer>();list2=new ArrayList<Integer>();
				dfs(i);
				Collections.sort(list1);Collections.sort(list2);
				for(int j=0,k=list2.size();j<list1.size();j++)
				{
					res[list1.get(j)]=list2.get(--k);
				}
			}
		}
		for(int x:res)
		{
			out.print(x+" ");
		}
		out.println("");
		out.close();
	}
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}