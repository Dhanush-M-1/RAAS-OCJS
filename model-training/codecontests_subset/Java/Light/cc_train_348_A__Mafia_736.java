
import java.io.*;
import java.util.*;
import java.util.Queue;
import java.awt.*;
import java.math.*;

public class Main {

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    static String next() throws Exception {

        while (!st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    public static void main(String[] asda) throws Exception {
        
        int N = Integer.parseInt( next() );
        long sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt( next() );
            max = Math.max(x, max);
            sum += x;
        }
        long ans = sum / (N - 1);
        if ( ans * (N - 1) < sum ) {
            ans++;
        }
        out.println( Math.max(ans, max) );
        //
        out.flush();
        System.exit(0);
    }
}

