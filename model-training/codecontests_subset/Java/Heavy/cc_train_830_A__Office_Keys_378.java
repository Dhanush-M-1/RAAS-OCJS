import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class D2 {
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
		
		mem=new long [n+1][k+1];
		for(long [] x : mem)
			Arrays.fill(x, -1);
		pw.println(dp(0,0));
		
		pw.flush();
		pw.close();
	}
	static int n,k,p;
	static int [] a,b;
	static long inf=(long)1e15;
	static long [][] mem;
	
	public static long dp(int i,int j){
		if(i==n)
			return 0;
		if(j>=k)
			return inf;
		if(mem[i][j]!=-1)
			return mem[i][j];
		long ans=dp(i, j+1);
		ans=Math.min(ans, Math.max(Math.abs(a[i]-b[j])+Math.abs(b[j]-p),dp(i+1, j+1)));
		
		return mem[i][j]=ans;
	}
	
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