import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheBestGift {
	public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		
		int[] a = new int[m];
		for (int i = 0; i < n; i++)
			a[nextInt()-1]++;
		
		long sum = 0;
		for (int i = 0; i < m; i++)
			for (int j = i+1; j < m; j++)
				sum += 1L*a[i]*a[j];
		
		System.out.println(sum);
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
	
	public static long[] longArray(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
}