/* @@@@@@@@@@@@@@@@@@@@@@@
 * @@@ Doston Akhmedov @@@
 * @@@@@@@@@@@@@@@@@@@@@@@
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class r_164_a {
	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	
	static class sort implements Comparable<sort> {
		int a, b;

		public sort(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(sort arg0) {
			if(this.a==arg0.a)
				return (this.b-arg0.b);
			return -(this.a - arg0.a);
		}
	}
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		// gfile();
		int n=nextInt();
		int a[]=new int[n+1];
		int h[]=new int[n+1];
		int ans=0;
		for (int i = 1; i <=n; i++) {
			a[i]=nextInt();
			h[i]=nextInt();
		}
		for (int i = 1; i < n; i++) {
			for (int j = i+1; j <=n; j++) {
				ans+=isop(a[i],h[i],a[j],h[j]);
			}
		}
		pw.print(ans);
		pw.close();
	}

	private static int isop(int x1, int y1, int x2, int y2) {
		if(x1==y2&&x2==y1)
		return 2;
		if(x1==y2||x2==y1)
			return 1;
		return 0;
	}

	private static void gfile() throws IOException {
		br = new BufferedReader(new FileReader(new File("input.txt")));
		pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(
				"output.txt"))));
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
