import java.util.*;
import java.io.*;
import java.math.*;
public final class Solution 
{
    public static void main(String[] args)
    {
   	 Reader input = new Reader();
     PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
     int n = input.nextInt();
     int[] x = new int[n];
     int[] h = new int[n];
     for(int i = 0 ; i < n ; i++)
     {
    	 x[i] = input.nextInt();
    	 h[i] = input.nextInt();
     }
     if(n == 1)
     {
    	 out.println(1);
    	 out.close();
    	 return;
     }
     int count = 2;
     int before = x[0];
     for(int i = 1 ; i < n - 1 ; i++)
     {
    	 if(x[i] - before > h[i])
    	 {
    		 count++;
    		 before = x[i];
    	 }
    	 else if(x[i+1] - x[i] > h[i])
    	 {
    		 count++;
    		 before = x[i] + h[i];
    	 }
    	 else
    		 before = x[i];
     }
     out.println(count);
	 out.close();	 
    }  
    public static int z(int n)
    {
    	/*finds the number of trailing zeros in factorial */
    	int count = 0;
    	for(int i = 5 ; i <= n ; i *= 5)
    	{
    		count += n / i;
    	}
    	return count;
    }
    public static int gcd(int a , int b)
    {
    	if(b == 0)
    		return a;
    	return gcd(b , a %b);
    }
    public static class UnionFind
    {
    	/* this class uses zeroIndexing and gives the result back in zero indexing*/
    	int[] parent;
    	int[] size;
    	int maxSize = 0;
    	public UnionFind(int n)
    	{
    		size = new int[n];
    		parent = new int[n];
    		for(int i = 0 ; i < n ; i++)
    		{
    			parent[i] = i;
    			size[i] = 1;
    		}
    		maxSize = 1;
    	}
    	public int find(int pos)
    	{
    		if(parent[pos] == pos)
    			return pos;
    		return parent[pos] = find(parent[pos]);
    	}
    	public void unify(int x , int y)
    	{
    		int xParent = find(x);
    		int yParent = find(y);
    		if(xParent == yParent)
    			return;
    		else if(size[xParent] > size[yParent]) 
    		{
    			size[xParent] += size[yParent];
    			if(size[xParent] > maxSize)
    				maxSize = size[xParent];
    			parent[yParent] = xParent;
    		}
    		else
    		{
    			size[yParent] += size[xParent];
    			if(size[yParent] > maxSize)
    				maxSize = size[yParent];
    			parent[xParent] = yParent;
    		}
    	}
    	public int maxSize()
    	{
    		return maxSize;
    	}
    }
    public static class Pair implements Comparable<Pair>
    {
    	int a ,  b;
    	public Pair(int a , int b)
    	{
    		this.a = a;
    		this.b = b;
    	}
		@Override
		public int compareTo(Pair t) {
			// TODO Auto-generated method stub
    		if(t.a == this.a)
    		{
    			if(this.b < t.b)
    				return -1;
    			else if(this.b > t.b)
    				return 1;
    			else
    				return 0;
    		}
    		else if(this.a < t.a)
    			return -1;
    		else
    			return 1;
		}
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