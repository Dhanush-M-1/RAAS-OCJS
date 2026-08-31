//package cf915;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream is = System.in;
//		is = new FileInputStream(new File("A.txt"));
		FastScanner sc = new FastScanner(new InputStreamReader(is));
//		PrintWriter pr = new PrintWriter(new File("A.out"));
		PrintWriter pr = new PrintWriter(System.out);
		int B = sc.nextInt();
		int L = sc.nextInt();
		int b = Integer.MAX_VALUE;
		for (int i=0; i<B; i++) {
			int k=sc.nextInt();
			int r=L%k;
			if (r==0) {
				b=Math.min(b,L/k);
			}
		}
		pr.println(b);
		pr.close();
	}

	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;

	    FastScanner(Reader in) {
	        br = new BufferedReader(in);
	    }

	    String next() {
	        while (st == null || !st.hasMoreTokens()) {
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
	}

}

