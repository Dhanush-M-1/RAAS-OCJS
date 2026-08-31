import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOfRobots {
	public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = nextInt();
		long k = nextLong();
		int[] a = intArray(n);
		
		long sum = 0;
		int i = 1;
		while (sum + i < k)
			sum += i++;
		
		System.out.println(a[(int)(k-sum-1)]);
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