import java.io.*;
import java.util.*;
public class Main {
	static long mod=1_000_000_000+7;
	static long[] facts=new long[3_000_00];
	static long mul(long a, long b) {
		return a*b%mod;
	}
	
	static long add(long a, long b) {
		return (a+b)%mod;
	}
	
	static void precomp() {
		facts[0]=1;
		for (int i=1; i<facts.length; i++) facts[i]=mul(facts[i-1], i);
	}
	
	static long exp(long base, long pow) {
		if (pow==0) return 1;
		long half=exp(base, pow/2);
		if (pow%2==0) return mul(half, half);
		return mul(half, mul(half, base));
	}
	
	static long modInv(long x) {
		return exp(x, mod-2);
	}
	
	static long nCk(int n, int k) {
		if(n<k) return 0;
		return mul(facts[n], mul(modInv(facts[k]), modInv(facts[n-k])));
	}
	public static void main(String[] args) throws IOException 
	{ 
		FastScanner f = new FastScanner(); 
		int t=1;
		t=f.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		int mx=300005;
		long[][] dp=new long[mx][11];
		
		for (int i = 0; i < 10; i++) dp[0][i] = 1;
		
		for (int i = 1; i <= 200003; i++) {
			for (int j = 0; j < 9; j++) {
				dp[i][j] = dp[i - 1][j + 1];
			}
			dp[i][9] = (dp[i - 1][1] + dp[i - 1][0]) % mod;
		}
		for(int tt=0;tt<t;tt++) {
			int n= f.nextInt();
			int m= f.nextInt();
			long ans=0;
			while(n>0) {
				int curr=n%10;
				ans=add(ans,dp[m][curr]);
				n/=10;
			}out.println(ans);
		}
		out.close();
	} 
	static void sort(long[] p) {
        ArrayList<Integer> q = new ArrayList<>();
        for (long i: p) q.add((int) i);
        Collections.sort(q);
        for (int i = 0; i < p.length; i++) p[i] = q.get(i);
    }
    
	static class FastScanner {
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
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}
} 	
//Some things to notice
//Check for the overflow
//Binary Search
//Bitmask
//runtime error most of the time is due to array index out of range