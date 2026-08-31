
// Submitted by Subhash Yadav
import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n=sc.nextInt();
		char c[]=sc.next().toCharArray();
		int cnt=0;
		for(char c1:c) {
			if(c1=='8') cnt++;
		}
		System.out.println(Math.min(cnt, n/11));

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