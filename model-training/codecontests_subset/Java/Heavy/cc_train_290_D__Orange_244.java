import java.io.*;
import java.util.*;


public class PrD {
	public static void main(String[] args) throws IOException {
		new PrD().run();
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
		String s = nextToken();
		int n = nextInt();
		String s1 = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) <= 'Z') {
				s1 += (char)(s.charAt(i)-'A'+'a');
			}else {
				s1 += s.charAt(i);
			}
		}
		String ans = "";
		s = s1;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c/*-'A'+'#' */< n + 97) {
				if(c <= 'Z') {
					ans = ans + (c+"");
				}else {
					ans = ans + ((char)(c+'A'-'a'));
				}
			}else {
				if(c <= 'Z') {
					ans = ans + ((char)(c-'a'+'A'));
				}else {
					ans = ans + (c+"");
				}
			}
		}
		out.println(ans);
		
	}
}