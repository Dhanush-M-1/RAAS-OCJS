import java.io.*;
import java.util.*;

public class PrA {
	public static void main(String[] args) throws IOException {
		new PrA().run();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws IOException {
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
		solve();
		out.flush();
	}
	
	void solve() throws IOException {
		int n = nextInt();
		String s = nextToken();
		char letters[] = {'a', 'e', 'o', 'u', 'i', 'y'};
		for(int i = 0; i < n; i++) {
			int l = -1;
			for(int j = 0; j < letters.length; j++) {
				if(s.charAt(i) == letters[j]) {
					l = j;
					break;
				}
			}
			if(l == -1) {
				out.print(s.charAt(i));
				continue;
			}
			int cnt = 0;
			while( i + cnt < n && s.charAt(i + cnt) == letters[l]) {
				cnt++;
			}
			if(cnt < 2) {
				out.print(letters[l]);
				continue;
			}
			if(cnt == 2 && (l == 1 || l == 2)) {
				out.print(letters[l]);
				out.print(letters[l]);
				i++;
				continue;
			}
			out.print(letters[l]);
			i += cnt - 1;
		}
	}
}
