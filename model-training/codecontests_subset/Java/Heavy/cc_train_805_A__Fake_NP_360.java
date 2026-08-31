import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int l = fs.nextInt(), r = fs.nextInt();

		int x = r - l;
		int cnt = x / 2;
		if(cnt > 0) {
			System.out.println(2);
		} else {
			System.out.println(l);
		}
		

		out.close();
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				//                br = new BufferedReader(new FileReader("testdata.out"));
				st = new StringTokenizer("");
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			try {line = br.readLine();}
			catch (Exception e) {e.printStackTrace();}
			return line;
		}

		public Integer[] nextIntegerArray(int n) {
			Integer[] a = new Integer[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		public char[] nextCharArray() {
			return nextLine().toCharArray();
		}
	}

}
