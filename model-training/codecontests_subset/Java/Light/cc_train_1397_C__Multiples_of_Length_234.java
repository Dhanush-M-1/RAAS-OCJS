import java.util.*;
import java.io.*;

public class A {
	static FastReader f = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);
	

	public static void main(String[] args) {
		solve();
		out.close();
	}

	static void solve() {
		int n = f.nextInt();
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = f.nextInt();
		}


		out.println("1 1");
		out.println(-arr[0]);
		arr[0] = 0;
		if(n > 1) {
			out.println(2+" "+n);
			for(int i=1;i<n;i++) {
				long loc = ((arr[i] % n) + n) % n;
				loc *= n-1;
				out.print(loc+" ");
				arr[i] += loc;
			}
			out.println();
		} else {
			out.println("1 1");
			out.println(0);
		}
		
		out.println("1 "+n);
		for(int i=0;i<n;i++) {
			out.print(-arr[i]+" ");
		}
		out.println();
	}


	static class FastReader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String s = "";
			try {
				s = br.readLine();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}

			return s;
		}

		int  nextInt() {
			return Integer.parseInt(next());
		}
	}
}