import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class CandidateCode 
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
	static PrintWriter pw= new PrintWriter(System.out);
	
	public static void main(String args[])throws Exception
	{
		int n=sc.nextInt();
		int a[]=new int[n];
		int val=0;
		int set[]=new int[n];
		for(int i=0;i<n;i++)
		{
			int b=sc.nextInt();
			int d=sc.nextInt();
			set[i]=d;
			a[i]=b;
		}
		for(int i=0;i<n;i++)
		{
			int count=0;
			int k=a[i];
			for(int it=0;it<n;it++)
			{
				if(set[it]==k)
					count++;
			}
			val+=(count);
		}
		pw.println(val);
       pw.close();     
	}
	
}
	
	





//Input and Output
	
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in)
    {
        this.in = in;
    }
    public String nextToken() throws Exception
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
   	public String next() throws Exception
	{
		return nextToken().toString();
	}
    public int nextInt() throws Exception
    {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws Exception 
    {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws Exception 
    {
        return Double.parseDouble(nextToken());
    }
}