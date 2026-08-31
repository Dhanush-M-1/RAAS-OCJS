import static java.util.Arrays.deepToString;

import java.io.*;
import java.util.*;

public class A {

    static void solve() throws Exception {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int size = a * c;       
        int t = 0;
        while(true){            
            if((t + c) * b >= size){
                break;
            }
            t++;
        }
        System.out.print(t);
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static void debug(Object... a) {
        System.err.println(deepToString(a));
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        try {           
            br = new BufferedReader(new InputStreamReader(System.in));      
            solve();
            br.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}