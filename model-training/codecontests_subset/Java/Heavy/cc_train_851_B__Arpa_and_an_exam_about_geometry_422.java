import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args)  {
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		long[] x = new long[3];
		long[] y = new long[3];
		x[0] = scan.nextInt(); y[0] = scan.nextInt();
		x[1] = scan.nextInt(); y[1] = scan.nextInt();
		x[2] = scan.nextInt(); y[2] = scan.nextInt();
		if(dist(x[0], y[0], x[1], y[1])==dist(x[1], y[1], x[2], y[2]) && (x[0]-x[1])*(y[1]-y[2])-(y[0]-y[1])*(x[1]-x[2]) != 0) out.println("Yes");
		else out.println("No");
		out.close();
	}
	
	static long dist(long x, long y, long xx, long yy) {
		return (x-xx)*(x-xx)+(y-yy)*(y-yy);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
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
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n){
			long[] a = new long[n];
			for(int i = 0; i < n; i++) a[i] = nextLong();
			return a;
		}

		public double[] nextDoubleArray(int n){
			double[] a = new double[n];
			for(int i = 0; i < n; i++) a[i] = nextDouble();
			return a;
		}

		public char[][] nextGrid(int n, int m){
			char[][] grid = new char[n][m];
			for(int i = 0; i < n; i++) grid[i] = next().toCharArray();
			return grid;
		}
	}

}