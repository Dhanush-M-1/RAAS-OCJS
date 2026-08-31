
import java.io.*;
import java.util.*;
import java.math.*;

public class Exercise1 implements Runnable {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    private void solve() throws IOException {
        int count = nextInt();

        int count100 = 0;
        int count200 = 0;

        for (int i = 0; i < count; i++) {
            int temp = nextInt();

            if (temp == 100) {
                count100++;
            } else {
                count200++;
            }
        }


        if (count200 % 2 == 0) {
            if (count100 % 2 == 0) {
                out.print("YES");
            } else {
                out.print("NO");
            }
        } else {
            if (count100 % 2 == 0 && count100 > 0) {
                out.print("YES");
            } else {
                out.print("NO");
            }
        }
    }

    public static void main(String[] args) {
        new Exercise1().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();

            if (line == null) {
                return null;
            }

            st = new StringTokenizer(line);
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
}
