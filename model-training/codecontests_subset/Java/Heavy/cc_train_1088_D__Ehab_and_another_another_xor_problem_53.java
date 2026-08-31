import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
    static final long mod=1000000007;
    public static void main(String[] args) throws Exception
    {
    	FastReader in=new FastReader();
    	PrintWriter pw=new PrintWriter(System.out);
    	pw.println("? 0 0");
    	pw.flush();
    	int c=in.nextInt(),a=0,b=0;
    	for(int i=29;i>=0;i--)
    	{
    		int abit=a|(1<<i);
    		pw.println("? "+abit+" "+b);
    		pw.flush();
    		abit=in.nextInt();
    		int bbit=b|(1<<i);
    		pw.println("? "+a+" "+bbit);
    		pw.flush();
    		bbit=in.nextInt();
    		if(abit==bbit)
    		{
    			if(c==1)
    				a|=1<<i;
    			else if(c == -1) b|=1<<i;
    			c=abit;
    		}
    		else if(abit==-1)
    		{
    			a|=1<<i;
    			b|=1<<i;
    		}
    	}
    	pw.println("! "+a+" "+b);
    	pw.flush();
    }

}

class pair<A,B>
{
    A f;
    B s;

    public pair(A a,B b)
    {
        f=a;
        s=b;
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