import java.io.*;
import java.util.*;

public class gg {
    FastScanner in;
    PrintWriter out;
    boolean systemIO = true;
    double INF = Integer.MAX_VALUE / 2;

    void solve() {
        int n = in.nextInt();
        String x = in.next();
        for (int i = 1; i < n; i++) {
            if (x.charAt(i) < x.charAt(i - 1)) {
                System.out.println("YES");
                System.out.println(i + " " + (i + 1));
                System.exit(0);
            }
        }
        System.out.println("NO");
    }


    private void run() throws IOException {
        if (systemIO) {
            in = new gg.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            in = new gg.FastScanner(new File("h.in"));
            out = new PrintWriter(new File("h.out"));
        }
        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

    public static void main(String[] arg) throws IOException {
        new gg().run();
    }

}