
// Submitted by Subhash Yadav
import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int t = sc.nextInt();
		while (t-- > 0) {
int n=sc.nextInt();
int a[]=sc.readArray(n);
if(a[0]+a[1]<=a[n-1]) {
	System.out.println("1 2 "+n);
}
else System.out.println(-1);

		}

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}