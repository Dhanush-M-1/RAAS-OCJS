import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = in.readInt(n);

		int maxdiv = 1;
		for(int i = 0; i < n; i++) {
			if(k%a[i]==0 && a[i]>maxdiv) maxdiv = a[i]; 
		}
		System.out.print(k/maxdiv);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next()); }
		long nextLong() { return Long.parseLong(next()); }
		double nextDouble() { return Double.parseDouble(next()); }
		String nextLine() {
			String str = "";
			try { str = br.readLine(); }
			catch(IOException e) { e.printStackTrace(); }
			return str;
		}
		int[] readInt(int size) {
			int[] arr = new int[size];
			for(int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(next());
			return arr;
		}
		long[] readLong(int size) {
			long[] arr = new long[size];
			for(int i = 0; i < size; i++)
				arr[i] = Long.parseLong(next());
			return arr;
		}
		int[][] read2dArray(int rows, int cols) {
			int[][] arr = new int[rows][cols];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++)
					arr[i][j] = Integer.parseInt(next());
			}
			return arr;
		}
	}
}