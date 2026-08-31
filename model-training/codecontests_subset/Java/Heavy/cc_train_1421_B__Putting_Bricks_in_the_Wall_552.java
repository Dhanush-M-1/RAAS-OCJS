import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class _practise {
	
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

		 int[] ia(int n)
		{
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=nextInt();
			return a;
		}
		 int[][] ia(int n , int m)
			{
				int a[][]=new int[n][m];
				for(int i=0;i<n;i++) for(int j=0;j<n ;j++) a[i][j]=nextInt();
				return a;
			}
		 char[][] ca(int n , int m)
			{
				char a[][]=new char[n][m];
				for(int i=0;i<n;i++)
					{
					String x =next();
					for(int j=0;j<n ;j++) a[i][j]=x.charAt(j);
					}
				return a;
			}

		long[] la(int n)
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
	public static long sum(long a[])
	{long sum=0; for(long i : a) sum+=i; return(sum);}
	public static int sum(int a[])
	{ int sum=0; for(int i : a) sum+=i; return(sum);}
	public static boolean prime(int n)
	{for(int i=2 ; i<=Math.sqrt(n) ; i++) if(n%i==0) return false; return true;}
	public static void main(String args[])
	{

		FastReader in=new FastReader();
		PrintWriter so = new PrintWriter(new BufferedWriter(new  OutputStreamWriter(System.out)));
		_practise ob = new _practise();
		int t = in.nextInt();
	    //int t = 1;
		while(t-->0)
		{
			  int n = in.nextInt();
			  int a[][]=new int[n][n];
			  for(int i=0 ; i<n ; i++)
			  {
				  String s=in.next();
				  for(int j=0 ; j<n ; j++)
				  {
					  if(s.charAt(j)=='0') a[i][j]=0;
					  else a[i][j]=1;
				  }
			  }
			  if((a[0][1]==0 && a[1][0]==0 && a[n-1][n-2]==1 && a[n-2][n-1]==1)||
					  (a[0][1]==1 && a[1][0]==1 && a[n-1][n-2]==0 && a[n-2][n-1]==0))
				  so.println(0);
			  else if(a[0][1]==0 && a[1][0]==0)
			  {
				  if(a[n-1][n-2]==0 && a[n-2][n-1]==0)
				  {
					  so.println(2);
				      so.println("1 2\n2 1");
				  }
				  else if(a[n-1][n-2]==0 && a[n-2][n-1]==1)
				  {
					  so.println(1);
				      so.println(n+" "+(n-1));
				  }
				  else
				  {
					  so.println(1);
				      so.println(n-1+" "+(n));
				  }
			  }
			  else if(a[0][1]==1 && a[1][0]==1)
			  {
				  if(a[n-1][n-2]==1 && a[n-2][n-1]==1)
				  {
					  so.println(2);
				      so.println("1 2\n2 1");
				  }
				  else if(a[n-1][n-2]==1 && a[n-2][n-1]==0)
				  {
					  so.println(1);
				      so.println(n+" "+(n-1));
				  }
				  else
				  {
					  so.println(1);
				      so.println(n-1+" "+(n));
				  }
			  }
			  else
			  {
				  if(a[n-1][n-2]==a[n-2][n-1])
				  {
					  so.println(1);
					  if(a[0][1]!=a[n-1][n-2])
						  so.println("2 1");
					  else
						  so.println("1 2");
				  }
				  else
				  {
					  so.println(2);
					  if(a[0][1]!=a[n-1][n-2])
						  so.println("1 2\n"+(n)+" "+(n-1));
					  else
						  so.println("1 2\n"+(n-1)+" "+(n));
				  }
			  }
				  
		}
		
		
		so.flush();

		/*String s = in.next();
		 * Arrays.stream(f).min().getAsInt()
		 * BigInteger f = new BigInteger("1"); 1 ke jagah koi bhi value ho skta jo aap 
		 *                                       initial value banan chahte
			int a[] = new int[n];
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			ArrayList<Integer> al = new ArrayList<Integer>(); 
			StringBuilder sb = new StringBuilder();
			Set<Long> a = new HashSet<Long>();
			Map<Long,Integer> hm = new HashMap<Long, Integer>(); //<key,value>
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
			so.println("HELLO");*/
	}
}