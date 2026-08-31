import java.util.*;
import java.io.*;

public class B{
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		for(int tt=0;tt<t;tt++)
		{
			int n = fs.nextInt();
			int[] arr = fs.readArray(n);
			int i=0;
			for(i=0;i<n;i++)
			{
				if(arr[i]>=i)
				{
					;
				}
				else
				{
					break;
				}
			}
			int start = 0;
			int j = n-1;
			for(j=n-1;j>=0;j--)
			{
				if(arr[j]>=start)
				{
					start++;
				}
				else
				{
//					System.out.println("here"+start+" "+j+" "+arr[j]);
					break;
				}
			}
//			out.println(i+" "+j);
			out.println(j+1<i?"YES":"NO");
		}
		out.close();
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


