import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author P Marecki
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
            int n = in.nextInt();
            int m = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            Dsu d = new Dsu(n);
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                d.merge(u, v);
            }
            Set<Integer> comps = new HashSet<>();
            for (int i = 0; i < n; i++) comps.add(d.root(i));
            Map<Integer, PriorityQueue<Integer>> compElems = new HashMap<>();
            for (int rt : comps) compElems.put(rt, new PriorityQueue<>());
            for (int i = 0; i < n; i++) {
                int rt = d.root(i);
                compElems.get(rt).add(i);
            }
            //loop each component
            //gather p's
            //sort
            //write into res, from largest
            int[] res = new int[n];
            for (int rt : comps) {
                PriorityQueue<Integer> elems = compElems.get(rt);
                PriorityQueue<Integer> vals = new PriorityQueue<>();
                for (int i : elems) {
                    vals.add(-p[i]);
                }
//            System.out.println(elems + " -> " + vals);
                Iterator<Integer> ik = elems.iterator();
                while (ik.hasNext()) {
                    res[ik.next()] = -vals.poll();
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(res[i] + " ");
            }


        }

    }

    static class Dsu {
        private int[] parent;

        Dsu(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
        }

        int root(int v) {
            if (parent[v] < 0) return v;
            else return parent[v] = root(parent[v]);
        }

        void merge(int x, int y) {
            x = root(x);
            y = root(y);
            if (x == y) return;
            if (parent[y] < parent[x]) {
                int t = x;
                x = y;
                y = t;
            }
            parent[x] += parent[y];
            parent[y] = x;
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

