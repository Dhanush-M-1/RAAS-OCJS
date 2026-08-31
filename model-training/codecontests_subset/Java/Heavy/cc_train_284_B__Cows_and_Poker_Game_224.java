import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BSol {
    
    public void solve() throws IOException {
        int n = nextInt();
        String s = in.readLine();
        
        int colIn = 0;
        int colAllIn = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'I') {
                colIn++;
            } else if (s.charAt(i) == 'A') {
                colAllIn++;
            }
        }
        
        if (colIn > 1) {
            out.println(0);
        } else if (colIn == 1) {
            out.println(1);
        } else {
            out.println(colAllIn);
        }
    }

    public static void main(String[] args) {
        new BSol().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader((System.in)));
            out = new PrintWriter(System.out);

            st = null;
            rnd = new Random();

            //double start = System.currentTimeMillis();
            solve();
            //double total = (System.currentTimeMillis() - start) / 1000.0;
            //total *= 10;

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