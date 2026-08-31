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
            DisjointSet dis = new DisjointSet(N + M);
            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                dis.merge(r, N + c);
                dis.find(r);
                dis.find(N + c);
            }
            int res = -1;
            for (int i = 0; i < N + M; i++) {
                if (dis.find(i) == i) {
                    res++;
                }
            }
            out.println(res);
        }

    }

    static class DisjointSet {
        int[] rank;
        int[] par;

        public DisjointSet(int N) {
            rank = new int[N];
            par = new int[N];
            for (int i = 0; i < N; i++) {
                rank[i] = 1;
                par[i] = i;
            }
        }

        public int find(int x) {
            if (x == par[x]) {
                return x;
            }
            return (par[x] = find(par[x]));
        }

        public void merge(int x, int y) {
            int parX = find(x);
            int parY = find(y);
            if (parX != parY) {
                if (rank[parX] > rank[parY]) {
                    par[parY] = parX;
                    rank[parX] += rank[parY];
                } else {
                    par[parX] = parY;
                    rank[parY] += rank[parX];
                }
            }
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

