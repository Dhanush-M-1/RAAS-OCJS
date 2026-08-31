import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Collections;
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
        ProblemEConnectedComponents solver = new ProblemEConnectedComponents();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemEConnectedComponents {
        TreeSet<Integer> unvisited = new TreeSet<>();
        HashSet<Integer>[] vs;
        DSU dsu;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            vs = new HashSet[n + 1];
            for (int i = 1; i <= n; ++i) {
                unvisited.add(i);
                vs[i] = new HashSet<>();
            }
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt();
                int v = in.nextInt();
                vs[u].add(v);
                vs[v].add(u);
            }
            dsu = new DSU(n + 1);
            while (!unvisited.isEmpty()) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.addLast(unvisited.first());
                while (!q.isEmpty()) {
                    int node = q.pollFirst();
                    if (unvisited.isEmpty()) continue;
                    for (Integer i = unvisited.first(); i != null; i = unvisited.higher(i)) {
                        if (!vs[node].contains(i)) {
                            dsu.union(node, i);
                            unvisited.remove(i);
                            q.addLast(i);
                        }
                    }
                }
            }
            HashMap<Integer, Integer> countID = new HashMap<>();
            for (int i = 1; i <= n; ++i) {
                countID.put(dsu.get(i), countID.getOrDefault(dsu.get(i), 0) + 1);
            }
            ArrayList<Integer> sorted = new ArrayList<>(countID.values());
            Collections.sort(sorted);
            out.println(sorted.size());
            for (int i : sorted) {
                out.print(i + " ");
            }
        }

    }

    static class DSU {
        public int[] id;
        public int size;

        public DSU(int x) {
            size = x;
            id = new int[size];
            for (int i = 0; i < size; ++i) {
                id[i] = i;
            }
        }

        public int get(int a) {
            return id[a] == a ? a : (id[a] = get(id[a]));
        }

        public void union(int a, int b) {
            if (get(a) == get(b)) return;
            id[get(a)] = id[get(b)];
            --size;
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

