import java.io.*; 
import java.util.*;
import java.math.*; 

public class Main {
	public static void main(String[] args) throws IOException 
	{ 
		FastScanner f = new FastScanner(); 
		int t=1;
		t=f.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		while(t>0) {
			t--;
			int n=f.nextInt();
			int[] tag=f.readArray(n);
			int[] s=f.readArray(n);
			long[] dp=new long[n];
			for(int i=0;i<n;i++) {
				for(int j=i-1;j>-1;j--) {
					if(tag[i]!=tag[j]) {
						long temp=dp[j];
						dp[j]=Math.max(dp[j], dp[i]+Math.abs(s[i]-s[j]));
						dp[i]=Math.max(dp[i], temp+Math.abs(s[i]-s[j]));
					}
				}
			}
			
			long ans=0;
			for(int i=0;i<n;i++) {
				ans=Math.max(ans, dp[i]);
			}
			System.out.println(ans);
		}
		out.close();
	} 
	static void sort(int [] a) {
        ArrayList<Integer> q = new ArrayList<>();
        for (int i: a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
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
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}
} 	