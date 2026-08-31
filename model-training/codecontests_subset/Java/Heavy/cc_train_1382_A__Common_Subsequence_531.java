import java.util.*;
import java.io.*;
import java.text.*;
public class comp
{
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
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


	
	public static void main(String[] args) throws Exception {
		FastReader sc=new FastReader();
		PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
		
		int t=sc.nextInt();
		int hh=0;
		
		while(hh++<t)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			int arr[]=new int[1001];
			int i;
			for(i=0; i<n; i++)
			{
				int x=sc.nextInt();
				arr[x]++;
			}
			boolean flag=false;
			int res=-1;
			for(i=0; i<m; i++)
			{
				int x=sc.nextInt();
				if(arr[x]!=0 &&!flag)
				{
					flag=true;
					res=x;
				}
			}
			if(flag){
				out.println("YES");
				out.println(1+" "+res);
			}
			else
			{
				out.println("NO");
			}
		}
		

		out.flush();
	}
}
