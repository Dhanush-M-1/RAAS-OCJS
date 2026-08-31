/* CRAP!!! I AM A WEB-DESIGNER!!! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Anna on 24.09.2016.
 */
public class TaskD {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        TaskD task = new TaskD();
        task.open();
        task.solve();
        task.close();
    }

    class Edge {
        int ind;
        int a, b;
        long weight;
        boolean variable;

        public Edge(int ind, int a, int b, long weight, boolean variable) {
            this.ind = ind;
            this.a = a;
            this.b = b;
            this.weight = weight;
            this.variable = variable;
        }

        public int getOther(int v) {
            if (a == v) return b;
            else return a;
        }

    }

    ArrayList<Edge> edges;
    ArrayList<Edge>[] graph;
    int n;
    int m;
    int L;
    int start;
    int finish;

    long INFINITY;

    boolean[] cannotDeik;
    long[] marks;

    private long deikstra() {

        PriorityQueue<long[]> mins = new PriorityQueue<>((p, q) -> Long.compare(p[1], q[1]));
        marks = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == start) continue;
            marks[i] = INFINITY;
            mins.offer(new long[]{i, INFINITY});
        }
        marks[start] = 0;
        mins.offer(new long[]{start, 0});

        while (!mins.isEmpty()) {
            long[] minEdge = mins.poll();
            int minInd = (int) minEdge[0];
            if (minInd == finish) break;
            long minMark = minEdge[1];
            if (minMark == INFINITY) break;
            for (Edge edge : graph[minInd]) {
                if (cannotDeik[edge.ind]) continue;
                int other = edge.getOther(minInd);
                if (minMark + edge.weight < marks[other]) {
                    marks[other] = minMark + edge.weight;
                    mins.offer(new long[]{other, marks[other]});
                }
            }
        }
        return marks[finish];
    }


    /*boolean[] usedCheck;

    Edge checkVariableInShortestPath(int v, long cur) {
        usedCheck[v] = true;
        for (Edge edge : graph[v]) {
            int otherV = edge.getOther(v);
            if (usedCheck[otherV]) continue;
            if (marks[otherV] + cur + edge.weight == marks[finish]) {
                if (edge.variable) return edge;
                else return checkVariableInShortestPath(otherV, cur + edge.weight);
            }
        }
        return null;
    }*/

    ArrayList<Edge> getAllPathVariables() {
        ArrayList<Edge> edges = new ArrayList<>();
        int current = finish;
        long curWay = 0;
        long length = marks[finish];

        while (current != start) {
            for (Edge edge : graph[current]) {
                int other = edge.getOther(current);
                if (marks[other] + edge.weight + curWay == length) {
                    if (edge.variable) edges.add(edge);
                    current = other;
                    curWay += edge.weight;
                    break;
                }
            }
        }

        return edges;
    }

    private void solve() throws IOException {
        n = nextInt();
        m = nextInt();
        L = nextInt();
        start = nextInt();
        finish = nextInt();

        INFINITY = L + 1;

        edges = new ArrayList<>();
        graph = new ArrayList[n];
        cannotDeik = new boolean[m];
//        usedCheck = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            int w = nextInt();
            final boolean variable = w == 0;
            Edge edge = new Edge(i, a, b, w, variable);
            cannotDeik[i] = variable;
            graph[a].add(edge);
            graph[b].add(edge);
            edges.add(edge);
        }

        long shortestSure = deikstra();

        if (shortestSure < L) {
            out.println("NO");
            return;
        }

        Arrays.fill(cannotDeik, false);

        for (Edge edge : edges) {
            if (edge.variable) {
                edge.weight = 1;
            }
        }

        long curShortest = deikstra();

        if (curShortest > L) {
            out.println("NO");
            return;
        }

        ArrayList<Edge> extra = getAllPathVariables();

        for (Edge edge : edges) {
            if (edge.variable) {
                edge.weight = INFINITY;
                edge.variable = false;
            }
        }

        for (Edge edge : extra) {
            edge.weight = 1;
            edge.variable = true;
        }

        while (curShortest != L) {
            ArrayList<Edge> edgesVar = getAllPathVariables();
            if (edgesVar.size() == 0) break;
            edgesVar.get(0).variable = false;
            edgesVar.get(0).weight += L - curShortest;
            curShortest = deikstra();
        }

        out.println("YES");
        StringBuilder answer = new StringBuilder();
        for (Edge edge : edges) {
            answer.append(edge.a).append(" ").append(edge.b).append(" ").append(edge.weight).append("\n");
        }
        out.println(answer);
    }

    private void close() {
        out.flush();
        out.close();
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            st = new StringTokenizer(str);
        }
        return st.nextToken();
    }


    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private double nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

}