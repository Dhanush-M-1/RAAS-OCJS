import java.io.*;
import java.util.*;
public final class jehayun_and_books
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static TreeSet<Integer> ts=new TreeSet<>();
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt(),m=sc.nextInt();int[] a=new int[n+1],pos=new int[n+1],val=new int[m+1];
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextInt();ts.add(i);pos[i]=-1;
		}
		for(int i=1;i<=m;i++)
		{
			int curr=sc.nextInt();val[i]=curr;
			if(pos[curr]==-1)
			{
				pos[curr]=ts.first();ts.remove(pos[curr]);
			}
		}
		for(int i=1;i<=n;i++)
		{
			if(pos[i]==-1)
			{
				pos[i]=ts.first();ts.remove(pos[i]);
			}
		}
		long ans=0;
		for(int i=1;i<=m;i++)
		{
			int curr=val[i],curr_pos=pos[val[i]];long now=0;
			for(int j=1;j<=n;j++)
			{
				if(pos[j]<curr_pos)
				{
					now+=a[j];pos[j]++;
				}
			}
			pos[val[i]]=1;ans+=now;
		}
		out.println(ans);out.close();
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