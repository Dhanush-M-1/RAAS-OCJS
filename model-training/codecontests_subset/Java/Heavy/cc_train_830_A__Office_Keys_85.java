import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class round_424_d
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static long[][] dp;
	
	static void shuffle(int[] a)
	{
		for(int i=0;i<a.length;i++)	
		{
			int next=rnd.nextInt(a.length);
			
			int temp=a[i];a[i]=a[next];a[next]=temp;
		}
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt(),k=sc.nextInt();long p=sc.nextLong();
		
		int[] a=new int[n+1],b=new int[k+1];
		
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		shuffle(a);Arrays.sort(a);
		
		for(int i=1;i<=k;i++)
		{
			b[i]=sc.nextInt();
		}
		
		shuffle(b);Arrays.sort(b);dp=new long[n+1][k+1];
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=k;j++)
			{
				dp[i][j]=Long.MAX_VALUE;
			}
		}
		
		
		for(int i=1;i<=k;i++)
		{
			dp[1][i]=Math.abs(a[1]-b[i])+Math.abs(b[i]-p);
			
			dp[1][i]=Math.min(dp[1][i],dp[1][i-1]);
		}
		
		for(int i=2;i<=n;i++)
		{
			for(int j=i;j<=k;j++)
			{
				long val1=Math.abs(a[i]-b[j]),val2=Math.abs(b[j]-p);
				
				dp[i][j]=Math.min(dp[i][j-1],Math.max(dp[i-1][j-1],val1+val2));
			}
		}
		
		out.println(dp[n][k]);out.close();
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