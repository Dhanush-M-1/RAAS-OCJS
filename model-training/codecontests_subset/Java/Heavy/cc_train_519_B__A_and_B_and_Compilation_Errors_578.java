import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)	
    {
    	InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        while(in.hasNext())
        {
        	int n=in.nextInt();
        	int []a=new int[n];
        	for(int i=0;i<n;i++)
        		a[i]=in.nextInt();
        	int []b=new int[n-1];
        	for(int i=0;i<n-1;i++)
        		b[i]=in.nextInt();
        	int []c=new int[n-2];
        	for(int i=0;i<n-2;i++)
        		c[i]=in.nextInt();
        	Arrays.sort(a);
        	Arrays.sort(b);
        	Arrays.sort(c);
        	int i=0, j=0;
        	for(;i<n-1;i++)
        		if(a[i]!=b[i])
        			break;
        	for(;j<n-2;j++)
        		if(b[j]!=c[j])
        			break;
        	out.println(a[i]);
        	out.println(b[j]);
        }
        out.close();
    }
}

class node
{
	int num, step;
	node(){}
	node(int _num, int _step)
	{
		num=_num;
		step=_step;
	}
}

class InputReader
{
    BufferedReader buf;
    StringTokenizer tok;
    InputReader()
    {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext()
    {
        while(tok == null || !tok.hasMoreElements()) 
        {
            try
            {
                tok = new StringTokenizer(buf.readLine());
            } 
            catch(Exception e) 
            {
                return false;
            }
        }
        return true;
    }
    String next()
    {
        if(hasNext()) 
            return tok.nextToken();
        return null;
    }
    int nextInt()
    {
        return Integer.parseInt(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
    BigInteger nextBigInteger()
    {
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal()
    {
        return new BigDecimal(next());
    }
}