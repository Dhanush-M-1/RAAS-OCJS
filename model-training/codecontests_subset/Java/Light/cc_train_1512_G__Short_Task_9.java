import java.util.*;
import java.io.*;
public class B{
	static int n = (int)(1e7+5);
	static int[] sum;
	static int[] ans;
	
	public static void pre()
	{
		for(int i=1;i<n;i++)
		{
			for(int j=i;j<n;j+=i)
			{
				sum[j]+=i;
			}
			if(sum[i]<n && ans[sum[i]]==0)
			{
				ans[sum[i]]=i;
			}
		}
	}
	
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		sum = new int[n];
		ans = new int[n];
		pre();
		int t = fs.nextInt();
		for(int tt=0;tt<t;tt++)
		{
			int n = fs.nextInt();
			if(ans[n]==0)out.println("-1");
			else out.println(ans[n]);
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
	public static int[] sort(int[] arr)
	{
		List<Integer> temp = new ArrayList();
		for(int i:arr)temp.add(i);
		Collections.sort(temp);
		int start = 0;
		for(int i:temp)arr[start++]=i;
		return arr;
	}
}