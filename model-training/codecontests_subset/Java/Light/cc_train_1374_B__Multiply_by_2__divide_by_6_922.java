import java.util.*;
import java.io.*;

public class Main {

  public static void main(final String[] args) {
    FastScanner sc = new FastScanner();
	int t = sc.nextInt();
	while(t-- > 0) {
		int n  = sc.nextInt();
		int ans = 0;
		while(n != 1 || n%3 == 0) {
			if(n%6 == 0) n /= 6;
			else if(n%3 == 0) n *= 2;
			else break;
			ans++;
		}
		System.out.println(n == 1 ? ans : -1);
	}
  } 

  static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}