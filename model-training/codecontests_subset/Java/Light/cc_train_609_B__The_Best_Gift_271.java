import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class B {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	    int n= nextInt(), m = nextInt();
	    int []used = new int[m+1];
	    int k = 0;
	    for (int i = 1; i <= n; i++) {
			 k = nextInt();
			used[k]++;
	    }
	    long t = n;
	    long fact = ((t-1)*t)/2;
	    for (int i = 1; i <= m; i++) {
			long val = used[i];	
	    	fact-= (val*(val-1))/2;
	    }
	    System.out.println(fact);
	    pw.close();
    }
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
//    private static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//    private static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}