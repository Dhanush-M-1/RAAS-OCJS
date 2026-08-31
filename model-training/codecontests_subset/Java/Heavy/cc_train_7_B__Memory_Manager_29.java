import java.util.*;
import java.io.*;

public class Solution implements Runnable {
	
	final int Z = -521999614;
	
	public static void main(String[] args) {
		new Thread(new Solution()).start();
	}
	public void run() {
		try {
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.toString());
		}
	}
	
	String next() throws Exception {
		while (tok == null || !tok.hasMoreTokens())
			tok = new StringTokenizer(cin.readLine());
		return tok.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	BufferedReader cin;
	PrintWriter cout;
	StringTokenizer tok;
	
	int[] a;
	int m, n;
	
	private void solve() throws Exception {
		cin = new BufferedReader(new InputStreamReader(System.in));
		cout = new PrintWriter(System.out);
		
		m = nextInt();
		n = nextInt();
		
		int cur = 1;
		a = new int[n];
		Arrays.fill(a, Z);
		while (m --> 0) {
			String cmd = next();
			switch (cmd.charAt(0)) {
			case 'a': {
				int sz = nextInt();
				boolean success = false;
				for(int i = 0; i < n - sz + 1; ++i)
					if (free(i, sz)) {
						cout.println(cur);
						mark(i, sz, cur++);
						success = true;
						break;
					}
				if (!success) cout.println("NULL");
				break;
			}
			case 'e': {
				boolean found = false;
				int color = nextInt();
				for(int e: a)
					if (e == color) {
						found = true;
						break;
					}
				if (found) {
					for(int i = 0; i < n; ++i)
						if (a[i] == color) a[i] = Z;
				} else {
					cout.println("ILLEGAL_ERASE_ARGUMENT");
				}
				break;
			}
			
			case 'd': {
				int p = 0;
				for(int i = 0; i < n; ++i)
					if (a[i] != Z) a[p++] = a[i];
				while (p < n) a[p++] = Z;
			}

			}
		}
		
		cin.close();
		cout.close();
	}
	private boolean free(int start, int sz) {
		for(int i = 0; i < sz; ++i)
			if (start + i >= n || a[start + i] != Z) return false;
		return true;
	}
	
	void mark(int start, int sz, int color) {
		for(int i = 0; i < sz; ++i)
			a[start + i] = color;
	}

}
