import java.io.*;
import java.util.*;
public class Edu
{
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	public static void main(String[] args) throws IOException {
		new Edu().run();
	}
	void run() throws IOException {
		//in=new BufferedReader(new FileReader("input.txt"));
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve() throws IOException {
		int n = ni();
		boolean b[] = new boolean[1000010];
		for(int i=1 ; i<=n ; i++)
			b[ni()] = true;
		
		long ans = 0L;
		int cnt = n;
		int start = 1 , end = 1000000;
		for(int i=2 , j = 1000000-1; i<=1000000 && j>=1 ; i++ , j-- ) {
			if( i==j ) {
				if(b[i]) {
					++ans;
					--cnt;
				}
				if(cnt<=0) break;
 			}	
			if(b[i]) --cnt;
			if(b[j]) --cnt;
			++ans;
			if(cnt<=0) break;
		}
		
		ob.println(ans);
	}
	public int distance (int a , int b) {
		return Math.abs(a-b);
	}
	String ns() throws IOException {
		return nextToken();
	}
	long nl() throws IOException {
		return Long.parseLong(nextToken());
	}
	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}
	double nd() throws IOException {
		return Double.parseDouble(nextToken());
	} 
	String nextToken() throws IOException {
		if(st==null || !st.hasMoreTokens())
			st=new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	int[] nia(int start,int b) throws IOException {
		int a[]=new int[b];
		for(int i=start;i<b;i++)
			a[i]=ni();
		return a;
	}
	long[] nla(int start,int n) throws IOException {
		long a[]=new long[n];
		for (int i=start; i<n ;i++ ) {
			a[i]=nl();
		}
		return a;
	}
}