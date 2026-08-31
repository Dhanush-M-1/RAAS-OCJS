import static java.lang.Math.*; 

import java.io.*; 
import java.util.*; 

public class Template {
	BufferedReader in; 
	PrintWriter out;
	StringTokenizer st; 

	String next() {
		while (st==null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {}
		}
		return st.nextToken(); 
	}

	int nextInt() {
		return Integer.parseInt(next()); 
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}
	
	public void run() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Long start = System.currentTimeMillis();
		
		int k = nextInt(); 
		String s = next(); 
		int[] a = new int[26];
		String t=""; 
		for (int i=0; i<s.length(); i++) {
			a[s.charAt(i) - 'a']++; 
		}

		boolean ok=true; 	
		for (int i=0; i<26; i++) if (a[i] % k != 0) ok=false; 
		
		if (ok) {
			for (int i=0; i<26; i++) 
				for (int j=0; j<a[i]/k; j++) t=t + (char)(i + (int)('a')); 
			String ans=""; 
			for (int i=0; i<k; i++) ans=ans+t; 

			out.println(ans); 
		} else out.println(-1); 

		Long end = System.currentTimeMillis();
		out.close(); 
	}

	public static void main(String[] args) throws Exception {
		new Template().run(); 
	}
}
