import java.io.*;
import java.util.*;
public final class factory_repairs
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static Node[] tree;
	static int n,k,a,b,q;
	
	static void build(int node,int s,int e)
	{
		if(s>e)		
		{
			return;
		}
		if(s==e)
		{
			tree[node]=new Node();
		}
		else
		{
			int mid=(s+e)>>1;
			build(node<<1,s,mid);build(node<<1|1,mid+1,e);
			tree[node]=merge(tree[node<<1],tree[node<<1|1]);
		}
	}
	
	static Node merge(Node n1,Node n2)
	{
		Node curr=new Node();
		
		curr.a[0]=n1.a[0]+n2.a[0];curr.a[1]=n1.a[1]+n2.a[1];
		
		return curr;
	}
	
	static void update(int node,int s,int e,int l,int r,int val)
	{
		if(s>e || l>e || r<s)	
		{
			return;
		}
		if(s==e)
		{
			tree[node].a[0]=Math.min(tree[node].a[0]+val,b);tree[node].a[1]=Math.min(a,tree[node].a[1]+val);
		}
		else
		{
			int mid=(s+e)>>1;
			update(node<<1,s,mid,l,r,val);update(node<<1|1,mid+1,e,l,r,val);
			tree[node]=merge(tree[node<<1],tree[node<<1|1]);
		}
	}
	
	static long query(int node,int s,int e,int l,int r,int idx)
	{
		if(s>e || l>e || r<s)
		{
			return 0;
		}
		if(l<=s && r>=e)
		{
			return tree[node].a[idx];
		}
		else
		{
			int mid=(s+e)>>1;
			long val1=query(node<<1,s,mid,l,r,idx),val2=query(node<<1|1,mid+1,e,l,r,idx);
			return (val1+val2);
		}
	}
	
    public static void main(String args[]) throws Exception
    {
		n=sc.nextInt();k=sc.nextInt();a=sc.nextInt();b=sc.nextInt();q=sc.nextInt();tree=new Node[4*n];build(1,0,n-1);
		
		while(q>0)
		{
			int t=sc.nextInt();
			if(t==1)
			{
				int idx=sc.nextInt()-1,val=sc.nextInt();update(1,0,n-1,idx,idx,val);
			}
			else
			{
				int idx=sc.nextInt()-1;out.println(query(1,0,n-1,0,idx-1,0)+query(1,0,n-1,idx+k,n-1,1));
			}
			q--;
		}
		out.close();
    }
}
class Node
{
	long[] a=new long[2];
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