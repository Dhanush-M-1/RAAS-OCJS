import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class Main
{
    static final int mod = (int)1e9+7;
    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int test = in.nextInt();
        
        while(test-- > 0)      //test
        {                            
        	
        	int l=in.nextInt();
        	int r=in.nextInt();
        	int d=in.nextInt();
        	
        	  int res = d<l?d: r+(d-r%d);
        
        	if(d<l)
        	 out.println(d);
        	else
        		out.println((r+d-r%d));
        	



        	
        	
        	
        
        	
        
        	
        	
        	
        }   //test
        out.flush();
    }
}

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException
    {
        if(st == null || !st.hasMoreElements())
        {
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();
    }

    public boolean hasNext() throws IOException
    {
        if(st != null && st.hasMoreElements())
        {
            return true;
        }

        String s = br.readLine();
        if(s == null) {
            return false;
        }

        st = new StringTokenizer(s);

        return st.hasMoreElements();
    }

    public int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException
    {
        return br.readLine();
    }
}