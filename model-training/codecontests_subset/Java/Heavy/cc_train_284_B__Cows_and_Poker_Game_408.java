import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainB {

    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        String s = in.next();
        int cf = 0;
        int ca = 0;
        int ci = 0;
        char c = ' ';
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == 'I') {
                ci++;
            }
            else if (c == 'F') {
                cf++;
            }
            else {
                ca++;
            }
        }
        if (ci > 1) {
            out.println(0);
            return;
        }
        if (ci == 1) {
            out.println(1);
            return;
        }
        out.println(ca);
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] arg) {
        new MainB().run();
    }
}
