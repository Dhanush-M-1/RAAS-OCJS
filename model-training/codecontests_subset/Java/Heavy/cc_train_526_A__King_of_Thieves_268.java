import java.io.*;
import java.util.*;

public class A {

    public void solve() throws IOException {
        int n = in.nextInt();
        char[] s = in.nextToken().toCharArray();
        for (int i = 0; i < n; i++) {
            for (int d = 1; i + 4 * d < n; d++) {
                boolean ok = true;
                for (int j = 0; j < 5; ++j) {
                    ok &= s[i + j * d] != '.';
                }
                if (ok) {
                    out.println("yes");
                    return;
                }
            }
        }
        out.println("no");
    }

    static FastReader in;
    static PrintWriter out;
    static PrintStream err;

    public static void main(String[] args) throws IOException {
        try {
            in = new FastReader();
            out = new PrintWriter(System.out);
            err = System.err;
            new A().solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer in;

    FastReader() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    FastReader(String filename) {
        try {
            this.br = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}