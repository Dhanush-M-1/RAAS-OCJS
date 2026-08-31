

import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class A {
	public  static  FastScannerA scan = new FastScannerA();
	public static PrintWriter out = new PrintWriter(System.out);
	static long mad=(long) Math.pow(10, 9)+7;
	static boolean isPrime(int x) {
		if(x==1) return false;
		for(int i=2;i*i<=x;i++) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void solve () {
		long a=scan.nextLong(),b=scan.nextLong();
		long n=Math.abs(a-b);
		a=n/2;b=n-n/2;
		out.println((a*(a+1)/2)+(b*(b+1)/2));
	}
	public static void main(String[] args) {
		
		solve();
		out.close();
	}

}
class FastScannerA {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer("");
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
	void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	

	
}


