import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class CodeForces93 {
	public static void main(String[] args) throws IOException
	{
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		//long startTime = System.nanoTime();
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++)
		{
			int len = sc.nextInt();
			int[] arr = new int[len];
			
			for (int j = 0; j < len; j++)
			{
				arr[j] = sc.nextInt();
				
			}
			int max = arr[len-1];
			int min = arr[0];
			int min2 = arr[1];
			if (min + min2 > max)
			{
				pw.println("-1");
			}
			else
			{
				pw.println(1 + " " + 2 + " " + len);
			}
 
		}
		
			
		
		//long elapsedTime = System.nanoTime() - startTime;
		//pw.println(elapsedTime/1000000);
		pw.close();
		
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
}