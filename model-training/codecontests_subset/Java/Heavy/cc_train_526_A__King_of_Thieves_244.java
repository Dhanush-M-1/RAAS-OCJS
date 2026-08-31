import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingOfThieves {
	public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = nextInt();
		String s = nextString();
		
		for (int i = 0; i < n; i++)
			for (int j = 1; i+4*j < n; j++) {
				boolean b = true;
				for (int k = 0; k < 5; k++)
					b &= s.charAt(i+k*j) == '*';
				if (b) {
					System.out.println("yes");
					return;
				}
			}
		
		System.out.println("no");
	}
	
	public static String nextLine() throws IOException {
		return f.readLine();
	}
	
	public static String nextString() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(f.readLine());
		return st.nextToken();
	}
	
	public static int nextInt() throws IOException {
		return Integer.parseInt(nextString());
	}
	
	public static long nextLong() throws IOException {
		return Long.parseLong(nextString());
	}
	
	public static int[] intArray(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
	
	public static int[][] intArray(int n, int m) throws IOException {
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = nextInt();
		return a;
	}
	
	public static long[] longArray(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
}