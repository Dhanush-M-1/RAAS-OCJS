import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class E extends PrintWriter {

    class Node {
        final int id;
        final Map<Node, Edge> edges = new HashMap<>();

        boolean use = true;

        public Node(int id) {
            this.id = id;
        }
    }

    class Edge {
        final Node u, v;

        boolean use = true;

        public Edge(Node u, Node v) {
            this.u = u;
            this.v = v;
        }
    }

    void run() {
        int n = nextInt(), m = nextInt(), k = nextInt();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Edge[] edges = new Edge[m];

        for (int j = 0; j < m; j++) {
            Node u = nodes[nextInt() - 1], v = nodes[nextInt() - 1];
            edges[j] = new Edge(u, v);
            u.edges.put(v, edges[j]);
            v.edges.put(u, edges[j]);
        }

        Queue<Node> bad = new ArrayDeque<>(n);
        int cnt = n;

        int[] ans = new int[m + 1];

        for (int j = m; j >= 0; j--) {
            ans[j] = cnt;

            if (j == m) {
                for (Node node : nodes) {
                    if (node.edges.size() < k) {
                        node.use = false;
                        bad.add(node);
                    }
                }
            } else {
                if (edges[j].use) {
                    edges[j].use = false;
                    Node u = edges[j].u;
                    Node v = edges[j].v;

                    if (u.use) {
                        u.edges.remove(v);
                        if (u.edges.size() < k) {
                            u.use = false;
                            bad.add(u);
                        }
                    }

                    if (v.use) {
                        v.edges.remove(u);
                        if (v.edges.size() < k) {
                            v.use = false;
                            bad.add(v);
                        }
                    }
                }
            }

            while (!bad.isEmpty()) {
                Node u = bad.poll();
                --cnt;

                for (Iterator<Entry<Node, Edge>> it = u.edges.entrySet().iterator(); it.hasNext();) {
                    Entry<Node, Edge> entry = it.next();
                    Node v = entry.getKey();
                    Edge edge = entry.getValue();
                    if (edge.use) {
                        edge.use = false;
                        if (v.use) {
                            v.edges.remove(u);
                            if (v.edges.size() < k) {
                                v.use = false;
                                bad.add(v);
                            }
                        }
                    }
                    it.remove();
                }

            }

        }

        for (int j = 0; j < m; j++) {
            println(ans[j]);
        }

    }

    void skip() {
        while (hasNext()) {
            next();
        }
    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public E(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        OJ = System.getProperty("ONLINE_JUDGE") != null;
        E solution = new E(System.out);
        if (OJ) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            solution.run();
        } else {
            reader = new BufferedReader(new FileReader(new File(E.class.getName() + ".txt")));
            long timeout = System.currentTimeMillis();
            while (solution.hasNext()) {
                solution.run();
                solution.println();
                solution.println("----------------------------------");
            }
            solution.println("time: " + (System.currentTimeMillis() - timeout));
        }
        solution.close();
        reader.close();
    }
}