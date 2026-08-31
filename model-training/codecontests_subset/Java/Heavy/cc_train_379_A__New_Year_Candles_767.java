import java.io.*;
import java.util.*;
import java.math.*;

public class A379 implements Runnable {

    public void solve() throws Exception {

        int a = nextInt();
        int b = nextInt();
        out.println((int)(a+Math.floor((a-1)/(b-1))));
    }

    /*******************************************************************************/

    public static void main(String[] args) throws Exception {
        new Thread(null, new A379(), "", 1 << 26).start();
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    final String fname = "";

    private String next() throws Exception {
        if (st == null || !st.hasMoreElements())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    private long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    private double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            solve();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            out.close();
        }
    }


}

