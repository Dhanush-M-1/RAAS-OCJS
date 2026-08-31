import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		long n=sc.nextLong();
		long p=sc.nextLong();
		long x=(long)Math.pow(p,(double)1/n)+1;
		
		long ans=1;
		if(n==1) {
			ans=p;
		}
		else {
			for(long i=x;i>=1;i--) {
			if(p%Math.pow(i,n)==0) {
					ans=i;
					break;
				}
			}
		}
	
		
		System.out.println(ans);
	}
		
	
	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
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
	

}



