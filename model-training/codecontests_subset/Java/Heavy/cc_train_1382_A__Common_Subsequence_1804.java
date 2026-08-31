/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger; 

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
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
				catch (IOException e)
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
    
	
     
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader reader = new FastReader();
		int t = reader.nextInt();
		while(t-->0){
		    int  n = reader.nextInt();
		    int m = reader.nextInt();
		    int a[] = new int[n];
		    int b[] = new int[m];
		    for(int i=0; i<n; i++){
		         a[i] = reader.nextInt();
		    }
		    
		    for(int i=0; i<m; i++){
		         b[i] = reader.nextInt();
		    }
		    int result=0;
		    boolean check=false;
		    for(int i=0; i<n; i++){
		         for(int j=0; j<m; j++){
		              if(a[i]==b[j]){
		                   result = a[i];
		                   check = true;
		                   break;
		              }
		         }
		         if(check)
		         break;
		    }
		    if(check){
		         System.out.println("YES");
		         System.out.println("1" + " " + result);
		         }
		         else
		         System.out.println("NO");
		}
	}
}
