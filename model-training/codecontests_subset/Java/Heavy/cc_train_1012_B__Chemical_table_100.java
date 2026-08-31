import java.io.*;
import java.util.*;

public class Main {

    class DSU {
        int[] p;
        int countSets;
        public DSU(int n) {
            p = new int[n];
            for (int i=0; i<n; ++i) p[i] = i;
            countSets = n;
        }

        int getParent(int a){
            if (p[a] == a) return a;
            p[a] = getParent(p[a]);
            return p[a];
        }
        void merge(int a, int b){
            int pA = getParent(a);
            int pB = getParent(b);
            if (pA != pB){
                countSets--;
                p[pA] = pB;
            }
        }
    }


    void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        DSU dsu = new DSU(n + m);
        int q = readInt();
        for (int i=0; i<q; ++i){
            int from = readInt() - 1;
            int to = n + readInt() - 1;
            dsu.merge(from, to);
        }
        out.println(dsu.countSets - 1);
    }

    class Vertex implements Comparable<Vertex> {
        int v, dist;

        public Vertex(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String fileName = "";
    int INF = Integer.MAX_VALUE / 2;
    long MODULO = 1000000007;
    private final static Random rnd = new Random();


    boolean checkBit(long mask, int bit) {
        return (mask & (1l << bit)) > 0;
    }

    ////////////////////////////////////////////////////////////
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        new Main().run();
    }

    void run() throws NumberFormatException, IOException {
        solve();
        out.close();
    }

    ;

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok;
    String delim = " ";

    Main() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            if (fileName.isEmpty()) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader(fileName + ".in"));
                out = new PrintWriter(fileName + ".out");
            }

        }
        tok = new StringTokenizer("");
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (null == nextLine) {
                return null;
            }

            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken(delim);
    }

    int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws NumberFormatException, IOException {
        return Long.parseLong(readString());
    }

    int[] readIntArray(int n) throws NumberFormatException, IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
        }
        return a;
    }

    double readDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(readString());
    }
}