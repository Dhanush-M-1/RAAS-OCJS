import java.io.*;
import java.util.*;
public class B{
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		Integer [] a=new Integer [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Arrays.sort(a);
		int ans=0;
		HashSet<Integer> remove=new HashSet<>();
		for(int i=1;i<n;i++)
			if(a[i]>a[i-1] && a[i]<=a[i-1]+k)
				remove.add(a[i-1]);
		for(int i=0;i<n;i++)
			if(!remove.contains(a[i]))
				ans++;
		
		pw.println(ans);
		pw.flush();
		pw.close();
    }
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
} 