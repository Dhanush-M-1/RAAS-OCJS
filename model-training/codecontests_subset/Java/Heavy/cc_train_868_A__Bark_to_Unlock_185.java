import java.util.*;
import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String str = in.next();
        int n = in.nextInt();
        String[] as = new String[n];
        for (int i = 0; i < n; i++) {
            as[i] = in.next();
        }
        boolean good = false;
        for (String a : as) {
            for (String b : as) {
                if ((a + b + "").contains(str)) {
                    good = true;
                }
            }
        }
        
        out.println(good ? "YES" : "NO");
        
        out.close();
    }

//@
static class FastScanner {
    BufferedReader br;
    StringTokenizer st;
	
    public FastScanner(InputStream i) {
        br = new BufferedReader(new InputStreamReader(i));
        st = new StringTokenizer("");
    }
			
    public String next() throws IOException {
        if(st.hasMoreTokens())
            return st.nextToken();
        else
            st = new StringTokenizer(br.readLine());
        return next();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    //#
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    //$
}
}