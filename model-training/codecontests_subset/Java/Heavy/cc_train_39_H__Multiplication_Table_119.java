import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class MultiplicationTable implements Runnable {

    private void solve() throws IOException {
        int n = nextInt();
        BigInteger[][] mat = new BigInteger[n][n];
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                mat[i][j] = BigInteger.valueOf(i).multiply(BigInteger.valueOf(j));
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                out.print(mat[i][j].toString(n) + " ");
            }
            out.println();
        }
    }

    public static void main(String[] args) {
        new MultiplicationTable().run();
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }

    String nextLine() throws IOException {
        return in.readLine();
    }

    char nextChar() throws IOException {
        return (char) in.read();
    }

    String nextString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }
}