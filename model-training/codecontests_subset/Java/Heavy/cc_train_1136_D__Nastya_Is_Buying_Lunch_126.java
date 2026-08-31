import java.io.*;
import java.util.*;

public class Main {

    class Pair implements Comparable<Pair>
    {
        public long first;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        public long second;

        @Override
        public int compareTo(Pair o) {
            if (first != o.first)
                return Long.compare(first, o.first);
            return Long.compare(second, o.second);
        }
    }

    int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String fileName = "";
    int INF = Integer.MAX_VALUE / 2;
    long MODULO = 1000000007;
    private final static Random rnd = new Random();
    int n, k;
    HashSet<Integer>[] graph;
    void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        graph = new HashSet[n];
        int[] arr = new int[n];

        for (int i=0; i<n; ++i){
            arr[i] = readInt() - 1;
            graph[i] = new HashSet<>();
        }

        for (int i=0; i<m; ++i){
            int from = readInt() - 1;
            int to = readInt() - 1;
            graph[to].add(from);
        }
        int[] count = new int[n];
        int me = arr[n - 1];
        int ans = 0;
        int countGood = 0;
        for (int i=n-2; i>=0; --i){
            if (graph[me].contains(arr[i]) && count[arr[i]] == n - 2 - i - countGood){
                ans++;
                countGood++;
                continue;
            }
            for (int to: graph[arr[i]]){
                count[to]++;
            }
        }
        out.println(ans);
    }

    boolean checkBit(long mask, int bit){
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
        return tok.nextToken(delim);
    }

    int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws NumberFormatException, IOException {
        return Long.parseLong(readString());
    }
    int[] readIntArray (int n) throws NumberFormatException, IOException {
        int[] a = new int[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        return a;
    }
    double readDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(readString());
    }
}