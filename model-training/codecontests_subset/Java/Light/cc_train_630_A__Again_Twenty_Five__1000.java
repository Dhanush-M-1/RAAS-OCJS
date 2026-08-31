

import java.io.*;
import java.math.BigInteger;
import java.util.*;


@SuppressWarnings("unused")
public class B {
	public  static  FastScannerB scan = new FastScannerB();
	public static PrintWriter out = new PrintWriter(System.out);
	
	public static void solve () {
		String s=scan.next();
		out.println(25);
		
		
	}
	public static void main(String[] args) {
		
		solve();
		out.close();
	}

}
class FastScannerB {
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


