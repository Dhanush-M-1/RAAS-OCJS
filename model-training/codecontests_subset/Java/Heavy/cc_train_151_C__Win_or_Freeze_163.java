import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	static class FastScanner {
		BufferedReader s;
		StringTokenizer st;

		public FastScanner(InputStream InputStream) {
			st = new StringTokenizer("");
			s = new BufferedReader(new InputStreamReader(InputStream));
		}

		public FastScanner(File f) throws FileNotFoundException {
			st = new StringTokenizer("");
			s = new BufferedReader(new FileReader(f));
		}

		public int nextInt() throws IOException {
			if (st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextInt();
			}
		}

		public BigInteger big() throws IOException {
			if (st.hasMoreTokens())
				return new BigInteger(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return big();
			}
		}

		public double nextDouble() throws IOException {
			if (st.hasMoreTokens())
				return Double.parseDouble(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextDouble();
			}
		}

		public long nextLong() throws IOException {
			if (st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextLong();
			}
		}

		public String next() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			else {
				st = new StringTokenizer(s.readLine());
				return next();
			}

		}

		public String nextLine() throws IOException {
			return s.readLine();
		}

		public void close() throws IOException {
			s.close();
		}

	}

	public static void main(String[] args) throws java.lang.Exception {
		FastScanner in = new FastScanner(System.in);
		long n = in.nextLong();
		int val = 1;
		boolean flag = true;
		for(int x = 2; 1l * x * x <= n; x++) {
			if(n % x == 0) {
				val = x;
				flag = false;
				break;
			} 
		}
		if(flag) {
			System.out.println(1 + "\n" + 0);
		} else {
			flag = true;
			int mul = 1;
			n = n / val;
			for(int x = 2;1l * x * x <= n; x++) {
				if(n % x == 0) {
					flag = false;
					mul = x;
					break;
				} 
			}
			if(flag) {
				System.out.println(2);
			}else {
				System.out.println(1 + "\n" + val * mul);
			}
		}
	}

}