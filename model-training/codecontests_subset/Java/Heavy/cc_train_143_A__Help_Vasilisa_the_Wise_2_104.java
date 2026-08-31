import java.io.*;
import java.util.*;

public class CF102A {
	
	private static BufferedReader	br;
	private static StringTokenizer 	st;
	private static PrintWriter 		pw;
	// private static Timer t = new Timer();
	
	public CF102A() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
	}
	
	String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    boolean hasNext() {
        if (st != null && st.hasMoreElements())
            return true;

        try {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

	void solve() throws IOException{
		int r1 = nextInt(), r2 = nextInt(), c1 = nextInt(), c2 = nextInt(), d1 = nextInt(),
				d2 = nextInt();
		
		for(int i = 1; i < 10; i++) {
			int a = r1 - i;
			int b = c1 - i;
			int c = r2 - b;
			
			if((a+c) == c2 && (i+c) == d1 && (a+b) == d2 && a > 0 && b > 0 && c > 0 && 
					a < 10 && b < 10 && c < 10) {
				if( i != a && i != b && i != c && a != b && a != c && b != c) {
					pw.println(i +" "+ a);
					pw.println(b +" "+ c);
					pw.flush();
					return;
				}
			}
		}
		pw.println(-1);
		pw.flush();
	}
		
	public static void main(String[] args) throws IOException{
		 new CF102A().solve();
	 }
}