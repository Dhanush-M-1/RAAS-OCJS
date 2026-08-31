
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Main implements Runnable
{
	public static void main(String [] args) throws IOException
	{
		new Thread(null, new Main(), "", 1 << 20).start();
	}
	
	public void run() 
	{
		try
		{
			solve();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	String file = "input";
	BufferedReader input;

	void solve() throws IOException
	{
		//input = new BufferedReader(new FileReader(file + ".in"));
	    input = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = tokens();
	    int op = nextInt(st), m = nextInt(st);
	    int[] a = new int[m];
	    int cur = 1;
	    ArrayList<Entry> list = new ArrayList<Entry>();
	    for(int k = 0; k < op; k++)
	    {
	    	String[] s = input.readLine().split(" ");
	    	if(s.length == 1)
	    	{
	    		int p = 0;
	    		for(Entry e : list)
	    			if(e.pos != p)
	    			{
	    				e.pos = p;
	    				p = p + e.len;
	    			}		
	    			else p = p + e.len;
	    	}
	    	else
	    	{
	    		if(s[0].charAt(0) == 'a')
	    		{
	    			int n = Integer.parseInt(s[1]);
	    			boolean ok = false;
	    			int p = 0;
	    			for(int i = 0; i < list.size(); i++)
	    			{
	    				Entry e = list.get(i);
	    				if(e.pos - p >= n)
	    				{
	    					ok = true;
	    					list.add(i, new Entry(cur, n, p));
	    					System.out.println(cur++);
	    					break;
	    				}
	    				else
	    				{
	    					p = e.pos + e.len;
	    				}
	    			}
	    			if(!ok)
	    			{
	    				if(m - p >= n)
	    				{
	    					list.add(new Entry(cur, n, p));
	    					System.out.println(cur++);
	    				}
	    				else
	    					System.out.println("NULL");
	    			}
	    		}
	    		else
	    		{
	    			int n = Integer.parseInt(s[1]);
	    			boolean ok = false;
	    			for(int i = 0; i < list.size(); i++)
	    			{
	    				Entry e = list.get(i);
	    				if(e.n == n)
	    				{
	    					list.remove(i);
	    					ok = true;
	    					break;
	    				}
	    			}
	    			if(!ok) System.out.println("ILLEGAL_ERASE_ARGUMENT");
	    		}
	    	}
	    	//print(s[0] + " " + list);
	    }
	  
	}
	class Entry
	{
		int n, len, pos;
		public Entry(int n, int len, int pos)
		{
			this.n = n;
			this.len = len;
			this.pos = pos;
		}
		public String toString()
		{
			return n + " " + len + " " + pos;
		}
	}

	StringTokenizer tokens() throws IOException
	{
		return new StringTokenizer(input.readLine());
	}
	
	String next(StringTokenizer st)
	{
		return st.nextToken();
	}
	
	int nextInt() throws IOException
	{
		return Integer.parseInt(input.readLine());
	}
	
	int nextInt(StringTokenizer st)
	{
		return Integer.parseInt(st.nextToken());
	}
	
	double nextDouble() throws IOException
	{
		return Double.parseDouble(input.readLine());
	}
	
	double nextDouble(StringTokenizer st)
	{
		return Double.parseDouble(st.nextToken());
	}
	
	void print(Object... o)
	{
		System.out.println(deepToString(o));
	}
}