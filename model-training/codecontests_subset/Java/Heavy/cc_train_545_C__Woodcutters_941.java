
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import java.util.*;
import java.io.PrintStream;
import java.io.PrintWriter;
 
public class A {
 
	static final int mod = 1000000007;
	static final long MOD = 1000000007;
	static final int temp = 998244353;
	static final long M = (int)1e9+7;
 
	
	static class Pair implements Comparable<Pair>
	{
		int first, second;
		public Pair(int aa, int bb)
		{
			first = aa; second = bb;
		}
		public int compareTo(Pair p)
		{
//			if(a == p.a) return b - p.b;
//			return a - p.a;
			if(first == p.first) return (int)(second - p.second);
			return (int)(first - p.first);
		}
	}
	
	/*
	 * IO FOR 2D GRID IN JAVA
	 * char[][] arr = new char[n][m]; //grid in Q.
			
			for(int i = 0;i<n;i++)
			{
				char[] nowLine = sc.next().toCharArray();
				for(int j = 0;j<m;j++)
				{
					arr[i][j] = nowLine[i];
				}
			}
	 * */
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class Reader {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		
		long[] longReadArray(int n) throws IOException {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	
 
	public static boolean isPrime(long n) {
		if(n == 1)
		{
			return false;
		}
		for(long i = 2;i*i<=n;i++)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static List<Integer> Sieve(int n)
	{
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		List<Integer> l = new ArrayList<>();
		
		
		for (int p=2; p*p<=n; p++) 
		{ 
			if (prime[p] == true) 
			{ 	
			    for(int i=p*p; i<=n; i += p) 
				{
				    prime[i] = false; 
				}	
			} 
		} 
 
		for (int p=2; p<=n; p++) 
		{
		    if (prime[p] == true)
		    {
		       l.add(p); 
		    }
		}
		
		return l;
	}
	
	
	public static int gcd(int a, int b)
	{
		if(b == 0)
		 return a;
		
		else
		return gcd(b,a%b);
	}
	
	public static long LongGCD(long a, long b)
	{
		if(b == 0)
			 return a;
			
			else
			return LongGCD(b,a%b);
	}
 
 
	public static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
	
	public static int phi(int n)  //euler totient function
    { 
        int result = 1; 
        for (int i = 2; i < n; i++) 
            if (gcd(i, n) == 1) 
                result++; 
        return result; 
    }
	
	    
	public static int[] computePrefix(int arr[], int n)
	{
		int[] prefix = new int[n];
		prefix[0] = arr[0];
		for(int i = 1;i<n;i++)
		{
			prefix[i] = prefix[i-1]+arr[i];
		}
		
		return prefix;
	}
	
	
	public static long fastPow(long x, long n) //include mod at each step if asked and in args of fn too
	{
		if(n == 0)
			return 1;
		else if(n%2 == 0)
			return fastPow(x*x,n/2);
		else
			return x*fastPow(x*x,(n-1)/2);
	}
	
	
	   public static long power(long x, long y, long p)
	    {
	 
	        long res = 1;
	 
	        x = x % p;
	 
	        while (y > 0) {
	            if (y % 2 == 1)
	                res = (res * x) % p;
	 
	            y = y >> 1; 
	            x = (x * x) % p;
	        }
	 
	        return res;
	    }
	   
	   static long modInverse(long n, long p)
	    {
	        return power(n, p - 2, p);
	    }
	 
	    // Returns nCr % p using Fermat's little theorem.
	    
	    public static long nCr(long n, long r,
	                             long p)
	    {
	          if (n<r) 
	              return 0;
	          
	        if (r == 0)
	            return 1;
	 
	        long[] fac = new long[(int)(n) + 1];
	        fac[0] = 1;
	 
	        for (int i = 1; i <= n; i++)
	            fac[i] = fac[i - 1] * i % p;
	 
	        return (fac[(int)(n)] * modInverse(fac[(int)(r)], p)
	                % p * modInverse(fac[(int)(n - r)], p)
	                % p)
	            % p;
	    }
	    
	    public static long[] modInvArr(long n, long mod)
	    {
	    	long[] ans = new long[(int)(n)+1];
			ans[1] = 1;
			for(int i = 2;i <= n;i++)
			{
				ans[i] = (mod - (mod/i) * ans[(int)(mod%i)])%mod;
			}
			return ans;
	    }
 
		public static int LowerBound(int a[], int x) {
			  int l=-1,r=a.length;
			  while(l+1<r) {
			    int m=(l+r)>>>1;
			    if(a[m]>=x) r=m;
			    else l=m;
			  }
			  return r;
			}
		
		
		public static int UpperBound(int a[], int x) {
		    int l=-1;
		    int r=a.length;
		    while(l+1<r) {
		       int m=(l+r)>>>1;
		       if(a[m]<=x) l=m;
		       else r=m;
		    }
		    return l+1;
		}
		
		public static void Sort(int[] a) {
			List<Integer> l=new ArrayList<>();
			for (int i:a) l.add(i);
			Collections.sort(l);
			//Collections.reverse(l);  //Use to Sort decreasingly 
			for (int i=0; i<a.length; i++) a[i]=l.get(i);
		}
		
		//MODULO OPS for addition and multiplication 
		
		   public static long perfomMod(long x){
		        return ((x%M + M)%M);
		    }
		   public static long addMod(long a, long  b){
		        return perfomMod(perfomMod(a)+perfomMod(b));
		    }
		   public static long mulMod(long  a, long b){
		        return perfomMod(perfomMod(a)*perfomMod(b));
		   }
	
		
	public static void main(String[] args) throws IOException 
	{
		Reader sc=new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		
		for(int i = 0;i<n;i++)
		{
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		
		long prev = Long.MIN_VALUE;
		
		int c = 0;
		for(int i = 0;i<n;i++)
		{
			if(prev < x[i] - h[i])
			{
				prev =x[i];
				++c;
			}
			else if(i == n-1 || (x[i] + h[i]) < x[i+1])
			{
				prev = x[i] + h[i];
				++c;
			}
			else {
				prev = x[i];
			}
		}
		
		System.out.println(c);
		
		out.close();
	}
 
	
}