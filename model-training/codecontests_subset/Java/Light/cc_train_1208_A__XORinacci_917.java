import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
	static final long mod=(int)1e9+7;
	public static void main(String[] args) throws Exception
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int test=in.nextInt();
		while(test-->0)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			int n=in.nextInt();
			if(n%3==0)
				pw.println(a);
			else if(n%3==1)
				pw.println(b);
			else
				pw.println(a^b);
		}
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