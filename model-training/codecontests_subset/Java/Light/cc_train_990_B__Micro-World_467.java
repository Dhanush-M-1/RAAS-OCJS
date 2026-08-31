import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class codechef
{
	static long mod=1000000007;
	public static void main(String[] args) throws IOException
	{
		FastReader in=new FastReader();
		int n=in.nextInt();
		int k=in.nextInt();
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		int index=0,ans=n,c=1;
		for(int i=1;i<n;i++)
		{
			if(arr[index].equals(arr[i]))
				c++;
			else if(arr[i].compareTo(arr[index]+k)<=0)
			{
				ans-=c;
				index+=c;
				c=1;
			}
			else
			{
				index+=c;
				c=1;
			}			
		}
		System.out.println(ans);
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
		try
		{
			if(st==null || !st.hasMoreElements())
			{
				st=new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		catch(Exception e)
		{
			return "-";
		}
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