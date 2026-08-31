import java.io.*;
import java.util.*;

public class Main {
    static OutWriter out;
    static InReader in;
    static long X = (long) (1e7);


    public static void main(String args[]) throws IOException {
        in = new InReader();
        out = new OutWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        Edge edges[] = new Edge[m];
        ArrayList<Integer> to[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            to[i] = new ArrayList();
        }
        Vertex G[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            G[i] = new Vertex(i, 0);
        }
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(in.nextInt() - 1, in.nextInt() - 1);
            to[edges[i].to].add(edges[i].from);
            to[edges[i].from].add(edges[i].to);
            G[edges[i].from].deg++;
            G[edges[i].to].deg++;
        }
        TreeSet<Vertex> all = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            all.add(G[i]);
        }
        boolean killed[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = m - 1; i >= 0; i--) {
            while (all.size() != 0 && all.first().deg < k) {
                Vertex curr = all.pollFirst();
                if (!killed[curr.number]) {
                    killed[curr.number] = true;
                    for (int j = 0; j < to[curr.number].size(); j++) {
                        int v = to[curr.number].get(j);
                        if (!killed[v]) {
                            all.remove(G[v]);
                            G[v].deg--;
                            all.add(G[v]);
                        }
                    }
                }
            }
            ans.add(all.size());
            int a = edges[i].from;
            int b = edges[i].to;
            all.remove(G[a]);
            all.remove(G[b]);
            to[a].remove(new Integer(b));
            to[b].remove(new Integer(a));
            if(killed[a] || killed[b]){

            }else {
                G[a].deg--;
                G[b].deg--;
            }
            all.add(G[a]);
            all.add(G[b]);

        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            out.println(ans.get(i));
        }


        out.close();
    }

    static class Vertex implements Comparable<Vertex> {
        int number;
        int deg;

        Vertex(int number, int deg) {
            this.number = number;
            this.deg = deg;
        }

        @Override
        public int compareTo(Vertex o) {
            if (deg != o.deg) {
                return deg - o.deg;
            } else {
                return number - o.number;
            }
        }
    }



   /* static class Vertex {
        int number = -1;
        int depth = 0;
        boolean used2 = false;
        boolean used = false;
        long value = 0;
        ArrayList<Edge> to = new ArrayList();


    }*/


    static class Edge {
        int to;
        int from;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static class InReader {
        BufferedReader in;

        InReader(String name) throws IOException {
            in = new BufferedReader(new FileReader(name));
        }

        InReader() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        StringTokenizer token = new StringTokenizer("");

        void update() throws IOException {
            if (!token.hasMoreTokens()) {
                String a = in.readLine();
                if (a != null) {
                    token = new StringTokenizer(a);
                }
            }
        }

        int nextInt() throws IOException {
            update();
            return Integer.parseInt(token.nextToken());
        }

        long nextLong() throws IOException {
            update();
            return Long.parseLong(token.nextToken());
        }

        double nextDouble() throws IOException {
            update();
            return Double.parseDouble(token.nextToken());
        }

        boolean hasNext() throws IOException {
            update();
            return token.hasMoreTokens();
        }

        String next() throws IOException {
            update();
            return token.nextToken();
        }
    }

    static class OutWriter {
        PrintWriter out;

        OutWriter() {
            out = new PrintWriter(System.out);
        }

        OutWriter(String name) throws IOException {
            out = new PrintWriter(new FileWriter(name));
        }

        StringBuilder cout = new StringBuilder();

        <T> void print(T a) {
            cout.append(a);
        }

        <T> void println(T a) {
            cout.append(a);
            cout.append('\n');
        }

        <T> void prints(T a) {
            cout.append(a);
            cout.append(' ');
        }

        void close() {
            out.print(cout.toString());
            out.close();
        }
    }
}

