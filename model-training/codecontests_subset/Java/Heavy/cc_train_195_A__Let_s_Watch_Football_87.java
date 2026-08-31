import java.io.*;
import java.util.*;

public class Main implements Runnable {

    public void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        int ans = c*(a-b)/b;
        if( c*(a-b) % b != 0 ){
            ans++;
        }

        out.println( ans );
        
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader((System.in)));
            out = new PrintWriter(System.out);

            st = null;
            rnd = new Random();

           // double start = System.currentTimeMillis();
            solve();
            //double total = (System.currentTimeMillis() - start) / 1000.0;
           // total *= 10;

            //out.println("Total time: " + total + " sec.");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String nextToken() throws IOException, NullPointerException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }

        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private Random rnd;
}