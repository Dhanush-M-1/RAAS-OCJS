import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> primes;
	
	static void sieve(int N)
	{
		primes = new ArrayList<Integer>();
		int[] lp = new int[N + 1];								
		for(int i = 2; i <= N; ++i)
		{
			if(lp[i] == 0)
			{
				primes.add(i);
				lp[i] = i;
			}
			int curLP = lp[i];
			for(int p: primes)
				if(p > curLP || p * i > N)
					break;
				else
					lp[p * i] = i;
		}
	}
	
	static ArrayList<Long> primeFactors(long N)		
	{
		ArrayList<Long> factors = new ArrayList<Long>();		
		int idx = 0, p = primes.get(idx);

		while(1l*p * p <= N)
		{
			while(N % p == 0) { factors.add(1l*p); N /= p; }
			p = primes.get(++idx);
		}

		if(N != 1)						
			factors.add(N);
		return factors;
	}
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		sieve(5*(int)1e6);
		long n = sc.nextLong();
		ArrayList<Long> fac = primeFactors(n);
		if(fac.size()==2)
			System.out.println(2);
		else if(fac.size()<2)
			System.out.println("1\n0");
		else 
			System.out.println("1\n"+fac.get(0)*fac.get(1));
		
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public int[] nexIntArray() throws Throwable
		{
			st = new StringTokenizer(br.readLine());
			int[] a = new int[st.countTokens()];
			for(int i = 0; i < a.length;i++)a[i]=nextInt();
			return a;
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
