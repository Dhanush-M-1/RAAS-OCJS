import java.io.*;
import java.util.StringTokenizer;


public class ProblemB {
    static class ProblemSolver {
        int[] a_chars = new int[31];
        int[] b_chars = new int[31];
        int[] c_chars = new int[31];

        void solve(FastReader in, PrintWriter out) {
            String a = in.nextToken();
            String b = in.nextToken();
            String c = in.nextToken();

            /*String a = "abbbaaccca";
            String b = "ab";
            String c = "aca";   */

            for (int i = 0; i < a.length(); i++) a_chars[a.charAt(i) - 'a']++;
            for (int i = 0; i < b.length(); i++) b_chars[b.charAt(i) - 'a']++;
            for (int i = 0; i < c.length(); i++) c_chars[c.charAt(i) - 'a']++;

            int best_sum = 0;
            int best_b = -1;
            int best_c = -1;
            for (int n = 0; n < a.length(); n++) {
                boolean ok = true;
                int m = a.length();
                for (int k = 0; k <= 26; k++) {
                    if (b_chars[k] * n > a_chars[k]) {
                        ok = false;
                        break;
                    }
                    if (c_chars[k] > 0) m = Math.min(m, ((a_chars[k] - b_chars[k] * n) / c_chars[k]));
                }
                if (!ok) break;
                if (best_sum < n + m) {
                    best_sum = n + m;
                    best_b = n;
                    best_c = m;
                }

            }
            String ans = a;
            if (best_sum > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < best_b; i++) sb.append(b);
                for (int i = 0; i < best_c; i++) sb.append(c);
                for (int i = 0; i <= 26; i++) {
                    for (int k = a_chars[i] - best_b * b_chars[i] - best_c * c_chars[i]; k > 0; k--)
                        sb.append((char) ('a' + i));
                }
                ans = sb.toString();
            }
            out.println(ans);
        }
    }

    /* ========================================================== */

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new ProblemSolver().solve(in, out);
        out.close();
    }

    static class FastReader extends BufferedReader {
        private StringTokenizer st;

        public FastReader(InputStream is) {
            super(new InputStreamReader(is));
        }

        public String nextToken() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(readLine());
                }
                return st.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public int[] nextArrayInt(int size) {
            int[] ret = new int[size];
            for (int i = 0; i < size; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
    }
}
