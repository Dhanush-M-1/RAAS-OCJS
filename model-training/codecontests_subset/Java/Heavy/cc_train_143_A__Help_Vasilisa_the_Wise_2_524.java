import java.util.*;
import java.io.*;
import java.math.*;
public final class Solution 
{
    public static void main(String[] args) 
    {
        Reader input = new Reader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int r1 = input.nextInt(), r2 = input.nextInt();
        int c1 = input.nextInt(), c2 = input.nextInt();
        int d1 = input.nextInt(), d2 = input.nextInt();
        int a1 = 0 ,a2 = 0 ,a3 = 0 ,a4 = 0;
        boolean check = false;
        for(a1 = 1 ; a1 <= 9 ; a1++)
        {
        	a2 = r1 - a1;
        	if(a2 > 9 || a2 < 1)
        		continue;
        	a3 = c1 - a1;
        	if(a3 > 9 || a3 < 1)
        		continue;
        	a4 = d1 - a1;
        	if(a4 > 9 || a4 < 1)
        		continue;
        	if(a1 == a2 || a1 == a3 || a1 == a4)
        		continue;
        	if(a2 == a3 || a2 == a4)
        		continue;
        	if(a3 == a4)
        		continue;
        	if(a3 + a4 != r2)
        		continue;
        	if(a2 + a4 != c2)
        		continue;
        	if(a2 + a3 != d2)
        		continue;
        	check = true;
        	break;
        }
        if(check)
        	out.println(a1 + " " + a2 +"\n" + a3 + " " + a4);
        else
        	out.println(-1);
        out.close();
    }
    public static class Reader
    {
    	BufferedReader br;
    	StringTokenizer st;
    	public Reader()
    	{
    		br = new BufferedReader(new InputStreamReader(System.in));    		
    	}
    	public String next()
    	{
    		try
    		{
        		if(st == null || !st.hasMoreTokens())
        			st = new StringTokenizer(br.readLine());
    		}
    		catch(IOException ex)
    		{
    			ex.printStackTrace();
    			System.exit(1);
    		}    		
    		return st.nextToken();
    	}
    	public int nextInt()
    	{
    		return Integer.parseInt(next());
    	}
    	public double nextDouble()
    	{
    		return Double.parseDouble(next());
    	}
    	public long nextLong()
    	{
    		return Long.parseLong(next());
    	}
    	public String nextLine()
    	{
    		try
    		{
    			return br.readLine();
    		}
    		catch(IOException ex)
    		{
    			ex.printStackTrace();
    			System.exit(1);
    		}
    		return "";
    	}
    }
}