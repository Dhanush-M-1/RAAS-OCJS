import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            char[] a = sc.next().toCharArray();
            int n = sc.nextInt();
            boolean first[] = new boolean[26], second[] = new boolean[26];
            boolean ok = false;
            while (n-- > 0) {
                char[] b = sc.next().toCharArray();
                if (b[0] == a[0] && b[1] == a[1]) ok = true;
                first[b[0] - 'a'] = true;
                second[b[1] - 'a'] = true;
            }

            if (second[a[0] - 'a'] && first[a[1] - 'a']) ok = true;
            out.println(ok ? "YES" : "NO");
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
                ;
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

