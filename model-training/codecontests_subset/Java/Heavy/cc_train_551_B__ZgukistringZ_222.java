import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mostafa
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ProblemBZgukistringZ solver = new ProblemBZgukistringZ();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemBZgukistringZ {
        final int MAX = 26;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            char[] c = in.next().toCharArray();
            int[] fa = freq(a);
            int[] fb = freq(b);
            int[] fc = freq(c);

            StringBuilder sb = new StringBuilder();
            while (true) {
                int c1 = countMax(fa, fb);
                int c2 = countMax(fa, fc);
                if (c1 + c2 == 0)
                    break;
                if (c1 > c2)
                    add(sb, fa, b);
                else
                    add(sb, fa, c);
            }
            for (int i = 0; i < MAX; i++)
                while (fa[i]-- > 0)
                    sb.append((char) (i + 'a'));
            out.println(sb.toString());
        }

        void add(StringBuilder sb, int[] fa, char[] a) {
            for (char c : a) {
                fa[c - 'a']--;
                sb.append(c);
            }
        }

        int countMax(int[] s, int[] i) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < MAX; j++)
                if (i[j] != 0)
                    max = Integer.min(max, s[j] / i[j]);
            return max;
        }

        int[] freq(final char[] a) {
            int[] f = new int[MAX];
            for (char c : a) {
                f[c - 'a']++;
            }
            return f;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

    }
}

