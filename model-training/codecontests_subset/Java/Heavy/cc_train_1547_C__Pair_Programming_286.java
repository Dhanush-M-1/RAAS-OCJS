import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		
		int T = in.nextInt();
		while(T-- > 0) {
			int k = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			int[] a = in.readInt(n);
			int[] b = in.readInt(m);

			int x = 0, y = 0;
			boolean p = true;
			StringBuilder ans = new StringBuilder();
			while(x<a.length && y<b.length) {
				if(a[x]<=k) {
					ans.append(a[x] + " ");
					if(a[x]==0) k++;
					x++;
				}
				else if(b[y]<=k) {
					ans.append(b[y] + " ");
					if(b[y]==0) k++;
					y++;
				}
				else {
					p = false;
					break;
				}
			}
			if(!p) {
				System.out.println(-1);
				continue;
			}
					
			while(x<a.length) {
				if(a[x]<=k) {
					ans.append(a[x] + " ");
					if(a[x]==0) k++;
				}
				else {
					p = false;
					break;
				}
				x++;
			}
			while(y<b.length) {
				if(b[y]<=k) {
					ans.append(b[y] + " ");
					if(b[y]==0) k++;
				}
				else {
					p = false;
					break;
				}
				y++;
			}
			if(!p) {
				System.out.println(-1);
				continue;
			}
			else System.out.println(ans);
		}
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