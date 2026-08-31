import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.InputStream;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver
    {
        public void solve (InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = in.nextInt() - 1;

            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++)
                g[i] = new ArrayList<Integer>();
            for (int i = 0; i < m; i++)
            {
                int a = in.nextInt() - 1, b = in.nextInt() - 1;
                g[a].add(b);
                g[b].add(a);
            }

            int[] ans = new int[n];

            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++)
                if (!used[i])
                {
                    ArrayList<Integer> comp = new ArrayList<>();
                    dfs(i, g, used, comp);
                    Integer[] what = new Integer[comp.size()];
                    for (int j = 0; j < comp.size(); j++)
                        what[j] = Integer.valueOf(p[comp.get(j)]);
                    Collections.sort(comp);
                    Arrays.sort(what);
                    for (int j = 0; j < comp.size(); j++)
                        ans[comp.get(comp.size() - j - 1)] = what[j];
                }

            for (int i = 0; i < n; i++)
            {
                out.print(ans[i] + 1);
                if (i + 1 == n)
                    out.println();
                else
                    out.print(" ");
            }
        }

        public void dfs (int x, ArrayList<Integer>[] g, boolean[] used, ArrayList<Integer> comp)
        {
            comp.add(x);
            used[x] = true;
            for (int dest : g[x])
                if (!used[dest])
                    dfs(dest, g, used, comp);
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

        public long nextLong()
        {
            return Long.parseLong(next());
        }
    }
}