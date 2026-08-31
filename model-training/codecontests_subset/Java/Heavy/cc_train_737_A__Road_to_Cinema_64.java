import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main extends Reader {
    
	public static void main(String[] args) throws IOException {
	    int n = ni(), k = ni();
	    long s = nl(), t = nl();
	    long z = 1000000010;
	    long c[] = new long[n];
	    for (int i=0; i<n; i++) {
	        c[i] = nl();
	        c[i] += nl() * z;
	    }
	    Arrays.sort(c);
	    int size = 1;
	    for (int i=1; i<n; i++) {
	        long tmp = c[i] % z;
	        while (size > 0 && tmp <= c[size-1]%z) size--;
	        c[size++] = c[i];
	    }
	    
	    long g[] = new long[k+1];
	    for (int i=0; i<k; i++) g[i] = ni();
	    g[k] = s;
	    Arrays.sort(g);
	    
	    int l = 0, r = size-1;
	    while (l<=r) {
	        int m = (l+r)>>1;
	        long v = c[m]/z;
	        long p = 0, time = t;
	        boolean flag = true;
	        for (int i=0; i<=k; i++) {
	            long dis = g[i]-p;
	            if (v >= dis * 2) {
	                time -= dis;
	            } else if (v >= dis) {
	                time -= 3 * dis - v;
	            } else {
	                time = -1;
	            }
	            if (time < 0) {
	                flag = false; break;
	            }
	            p = g[i];
	        }
	        if (!flag) l = m+1; else r = m-1;
	    }
	    if (l >= size) {
	        System.out.println(-1);
	    } else {
	        System.out.println(c[l] % z);
	    }
	}
}



class Reader {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    /** call this method to change InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
    }

    /** get next word */
    static String ns() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int ni() throws IOException {
        return Integer.parseInt( ns() );
    }
	
    static double nd() throws IOException {
        return Double.parseDouble( ns() );
    }
    static long nl() throws IOException {
        return Long.valueOf( ns() );
    }
}