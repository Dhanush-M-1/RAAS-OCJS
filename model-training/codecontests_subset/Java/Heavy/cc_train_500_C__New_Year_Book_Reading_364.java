import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProbC {
    boolean eof;

    public static void main(String[] args) throws IOException {
        new ProbC().run();
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "-1";
            }
        }
        return st.nextToken();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    int nextInt() {
        return Integer.parseInt(next());
    }

    void run() throws IOException {
        String name = "baseball";
        InputStream input = System.in;
        OutputStream output = System.out;
        try {
            File f = new File(name + ".in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new FileOutputStream(name + ".out");
            }
        } catch (Exception e) {
        }

        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);

        solve();

        br.close();
        out.close();
    }

    void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; ++i) {
            w[i] = nextInt();
        }
        int[] a = new int[m];
        for (int i = 0; i < m; ++i) {
            a[i] = nextInt() - 1;
        }
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        pos[a[0]] = 0;
        int sum = 0;

        int[] cur = new int[n];
        cur[0] = a[0];
        int e = 1;
        for (int i = 1; i < m; ++i) {
            if (pos[a[i]] < 0) {
                pos[a[i]] = e;
                ++e;
            }

            for (int j = 0; j < pos[a[i]]; ++j) {
                sum += w[cur[j]];
            }
            for (int j = pos[a[i]]; j > 0; j--) {
                cur[j] = cur[j - 1];
                pos[cur[j]] = j;
            }
            cur[0] = a[i];
            pos[a[i]] = 0;

        }

        out.println(sum);
    }
}
