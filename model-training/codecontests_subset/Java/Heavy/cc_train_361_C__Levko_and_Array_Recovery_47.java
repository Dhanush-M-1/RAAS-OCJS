import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class A {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        solver.solve();
    }

    private void solve() throws IOException {
        FastScanner sc = new FastScanner(System.in);
//        sc = new FastScanner("4 5\n" +
//                "1 2 3 1\n" +
//                "2 1 2 8\n" +
//                "2 3 4 7\n" +
//                "1 1 3 3\n" +
//                "2 3 4 8\n");
//        sc = new FastScanner("4 5\n" +
//                "1 2 3 1\n" +
//                "2 1 2 8\n" +
//                "2 3 4 7\n" +
//                "1 1 3 3\n" +
//                "2 3 4 13\n");

        int n = sc.nextInt();

        int m = sc.nextInt();

        int[] o = new int[m];
        int[] l = new int[m];
        int[] r = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            o[i] = sc.nextInt();
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] x = new int[n + 1];
        Arrays.fill(x, Integer.MAX_VALUE);

        int[] d = new int[n + 1];

        for (int i = 0; i < m; i++) {
            if (o[i] == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    d[j] += v[i];
                }
            } else if (o[i] == 2) {
                for (int j = l[i]; j <= r[i]; j++) {
                    x[j] = min(x[j], v[i] - d[j]);
                }
            }
        }


        int[] y = x.clone();

        for (int i = 0; i < m; i++) {
            if (o[i] == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    y[j] += v[i];
                }
            } else if (o[i] == 2) {
                int max = y[l[i]];
                for (int j = l[i] + 1; j <= r[i]; j++) {
                    max = max(max, y[j]);
                }
                if (max != v[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
        for (int i = 1; i < n + 1; i++) {
            System.out.print(x[i] < Integer.MAX_VALUE ? x[i] : 0);
            System.out.print(' ');
        }
        System.out.println();
    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream in) throws IOException {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(File file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public FastScanner(String s) {
            br = new BufferedReader(new StringReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
