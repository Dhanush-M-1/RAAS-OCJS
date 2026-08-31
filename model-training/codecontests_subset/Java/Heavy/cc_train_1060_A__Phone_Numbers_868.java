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
	static void sort(long[] a) 
	{int n=a.length;Random r=new Random();for (int i=0; i<a.length; i++) {long oi=r.nextInt(n), temp=a[i];a[i]=a[(int)oi];a[(int)oi]=temp;}Arrays.sort(a);}
    static void sort(int[] a) 
    {int n=a.length;Random r=new Random();for (int i=0; i<a.length; i++) {int oi=r.nextInt(n), temp=a[i];a[i]=a[oi];a[oi]=temp;}Arrays.sort(a);}
	public static long sum(long a[])
	{long sum=0; for(long i : a) sum+=i; return(sum);}
	public static long count(long a[] , long x)
	{long c=0; for(long i : a) if(i==x) c++; return(c);}
	public static int sum(int a[])
	{ int sum=0; for(int i : a) sum+=i; return(sum);}
	public static int count(int a[] ,int x)
	{int c=0; for(int i : a) if(i==x) c++; return(c);}
	public static boolean prime(int n)
	{for(int i=2 ; i<=Math.sqrt(n) ; i++) if(n%i==0) return false; return true;}
	public static boolean prime(long n)
	{for(long i=2 ; i<=Math.sqrt(n) ; i++) if(n%i==0) return false; return true;}
	 public static int gcd(int n1, int n2)
	  { if (n2 != 0)return gcd(n2, n1 % n2); else return n1;}
	 public static long gcd(long n1, long n2)
	  { if (n2 != 0)return gcd(n2, n1 % n2); else return n1;}
	 public static int[] freq(int a[], int n)
	  { int f[]=new int[n+1]; for(int i:a) f[i]++; return f;}
	 public static int[] pos(int a[], int n)
	  { int f[]=new int[n+1]; for(int i=0; i<n ;i++) f[a[i]]=i; return f;}
	 
	
	 public static long mindig(long n)
	 {
		 long ans=9; while(n>0) { if(n%10<ans) ans=n%10; n/=10; }
		 return ans;
	 }
	 public static long maxdig(long n)
	 {
		 long ans=0; while(n>0) { if(n%10>ans) ans=n%10; n/=10; }
		 return ans;
	 }
	  
	
	 
	public static void main(String args[])
	{

		FastReader in=new FastReader();
		PrintWriter so = new PrintWriter(new BufferedWriter(new  OutputStreamWriter(System.out)));
		_practise ob = new _practise();
		//int t = in.nextInt();
		int t = 1;
		 
		 while(t-->0)
		 {
           int n = in.nextInt();
           String s = in.next();
           int f[] = new int[10]; for(int i=0 ; i<n ; i++) f[s.charAt(i)-'0']++;
           so.println(Math.min(f[8],n/11));
		 }
		
		
		
		
		so.flush();

		/*String s = in.next();
		 * Arrays.stream(f).min().getAsInt()
		 * BigInteger f = new BigInteger("1"); 1 ke jagah koi bhi value ho skta jo aap 
		 *                                       initial value banan chahte
			int a[] = new int[n];
			 Stack<Integer> stack = new Stack<Integer>();
			 	Deque<Integer> q = new LinkedList<>(); or Deque<Integer> q = new ArrayDeque<Integer>();
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			ArrayList<Integer> al = new ArrayList<Integer>(); 
			StringBuilder sb = new StringBuilder();
			Set<Integer> s = new HashSet<Integer>();
			Map<Long,Integer> hm = new HashMap<Long, Integer>(); //<key,value>
			 for(Map.Entry<Integer, Integer> i :hm.entrySet())
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
			so.println("HELLO");*/
	}
}