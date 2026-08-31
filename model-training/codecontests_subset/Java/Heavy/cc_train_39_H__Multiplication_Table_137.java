import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main extends Thread {
    public Main() {
        try {
            this.input = new BufferedReader(new InputStreamReader(System.in));
            this.output = new PrintWriter(System.out);
            this.setPriority(Thread.MAX_PRIORITY);
        } catch (Exception e) {
            System.exit(666);
        }
    }


    private void solve() throws Throwable {
        int k = nextInt();
        for (int i = 1; i < k; ++i) {
            for (int j = 1; j < k; ++j) {
                output.print(BigInteger.valueOf(i).multiply(BigInteger.valueOf(j)).toString(k) + " ");
            }
            output.println();
        }

    }


    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.flush();
            output.close();
        }
    }

    public static void main(String[] args) {
        new Main().start();
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

    private String nextToken() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    private BufferedReader input;
    private PrintWriter output;
    private StringTokenizer tokens = null;
}