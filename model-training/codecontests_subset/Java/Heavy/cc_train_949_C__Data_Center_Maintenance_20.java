import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author anand.oza
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EDataCenterMaintenance solver = new EDataCenterMaintenance();
        solver.solve(1, in, out);
        out.close();
    }

    static class EDataCenterMaintenance {
        int curIndex;
        int[] index;
        int[] lowLink;
        Deque<Integer> stack;
        boolean[] onStack;
        List<Integer>[] edges;
        int[] components;
        int curComp;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt(), h = in.nextInt();

            edges = new List[n];
            for (int i = 0; i < n; i++)
                edges[i] = new ArrayList<>();

            int[] u = new int[n];

            for (int i = 0; i < n; i++) {
                u[i] = in.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;

                if ((u[a] + 1) % h == u[b]) {
                    edges[a].add(b);
                }
                if ((u[b] + 1) % h == u[a]) {
                    edges[b].add(a);
                }
            }

            tarjan();

            int[] size = new int[n];
            for (int i = 0; i < n; i++) {
                size[components[i]]++;
            }

            boolean[] bad = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j : edges[i]) {
                    if (components[j] != components[i])
                        bad[components[i]] = true;
                }
            }

            int best = -1;
            for (int i = 0; i < curComp; i++) {
                if (bad[i]) {
                    continue;
                }

                if (best == -1 || size[i] < size[best]) {
                    best = i;
                }
            }

            out.println(size[best]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (components[i] == best) {
                    sb.append((i + 1) + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            out.println(sb);
        }

        void tarjan() {
            int n = edges.length;

            this.edges = edges;

            curIndex = 0;
            index = new int[n];
            Arrays.fill(index, -1);
            lowLink = new int[n];
            stack = new ArrayDeque<>();
            onStack = new boolean[n];
            components = new int[n];
            Arrays.fill(components, -1);
            curComp = 0;

            for (int i = 0; i < n; i++) {
                if (index[i] == -1) {
                    strongConnect(i);
                }
            }
        }

        void strongConnect(int i) {
            index[i] = curIndex;
            lowLink[i] = curIndex;
            curIndex++;
            stack.addLast(i);
            onStack[i] = true;

            for (int j : edges[i]) {
                if (index[j] == -1) {
                    strongConnect(j);
                    lowLink[i] = Math.min(lowLink[i], lowLink[j]);
                } else if (onStack[j]) {
                    lowLink[i] = Math.min(lowLink[i], index[j]);
                }
            }

            if (lowLink[i] == index[i]) {
                components[i] = curComp;
                for (int j = -1; j != i; ) {
                    j = stack.pollLast();
                    onStack[j] = false;
                    components[j] = curComp;
                }
                curComp++;
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
