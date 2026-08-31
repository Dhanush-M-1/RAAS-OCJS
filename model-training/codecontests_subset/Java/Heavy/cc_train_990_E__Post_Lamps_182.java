import java.io.*;
import java.util.*;
public class E{
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		boolean [] valid=new boolean [n];
		Arrays.fill(valid, true);
		for(int i=0;i<m;i++)
			valid[sc.nextInt()]=false;
		int [] pre=new int [n];
		int lst=-1;
		for(int i=0;i<n;i++) {
			if(valid[i])
				lst=i;
			pre[i]=lst;
		}
		int [] a=new int [k+1];
		for(int i=1;i<=k;i++)
			a[i]=sc.nextInt();
		if(pre[0]==-1)
			pw.println(-1);
		else {			
			long ans=Long.MAX_VALUE;
			for(int i=1;i<=k;i++) {
				long cur=0;
				boolean ok=true;
				int p=0;
				while(true) {
					cur+=a[i];
					if(p+i>=n)
						break;
					if(pre[p+i]==p) {
						ok=false;
						break;
					}
					p=pre[p+i];
				}
				if(ok)
					ans=Math.min(ans, cur);
			}
			
			
			if(ans==Long.MAX_VALUE)
				pw.println(-1);
			else
				pw.println(ans);
		}
		pw.flush();
		pw.close();
    }
	
	static class pair{
		int val,cst;
		pair(int v,int c){
			val=v;
			cst=c;
		}
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