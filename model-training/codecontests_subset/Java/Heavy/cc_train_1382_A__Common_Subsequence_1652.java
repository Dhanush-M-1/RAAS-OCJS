import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
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
        ACommonSubsequence solver = new ACommonSubsequence();
        solver.solve(1, in, out);
        out.close();
    }

    static class ACommonSubsequence {
        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = sc.nextInt();
            while (q-- > 0) {
                int n = sc.nextInt(), m = sc.nextInt();
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++)
                    set.add(sc.nextInt());
                int a = -1;
                for (int i = 0; i < m; i++) {
                    int x = sc.nextInt();
                    if (set.contains(x))
                        a = x;
                }
                if (a == -1) {
                    pw.println("NO");
                } else {
                    pw.println("YES");
                    pw.println(1 + " " + a);
                }
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

