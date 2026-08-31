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
	long mod=998244353L;
	int n;
	long[] tree;
	void work() {
		n=in.nextInt();
		long[] Q=new long[n];
		for(int i=0;i<n;i++) Q[i]=in.nextLong();
		long[] ret=new long[n];
		tree=new long[4*n];
		build(1,n,1);
		for(int i=n-1;i>=0;i--) {
			long num=query(1,n,1,0,Q[i]);
			ret[i]=num;
		}
		for(int i=0;i<n;i++) {
			out.print(ret[i]+" ");
		}
	}
	private long query(long l, long r,int index,long sum,long v) {
		// TODO Auto-generated method stub
		long m=(l+r)/2;
		if(l==r) {
			tree[index]=0;
			return l;
		}
		if(sum+tree[index<<1]<=v) {
			long ret=query(m+1,r,(index<<1)+1,sum+tree[index<<1],v);
			tree[index]-=ret;
			return ret;
		}else {
			long ret=query(l,m,index<<1,sum,v);
			tree[index]-=ret;
			return ret;
		}
	}
	private long build(int l, int r,int index) {
		if(l==r) {
			tree[index]=l;
			return l;
		}
		int m=(l+r)/2;
		tree[index]=build(l,m,index<<1)+build(m+1,r,(index<<1)+1);
		return tree[index];
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