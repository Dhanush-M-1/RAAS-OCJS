import java.io.*;
import java.util.*;

public class Kola {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static String nextToken() throws IOException{
		while (in == null || !in.hasMoreTokens()){
			in = new StringTokenizer(br.readLine());
		}
		
		return in.nextToken();
	}
	
	public static int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	public static double nextDouble() throws IOException{
		return Double.parseDouble(nextToken());
	}
	
	public static void main(String[] args) throws IOException{
		int n = nextInt();
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();
		int ans = 0;
		for (int i = 0; i <= b; i++) {
			for (int j = 0; j <= c; j++) {
				int count = n - i - 2 * j;
				
				if (count < 0)
					break;
				
				if (count * 2 <= a)
					ans++;
			}
		}
		
		out.println(ans);
		
		out.close();
	}
}
