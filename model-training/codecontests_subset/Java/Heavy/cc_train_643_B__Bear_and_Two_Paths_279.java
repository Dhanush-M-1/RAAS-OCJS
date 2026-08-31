import java.io.OutputStream;
import java.util.Locale;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collection;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author AlexFetisov
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB_Constr solver = new TaskB_Constr();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB_Constr {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int D = in.nextInt();
            if (k <= n || n == 4) {
                out.println(-1);
                return;
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(A);
            list.add(C);
            for (int i = 1; i <= n; ++i) {
                if (i != A && i != B && i != C && i != D) {
                    list.add(i);
                }
            }
            list.add(D);
            list.add(B);
            out.println(ArrayUtils.toString(list));

            list.set(0, C);
            list.set(1, A);

            list.set(n - 1, D);
            list.set(n - 2, B);
            out.println(ArrayUtils.toString(list));
        }

    }

    static class ArrayUtils {
        public static String toString(Collection<Integer> collection) {
            StringBuilder result = new StringBuilder("");
            for (int x : collection) {
                result.append(x).append(" ");
            }
            return result.substring(0, result.length() - 1);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String nextString() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }
}

