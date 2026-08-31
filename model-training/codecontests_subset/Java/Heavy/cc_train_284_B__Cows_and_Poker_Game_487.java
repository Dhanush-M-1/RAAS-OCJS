import java.util.*;
import java.io.*;

public class _contest {

	public static void main(String args[])
	{

		FastReader in=new FastReader();
		PrintWriter so = new PrintWriter(new BufferedWriter(new  OutputStreamWriter(System.out)));
		int t =1;
		   while(t-->0)
		   {
		     int n = in.nextInt();
		     String s = in.next();
		     if(s.indexOf("A")<0&&s.indexOf("F")<0)
		       so.println("0");
		     else if(s.indexOf("I")>=0)
		     {
		         int ans=0;
		         for(int i=0 ; i<n ; i++)
		           if(s.charAt(i)=='I')
		            ans++;
		            if(ans==1)
		            so.println("1");
		            else
		         so.println("0");
		     }
		     else
		     {
		          int ans=0;
		         for(int i=0 ; i<n ; i++)
		           if(s.charAt(i)=='A')
		            ans++;
		         so.println(ans);
		     }
			/*String s = in.next();
			int a[] = new int[n];
			ArrayList<Integer> al = new ArrayList<Integer>(); 
			StringBuilder sb = new StringBuilder();
			so.println("HELLO");*/
		}
		so.flush();
	}

	static class FastReader
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
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

		int[] readIntArray(int n)
		{
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=nextInt();
			return a;
		}

		long[] readLongArray(int n)
		{
			long a[]=new long[n];
			for(int i=0;i<n;i++)a[i]=nextLong();
			return a;
		}

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
}