import java.io.*;
import java.util.*;

public class CF114A {
	
	private static BufferedReader	br;
	private static StringTokenizer 	st;
	private static PrintWriter 		pw;
	// private static Timer t = new Timer();
	
	public CF114A() throws IOException {
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next().replace(',', '.'));
    }

    boolean nextBool() throws IOException {
        String s = next();
        if (s.equalsIgnoreCase("true") || s.equals("1"))
            return true;

        if (s.equalsIgnoreCase("false") || s.equals("0"))
            return false;

        throw new IOException("Boolean expected, String found!");
    }
    public static int S(long x) {
    	int sum = 0;
    	while(x != 0) {
    		sum += x % 10;
    		x /= 10;
    	}
    	
    	return sum;
    }
		
	void solve() throws IOException{
		
		int n = nextInt();
		int x = nextInt();
		int y = nextInt();
		
		long a = ( ( n * y ) + 99 ) / 100;
		long  b = ( a - x);
		
		if( b < 0 ) {
			pw.println(0);
		}else
			pw.println(b);
		
		pw.flush();
	}
		
	public static void main(String[] args) throws IOException{
		 new CF114A().solve();
	 }
}