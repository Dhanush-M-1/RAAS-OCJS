import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C implements Runnable {

    private void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = nextInt() - 1;
        }
        int ans = 0;
        boolean[] was = new boolean[n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(was, false);
            for (int j = i - 1; j >= 0; j--) {
                if (b[j] == b[i]) {
                    break;
                }
                if (!was[b[j]]) {
                    was[b[j]] = true;
                    ans += w[b[j]];
                }
            }
        }
        out.println(ans);
    }

    private BufferedReader in;
    private StringTokenizer tokenizer = new StringTokenizer("");
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    @Override
    public void run() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(System.out);
        try {
//            int t = nextInt();
//            for (int c = 0; c < t; c++) {
                solve();
//                out.println();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new Thread(new C()).start();
    }

}