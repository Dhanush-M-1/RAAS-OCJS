import java.io.*;
import java.lang.Math;
import java.util.*;

public class Main
{	
	public BufferedReader in;
	public PrintStream out;
	
	static int[] primes;
	static int p_count;

	public static void get_primes(int n)
	{
		primes = new int[230000];
		
		boolean[] v = new boolean[n+1];
		int i,j;
		for (i=2; i<=n;i++)
		{
			v[i] = true;
		}
		
		for (i=2; i*i<=n;i++)
		{
			if (v[i])
			{
				for (j=i; i*j<=n; j++)
				{
					v[i*j]=false;
				}
			}
		}
		
		p_count = 0;
		for (i=2; i<=n; i++)
		{
			if (v[i])
			{			
				primes[p_count++] = i;
			}
		}
	}
	
	public void test()
	{
		long q = readLong();
		
		get_primes( (int)Math.round(Math.sqrt(q)) +1 );
		
		long x = q;		
		long first = 0, last = 0;
		
		for (int i=0; i<p_count; i++)
		{
			if (x % primes[i] == 0)
			{
				if (first>0)
				{
					last = primes[i];
					break;
				}
				else
				{
					first = primes[i];
					x = x / primes[i];
					if (x % primes[i] == 0)
					{
						last = primes[i];
						break;
					}
				}
			}
			
			if (x==1)
			{
				break;
			}
		}
		
		if (last == 0)
		{
			last = x;
		}
		
		if ((first == 0)||(first == q))
		{
			out.println(1);
			out.println(0);
			return;
		}
		
		if (last * first == q)
		{
			out.println(2);
			return;
		}
		
		out.println(1);
		out.println(last*first);
	}
    
	public void run()
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(System.in));
			out = System.out;
			
			//in = new BufferedReader(new FileReader("in.txt"));
			//out = new PrintStream(new File("out.txt"));
			
			
		}
		catch (Exception e)
		{
			return;
		}
		
		//while (true)
		{
			//int t = readInt(); for (int i=0; i<t; i++)					
			{
				test();
			}
		}
	}
	
	public static void main(String args[])
	{
		new Main().run();
	}
	
	private StringTokenizer tokenizer = null;
	
	public int readInt() 
	{
        return Integer.parseInt(readToken());
    }
   
    public long readLong() 
	{
        return Long.parseLong(readToken());
    }
   
    public double readDouble() 
	{
        return Double.parseDouble(readToken());
    }
   
	public String readLn()
	{	
		try
		{
			String s;
			while ((s = in.readLine()).length()==0);
			return s;
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
    public String readToken() 
	{
		try
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				tokenizer = new StringTokenizer(in.readLine());
			}
			return tokenizer.nextToken();
		}
		catch (Exception e)
		{
			return "";
		}
    }
	
	public int[] readIntArray(int n)
	{
		int[] x = new int[n];
		readIntArray(x, n);
		return x;
	}
	
	public void readIntArray(int[] x, int n)
	{
		for (int i=0; i<n; i++)
		{
			x[i] = readInt();
		}
	}
}

