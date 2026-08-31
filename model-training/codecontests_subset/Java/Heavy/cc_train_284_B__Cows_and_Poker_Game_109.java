//Date: Oct 8, 2013 
//Time: 10:31:53 AM

import java.util.*;
import java.io.*;

public class B284 implements Runnable {

	public void solve() throws IOException {
		int N = nextInt();
		char[] c = nextToken().toCharArray();
		int a = 0;
		int i = 0;
		for(int k = 0; k < c.length; k++) if(c[k] == 'A') a++; else if(c[k] == 'I') i++;
		
		//System.out.println(a + " " + i);
		if(i == 1) System.out.println(1);
		else if(i > 1) System.out.println(0);
		else System.out.println(a);
	}

	//-----------------------------------------------------------
	public static void main(String[] args) {
		new B284().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = null;
			solve();
			in.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BufferedReader in;
	StringTokenizer tok;
}
/**
public class B284 {

}
 
*/