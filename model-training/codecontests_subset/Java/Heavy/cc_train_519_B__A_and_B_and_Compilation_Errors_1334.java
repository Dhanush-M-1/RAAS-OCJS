import java.awt.Point;
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
	public static long modularExponentiation(long x, long n, long M) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	public static long modularExponentiation1(long x, long n) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x);
			x = (x * x);
			n = n / 2;
		}
		return result;
	}

	/////
	
	
	public static void main(String[] args) throws IOException {

		FastReader scan = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);

		int N=scan.nextInt();
		//HashSet<Integer> hs=new HashSet<Integer>();
		long R1=0;
		for(int i=0;i<N;i++){
			//hs.add(scan.nextInt());
			R1^=scan.nextInt();
		}
		//HashSet<Integer> hs2=new HashSet<Integer>();
		long R2=0;
		for(int i=0;i<N-1;i++){
			//int a=scan.nextInt();
			R2^=scan.nextInt();
		}
		long R3=0;
		for(int i=0;i<N-2;i++){
			//int a=scan.nextInt();
			R3^=scan.nextInt();
		}
		System.out.println(R1^R2);
		System.out.println(R2^R3);
		
	}
}