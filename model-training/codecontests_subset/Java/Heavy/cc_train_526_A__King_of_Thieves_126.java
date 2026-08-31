import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class A {
    public void run() throws IOException {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        char[] c = in.next().toCharArray();

        boolean ans = false;
        for (int s = 0; s < n; s++) {
            for (int d = 1; d < n; d++) {
                if (s + 4 * d < n) {
                    boolean ok = true;
                    for (int k = 0; k < 5; k++) {
                        if (c[s + d * k] != '*') {
                            ok = false;
                        }
                    }
                    if (ok) {
                        ans = true;
                    }
                }
            }
        }

        out.println(ans ? "yes" : "no");

        out.close();
    }

    FastScanner in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new A().run();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) throws IOException {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                System.err.println(e);
                System.exit(1);
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}