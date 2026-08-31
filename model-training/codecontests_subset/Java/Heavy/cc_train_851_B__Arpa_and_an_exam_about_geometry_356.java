import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	//////
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	//////

	public static void main(String[] args) throws IOException {

		FastReader scan = new FastReader();

		long x1=scan.nextInt();
		long y1=scan.nextInt();
		long x2=scan.nextInt();
		long y2=scan.nextInt();
		long x3=scan.nextInt();
		long y3=scan.nextInt();
		
		//System.out.println((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		//System.out.println((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
		
		if(!(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))==((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3)))){
			System.out.println("NO");return;
		}
		if((y2-y1)*(x3-x2)==(y3-y2)*(x2-x1)){
			System.out.println("NO");return;
		}
		System.out.println("YES");
		
	}

}
