//package ;
import java.io.*;
import java.util.*;

public class A
{
	static boolean fun(int k)
	{
		int sum1=0,sum2=0;
		for(int i=0;i<a.length;i++)
		{
			sum1+=a[i];
			sum2+=k-a[i];
		}
		return sum2>sum1;
	}
	static int[]a;
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n=sc.nextInt();
		a=new int[n];int max=0;
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			max=Math.max(a[i], max);
		}
		int k=max;
		while(true)
		{
			if(fun(k))
				break;
			k++;
		}
		System.out.println(k);
		pw.close();    
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
		
		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		long nextLong() throws IOException {
			return Long.parseLong(next());
		}
		
		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
		
		String nextLine() throws IOException {
			return br.readLine();
		}
		boolean hasnext() throws IOException{
			return br.ready();
		}
		
	}
}
