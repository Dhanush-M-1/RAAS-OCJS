import java.io.*;
import java.util.*;
public class A {
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	public static void main(String args[]) throws IOException {
		new A().run();
	}
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		ob = new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve() throws IOException {
		int n = ni() , k = ni();
		int ans = 0;
		for(int i=1 ; i<=n ; i++) {
			int x = ni();
			if(k%x==0) {
				ans = Math.max(ans, x);
			}
		}
		ob.println(k/ans);
	}
	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}
	String nextToken() throws IOException {
		if( st == null || !st.hasMoreTokens() )
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}
