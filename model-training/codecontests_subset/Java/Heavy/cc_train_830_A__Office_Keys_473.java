import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
public class H {
 	private static FastScanner fs=new FastScanner();
	public static void main(String[] args) {
		
		int n = fs.nextInt(),k = fs.nextInt(),p= fs.nextInt();
		int a[] = fs.readArray(n);
		int b[] = fs.readArray(k);
		ruffleSort(a);
		ruffleSort(b);
		long dp[][] = new long[k+1][n+1];
		for(int i=0;i<=k;i++)
			Arrays.fill(dp[i],Long.MAX_VALUE);
		dp[0][0] = 0;
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<=n;j++)
			{
				dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]);
				if(j<n)
				dp[i+1][j+1]= Math.min(dp[i+1][j+1],Math.max(dp[i][j],Math.abs(b[i]-a[j])+Math.abs(p-b[i])));
			}
		}
		System.out.println(dp[k][n]);
	
	}
	
 
	static final Random random=new Random();
	
	static void ruffleSort(int [] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n); int  temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
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
		int [] sort(int [] arr)
		{
			List<Integer> list = new ArrayList<>();
			for(int i : arr) list.add(i);	
		
			Collections.sort(list);
			int res[] = new int[arr.length];
			for(int i=0;i<arr.length;i++) res[i] = list.get(i);
			

			return res;
		}
	}
 
	
}