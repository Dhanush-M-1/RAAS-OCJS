import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        new Main().go();
    }

    PrintWriter out;
    Reader in;
    BufferedReader br;

    Main() throws IOException {

        try {

            //br = new BufferedReader( new FileReader("input.txt") );
            in = new Reader("input.txt");
            out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        }
        catch (Exception e) {

            //br = new BufferedReader( new InputStreamReader( System.in ) );
            in = new Reader();
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
        }
    }

    void go() throws IOException {

        int t = 1;
        int cs = 1;

        while (t > 0) {
            solve();
            //out.println();
            cs++;
            t--;
        }

        out.flush();
        out.close();
    }



    int inf = 2000000000;
    int mod = 1000000007;
    double eps = 0.00000001;

    int n;
    int m;

    ArrayList<Pair>[] g = new ArrayList[200000];
    long[] b, a;
    void solve() throws IOException {

        int n = in.nextInt();
        b = new long[n];
        a = new long[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            b[i] = in.nextLong();

        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();

        for (int i = 1; i < n; i++) {
            int x = in.nextInt()-1;
            int k = in.nextInt();
            g[x].add(new Pair(i, k));
        }

        dfs(0);
        if (b[0] < a[0])
            out.println("NO");
        else
            out.println("YES");
    }

    void dfs(int v) {
        for (Pair p : g[v]) {
            int u = p.a;
            dfs(u);
            if (b[u] > a[u])
                b[v] += b[u] - a[u];
            else
            if (b[u] < a[u])
                b[v] -= mul(p.b, (a[u] - b[u]));
        }
    }

    long mul(long a, long b) {

        if ((long) 10e13 / a + 1 < b)
            return (long) 10e13;
        return a*b;
    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;

        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (b > p.b) return 1;
            if (b < p.b) return -1;
            if (a > p.a) return 1;
            if (a < p.a) return -1;
            return 0;
        }
    }

    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }


        String nextLine() throws IOException {
            return br.readLine();
        }

    }

}