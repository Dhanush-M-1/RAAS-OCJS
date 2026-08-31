import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E1ReadingBooksEasyVersion solver = new E1ReadingBooksEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class E1ReadingBooksEasyVersion {
        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            TreeSet<pair> ts1 = new TreeSet<>();
            TreeSet<pair> ts2 = new TreeSet<>();
            TreeSet<pair> ts3 = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int t1 = sc.nextInt();
                int t2 = sc.nextInt();
                if (t1 == 1 && t2 == 1) ts3.add(new pair(x, t1, t2));
                else if (t1 == 1) ts1.add(new pair(x, t1, t2));
                else if (t2 == 1) ts2.add(new pair(x, t1, t2));
            }
            while (ts1.size() > 0 && ts2.size() > 0) {
                ts3.add(new pair(ts1.pollFirst().a + ts2.pollFirst().a, 1, 1));
            }
            long ans = 0;
            while (k > 0 && ts3.size() > 0) {
                ans += 1l * ts3.pollFirst().a;
                k--;
            }
            pw.println(k == 0 ? ans : -1);
        }

        public class pair implements Comparable<pair> {
            int a;
            int b;
            int c;

            public pair(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            public int compareTo(pair pair) {
                return a - pair.a == 0 ? 1 : a - pair.a;
            }

            public String toString() {
                return a + " " + b + " " + c;
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

