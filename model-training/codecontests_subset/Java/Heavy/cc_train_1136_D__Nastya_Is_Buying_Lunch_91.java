import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] perm = new int[N];
            ArrayList<Integer>[] arr = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                perm[i] = in.nextInt() - 1;
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                arr[in.nextInt() - 1].add(in.nextInt() - 1);
            }
            HashSet<Integer> behind = new HashSet<>();
            int res = 0;
            behind.add(perm[N - 1]);
            for (int i = N - 2; i >= 0; i--) {
                int curPas = 0;
                for (int j : arr[perm[i]]) {
                    if (behind.contains(j)) {
                        curPas++;
                    }
                }
                if (curPas == behind.size()) {
                    res++;
                } else {
                    behind.add(perm[i]);
                }
            }
            out.println(res);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

