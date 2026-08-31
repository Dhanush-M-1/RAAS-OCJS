

import java.io.*;
import java.util.*;


public class round_294_problem_B {
	
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		// Start writing your solution here. -------------------------------------

		/*
      		int n      = sc.nextInt();        // read input as integer
      		long k     = sc.nextLong();       // read input as long
      		double d   = sc.nextDouble();     // read input as double
      		String str = sc.next();           // read input as String
      		String s   = sc.nextLine();       // read whole line as String

      		int result = 3*n;
      		out.println(result);                    // print via PrintWriter
		 */
		
		int compileErrors = sc.nextInt();		
		String[] a = sc.nextLine().split(" ");
		String[] b = sc.nextLine().split(" ");
		String[] c = sc.nextLine().split(" ");
		
		HashMap<String, Integer> H = new HashMap<String, Integer>();
		
		for(int i = 0; i < a.length; i++) {
			if(!H.containsKey(a[i])) H.put(a[i], 1);
			else H.replace(a[i], H.get(a[i]) + 1);
		}		
				
		for(int i = 0; i < b.length; i++) {
			H.replace(b[i], H.get(b[i]) - 1);
			if(H.get(b[i]) == 0) H.remove(b[i]);
		}		
		
		for(int i = 0; i < a.length; i++) {
			if(H.containsKey(a[i])) {
				out.println(a[i]);
				break;
			}
		}
		
		H = new HashMap<String, Integer>();
		
		for(int i = 0; i < b.length; i++) {
			if(!H.containsKey(b[i])) H.put(b[i], 1);
			else H.replace(b[i], H.get(b[i]) + 1);
		}
		
		for(int i = 0; i < c.length; i++) {
			H.replace(c[i], H.get(c[i]) - 1);
			if(H.get(c[i]) == 0) H.remove(c[i]);
		}
		
		for(int i = 0; i < b.length; i++) {
			if(H.containsKey(b[i])) {
				out.println(b[i]);
				break;
			}
		}
				
		// Stop writing your solution here. -------------------------------------
		out.close();
		
	}



	//-----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	//-----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
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

		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
	//--------------------------------------------------------
}