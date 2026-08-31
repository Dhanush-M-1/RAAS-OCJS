
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    String fileName = "";
    //////////////////////    SOLUTION   SOLUTION  SOLUTION    //////////////////////////////
    Long INF = Long.MAX_VALUE;
    long MODULO = 1000_000_000 + 7;
    int MAX_VALUE = 1000_1000;
    int[][] steps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private final static Random rnd = new Random();
    double eps = 1e-4;
    int[][] graph;
    int curColor = 0;
    int[] colors;
    ArrayList<Integer>[] comp;
    void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        comp = new ArrayList[n];
        int[] arr = new int[n];
        for (int i=0; i<n; ++i){
            comp[i] = new ArrayList<>();
            arr[i] = readInt() - 1;
        }
        graph = new int[n][];
        colors = new int[n];
        Arrays.fill(colors, -1);
        readUndirectedGraph(n, m, graph);
        for (int i=0; i<n; ++i){
            if (colors[i] == -1){
                comp[curColor].add(i);
                dfs(i);
                curColor++;
            }
        }

        int[] ans = new int[n];
        boolean[] usedColors = new boolean[n];
        for (int i=0; i<n; ++i){
            if (usedColors[colors[i]]) continue;
            Collections.sort(comp[i]);
            ArrayList<Integer> curVals = new ArrayList<>();
            for (int to: comp[i]) curVals.add(arr[to]);
            Collections.sort(curVals);
            Collections.reverse(curVals);
            for (int j=0; j<comp[i].size(); ++j){
                ans[comp[i].get(j)] = curVals.get(j);
            }
        }
        for (int to: ans) out.print(to + 1 + " ");

    }
    void dfs(int from){
        colors[from] = curColor;
        for (int to: graph[from]){
            if (colors[to] == -1){
                comp[curColor].add(to);
                dfs(to);
            }
        }
    }

    class Point implements Comparable<Point>{
        double x, y;
        int ind;

        public Point(double x, double y, int ind) {
            this.x = x;
            this.y = y;
            this.ind = ind;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(this.x, o.x);
        }
    }

    class Fenwik {
        int[] t;
        int n;
        Fenwik(int n){
            t = new int[n];
            this.n = n;
        }

        void inc(int r, int delta){
            for (; r < n; r = r | (r + 1)) t[r] += delta;
        }
        int getSum(int r){
            int res = 0;
            for (; r >=0; r = (r & (r + 1) ) - 1) res += t[r];
            return res;
        }
    }
    boolean isPrime(int n){
        for (int i=2; i*i<=n; ++i){
            if (n%i==0) return false;
        }
        return true;
    }
    class Edge implements Comparable<Edge>{
        int from, to, num, dist;
        Edge(int from, int to, int dist, int num){
            this.from = from;
            this.to = to;
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }


    class Segment{
        Point p1, p2;
        public Segment(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    Point readPoint(int ind) throws IOException{
        return new Point(readInt(), readInt(), ind);
    }
    class Number implements Comparable<Number>{
        int x, cost;
        Number(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    void readUndirectedGraph (int n, int m, int[][] graph) throws IOException{
        Edge[] edges = new Edge[m];
        int[] countEdges = new int[n];
        for (int i=0; i<m; ++i){
            int from = readInt() - 1;
            int to = readInt() - 1;
            countEdges[from]++;
            countEdges[to]++;
            edges[i] = new Edge(from, to, 0, 0);
        }
        for (int i=0; i<n; ++i) {
            graph[i] = new int[countEdges[i]];
        }
        for (int i=0; i<m; ++i){
            graph[edges[i].from][--countEdges[edges[i].from]] = edges[i].to;
            graph[edges[i].to][-- countEdges[edges[i].to]] = edges[i].from;
        }
    }
    class Vertex implements Comparable<Vertex>{
        int i, j, plus;
        Vertex(int i, int j, int plus){
            this.i = i;
            this.j = j;
            this.plus = plus;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.plus, o.plus);
        }
    }



    ///////////////////////////////////////////////////////////////////////////////////////////

    class Dsu{
        int[] parent;
        int countSets;
        Dsu(int n){
            parent = new int[n];
            countSets = n;
            for (int i=0; i<n; ++i){
                parent[i] = i;
            }
        }
        int findSet(int a){
            if (a == parent[a]) return a;
            parent[a] = findSet(parent[a]);
            return parent[a];
        }
        void unionSets(int a, int b){
            a = findSet(a);
            b = findSet(b);
            if (a != b){
                parent[a] = b;
                countSets--;
            }
        }
    }

    class SparseTable{
        int[][] rmq;
        int[] logTable;
        int n;
        SparseTable(int[] a){
            n = a.length;
            logTable = new int[n+1];
            for(int i = 2; i <= n; ++i){
                logTable[i] = logTable[i >> 1] + 1;
            }
            rmq = new int[logTable[n] + 1][n];
            for(int i=0; i<n; ++i){
                rmq[0][i] = a[i];
            }

            for(int k=1; (1 << k) < n; ++k){
                for(int i=0; i + (1 << k) <= n; ++i){
                    int max1 = rmq[k - 1][i];
                    int max2 = rmq[k-1][i + (1 << (k-1))];
                    rmq[k][i] = Math.max(max1, max2);
                }
            }
        }

        int max(int l, int r){
            int k = logTable[r - l];
            int max1 = rmq[k][l];
            int max2 = rmq[k][r - (1 << k) + 1];
            return Math.max(max1, max2);
        }
    }
    long checkBit(long mask, int bit){
        return (mask >> bit) & 1;
    }

    static int checkBit(int mask, int bit) {
        return (mask >> bit) & 1;
    }
    boolean isLower(char c){
        return c >= 'a' && c <= 'z';
    }

    ////////////////////////////////////////////////////////////



    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
    long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a%b);
    }
    double binPow(double a, int pow){
        if (pow == 0) return 1;
        if (pow % 2 == 1) {
            return a * binPow(a, pow - 1);
        } else {
            double c = binPow(a, pow / 2);
            return c * c;
        }
    }
    long binPow(long a, long b, long m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 1) {
            return ((a % m) * (binPow(a, b - 1, m) % m)) % m;
        } else {
            long c = binPow(a, b / 2, m);
            return (c * c) % m;
        }

    }
    int minInt(int... values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) min = Math.min(min, value);
        return min;
    }

    int maxInt(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) max = Math.max(max, value);
        return max;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        new Main().run();
    }

    void run() throws NumberFormatException, IOException {
        solve();
        out.close();
    };

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
        return tok.nextToken();
    }

    int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(readString());
    }
    byte readByte() throws NumberFormatException, IOException {
        return Byte.parseByte(readString());
    }
    int[] readIntArray (int n) throws NumberFormatException, IOException {
        int[] a = new int[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        return a;
    }

    Integer[] readIntegerArray (int n) throws NumberFormatException, IOException {
        Integer[] a = new Integer[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        return a;
    }

    long readLong() throws NumberFormatException, IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(readString());
    }
}