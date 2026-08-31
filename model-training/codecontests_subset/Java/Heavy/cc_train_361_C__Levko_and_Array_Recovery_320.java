import java.io.*;
import java.util.*;
public final class levko_and_array_recovery
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt(),q=sc.nextInt();Node[] arr=new Node[q];
		for(int i=0;i<q;i++)
		{
			arr[i]=new Node(sc.nextInt(),sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
		}
		long[] a=new long[n];
		for(int i=0;i<n;i++)
		{
			long high=(long)1e9,curr=0;
			for(int j=0;j<q;j++)
			{
				if(arr[j].b<=i && arr[j].c>=i && arr[j].a==1)
				{
					curr+=arr[j].d;continue;
				}
				if(arr[j].b<=i && arr[j].c>=i)
				{
					long now=arr[j].d-curr;
					if(now<high)
					{
						high=now;
					}
				}
			}
			a[i]=high;
		}
		boolean ans=true;long[] b=a.clone();
		for(int i=0;i<q;i++)
		{
			if(arr[i].a==1)
			{
				for(int j=arr[i].b;j<=arr[i].c;j++)
				{
					a[j]+=arr[i].d;
				}
				continue;
			}
			long max=Long.MIN_VALUE;
			for(int j=arr[i].b;j<=arr[i].c;j++)
			{
				max=Math.max(max,a[j]);
			}
			if(max!=arr[i].d)
			{
				ans=false;break;
			}
		}
		if(ans)
		{
			out.println("YES");
			for(long x:b)
			{
				out.print(x+" ");
			}
			out.println("");out.close();return;
		}
		out.println("NO");out.close();
    }
}
class Node
{
	int a,b,c,d;
	public Node(int a,int b,int c,int d)
	{
		this.a=a;this.b=b;this.c=c;this.d=d;
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