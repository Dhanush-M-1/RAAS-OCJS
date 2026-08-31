import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author OmarYasser
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            char[] a = sc.next().toCharArray(), b = sc.next().toCharArray(), c = sc.next().toCharArray();
            int[] cntA = cnt(a), cntB = cnt(b), cntC = cnt(c);
            int canB = max(cntA, cntB);
            int best = canB, fromB = canB;
            for (int willB = 0; willB <= canB; willB++) {
                int[] newA = subtract(cntA, cntB, willB);
                int canC = max(newA, cntC);
                if (canC + willB > best) {
                    best = canC + willB;
                    fromB = willB;
                }
            }
            StringBuilder res = new StringBuilder();
            res = res.append(append(b, fromB));
            res = res.append(append(c, best - fromB));
            cntA = subtract(cntA, cntB, fromB);
            cntA = subtract(cntA, cntC, best - fromB);
            for (int i = 0; i < 26; i++)
                while (cntA[i]-- > 0) res.append((char) (i + 'a'));
            out.println(res);
        }

        static int[] subtract(int[] a, int[] b, int cnt) {
            int[] res = a.clone();
            for (int i = 0; i < 26; i++)
                res[i] -= b[i] * cnt;
            return res;
        }

        StringBuilder append(char[] a, int cnt) {
            StringBuilder res = new StringBuilder();
            for (char c : a) res.append(c);
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < cnt; i++)
                ret.append(res);
            return ret;
        }

        int max(int[] cnt1, int[] cnt2) {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++)
                if (cnt2[i] != 0)
                    res = Math.min(res, cnt1[i] / cnt2[i]);
            return res;
        }

        int[] cnt(char[] a) {
            int[] res = new int[26];
            for (char c : a) res[c - 'a']++;
            return res;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
            return st.nextToken();
        }

    }
}

