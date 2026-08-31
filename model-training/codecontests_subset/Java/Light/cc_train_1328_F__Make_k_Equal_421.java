import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
	static final long mod=998244353;
	public static void main(String[] args) throws Exception
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		int k=in.nextInt();
		long[] freq=new long[(int)1e6+1];
		for(int i=0;i<n;i++)
			freq[in.nextInt()]++;
		long[] arr=new long[(int)1e6+1];
		for(int i=1;i<1e6;i++)
		{
			int j=i;
			long o=0;
			while(j>0)
			{
				j/=2;
				o++;
				if(freq[j]<k)
				{
					long a=Math.min(freq[i],k-freq[j]);
					arr[j]+=a*o;
					freq[j]+=a;
				}
			}
		}
		long ans=arr[0];
		for(int i=0;i<1e6;i++)
			if(freq[i]>=k)
			ans=Math.min(ans,arr[i]);
		pw.print(ans);
		pw.flush();
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

	public String next() throws IOException
	{
	    if(st==null || !st.hasMoreElements())
	    {
	        st=new StringTokenizer(br.readLine());
	    }
	    return st.nextToken();
	}

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}
}