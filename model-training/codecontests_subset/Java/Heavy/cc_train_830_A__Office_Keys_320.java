import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class D {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		k=sc.nextInt();
		p=sc.nextInt();
		
		a=new int [n];
		b=new int [k];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<k;i++)
			b[i]=sc.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		
		long min=inf;
		for(int i=0;i+n-1<k;i++){
			long x=0;
			for(int j=0;j<n;j++){
				x=Math.max(x, Math.abs(a[j]-b[i+j])+Math.abs(b[i+j]-p));
			}
			min=Math.min(min, x);
		}
		
		pw.println(min);
		pw.flush();
		pw.close();
	}
	static int n,k,p;
	static int [] a,b;
	static long inf=(long)1e15;
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("ppp.in")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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