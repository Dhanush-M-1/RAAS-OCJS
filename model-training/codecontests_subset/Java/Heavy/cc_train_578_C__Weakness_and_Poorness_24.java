import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	public static long mod= (long) (1e9 +7);
	static int n;
	static int a[];
	public static void main(String args[])
	{
		InputReader s= new InputReader(System.in);
		OutputStream outputStream= System.out;
		PrintWriter out= new PrintWriter(outputStream);
		n= s.nextInt();
		a = new int[n+1];
		for(int i=1;i<=n;i++)
			a[i]= s.nextInt();
		
		double l=-20000,r=20000;
		double ans = Double.MAX_VALUE;
		
		for(int i=1;i<=100;i++){
			double mid1 = l + (r-l)/(3.0);
			double mid2 = r - (r-l)/(3.0);
			double x = f(mid1);
			double y = f(mid2);
			ans = Math.min(ans, Math.min(x, y));
			if(x<y)
				r = mid2;
			else
				l= mid1;
		}
		out.println(ans);
		out.close();
	}
	static double f(double x){
		
		double max_now=0,max=Double.MIN_VALUE;
		double b[]= new double[n+1];
	//	int ans= Integer.MIN_VALUE;
		
		for(int i=1;i<=n;i++)
			b[i]= a[i]-x;
		
		for(int i=1;i<=n;i++){
			max_now+= b[i];
			if(max_now<0)
				max_now=0;
			max= Math.max(max, max_now);
		}
		for(int i=1;i<=n;i++)
			b[i]= -1*b[i];
		max_now=0;
		for(int i=1;i<=n;i++){
			max_now+= b[i];
			if(max_now<0)
				max_now=0;
			max= Math.max(max, max_now);
		}
		
		return max;
	}
	static long combinations(long n,long r){   // O(r)
		if(r==0 || r==n) return 1;
		r= Math.min(r, n-r);
		long ans=n;  // nC1=n;
		for(int i=1;i<r;i++){
			ans= ans*(n-i);
			ans= ans/(i+1);
		}
		return ans;
		
	}
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	static long modulo(long a,long b,long c) {
		long x=1;
		long y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c; // squaring the base
			b /= 2;
		}
		return  x%c;
	}
	static void catalan_numbers(int n) {
		long catalan[]= new long[n+1];
	    catalan[1] = 1;
	    for (int i = 2; i <= n; i++) {
	        for (int j = 1; j <= i - 1; j++) {
	            catalan[i] = catalan[i] + ((catalan[j]) * catalan[i - j]);
	        }
	    }
	}
	
	static ArrayList<Integer> primeFactors(int n)   // O(sqrt(n))
	{
	    // Print the number of 2s that divide n
		ArrayList<Integer> arr= new ArrayList<>();
	    while (n%2 == 0)
	    {
	        arr.add(2);
	        n = n/2;
	    }
	 
	    // n must be odd at this point.  So we can skip one element (Note i = i +2)
	    for (int i = 3; i <= Math.sqrt(n); i = i+2)
	    {
	        // While i divides n, print i and divide n
	        while (n%i == 0)
	        {
	            arr.add(i);
	            n = n/i;
	        }
	    }
	    // This condition is to handle the case when n is a prime number
	    // greater than 2
	    if (n > 2)
	        arr.add(n);
	    
	    return arr;
	}

	public static int expo(int a, int b){
		if (b==0)
	        return 1;
	    if (b==1)
	        return a;
	    if (b==2)
	        return a*a;

	    if (b%2==0){
	            return expo(expo(a,b/2),2);
	    }
	    else{
	        return a*expo(expo(a,(b-1)/2),2);
	    }
	}
	static class Pair implements Comparable<Pair>
	{
		long f;
		String s;
		Pair(long ii, String cc)
		{
			f=ii;
			s=cc;
		}
		
		public int compareTo(Pair o) 
		{
			return Long.compare(this.f, o.f);
		}
		
	}
	
	public static int[] sieve(int N){    // O(n*log(logn))
		int arr[]= new int[N+1];
		for(int i=2;i<=Math.sqrt(N);i++){
			if(arr[i]==0){
				for(int j= i*i;j<= N;j= j+i){
					arr[j]=1;
				}
			}
		}
		return arr;
		// All the i for which arr[i]==0 are prime numbers.
	}
	static long gcd(long a,long b){       // O(logn)
		if(b==0) return a;
		return gcd(b,a%b);
	}
	static class InputReader {

	    public BufferedReader reader;
	    public StringTokenizer tokenizer;
 
	    public InputReader(InputStream inputstream) {
	      reader = new BufferedReader(new InputStreamReader(inputstream));
	      tokenizer = null;
	    }
	    
	    public String nextLine(){
	    	String fullLine=null;
	    	while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	              fullLine=reader.readLine();
	            } catch (IOException e) {
	              throw new RuntimeException(e);
	            }
	            return fullLine;
	          }
	          return fullLine;
	    }
		public String next() {
	      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	        try {
	          tokenizer = new StringTokenizer(reader.readLine());
	        } catch (IOException e) {
	          throw new RuntimeException(e);
	        }
	      }
	      return tokenizer.nextToken();
	    }
		public long nextLong() {
		      return Long.parseLong(next());
		    }
	    public int nextInt() {
	      return Integer.parseInt(next());
	    }
	  }
}