import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            if (k % a == 0) {
                min = Math.min(k/a, min);
            }
        }

        System.out.println(min);
    }


    // =========

    public static void main(String[] args) throws IOException {
        new ProblemA().run();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private void run() throws IOException {
        solve();
        out.close();
    }
}
