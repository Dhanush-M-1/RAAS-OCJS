import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args){
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt(), m = scan.nextInt();
		int[][] q = new int[m][4];
		for(int i = 0; i < m; i++){
			q[i][0] = scan.nextInt();
			q[i][1] = scan.nextInt()-1;
			q[i][2] = scan.nextInt()-1;
			q[i][3] = scan.nextInt();
		}
		int[] a = new int[n];
		Arrays.fill(a, 1000000000);
		for(int i = m-1; i >= 0; i--) {
			if(q[i][0] == 1){
				for(int j = q[i][1]; j <= q[i][2]; j++) if(a[j] != 1000000000) a[j] -= q[i][3];
			}
			else { 
				for(int j = q[i][1]; j <= q[i][2]; j++) if(a[j] > q[i][3]) a[j] = q[i][3];
			}
		}
		int[] res = Arrays.copyOf(a, n);
		boolean good = true;
		for(int i = 0; i < m; i++) {
			if(q[i][0] == 1) {
				for(int j = q[i][1]; j <= q[i][2]; j++) a[j] += q[i][3];
			} else {
				int max = -0x3f3f3f3f;
				for(int j = q[i][1]; j <= q[i][2]; j++) max = Math.max(max, a[j]);
				if(max != q[i][3]) good = false;
			}
		}
		out.println(good?"YES":"NO");
		if(good)for(int i = 0; i < n; i++) out.print(res[i]+" ");
		out.close();
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
