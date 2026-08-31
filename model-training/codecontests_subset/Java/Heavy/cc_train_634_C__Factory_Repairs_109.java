import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static IOS ios;
    public static void main(String[] args) throws Throwable {
        ios = new IOS("","");
        (new Main()).runner();
        ios.close();
    }

    public void runner() throws Throwable{
        ios.getToken();
        int n = ios.getInt();
        int k = ios.getInt();
        int A = ios.getInt();
        int B = ios.getInt();
        int q = ios.getInt();
        BinaryIndexTree bit_A = new BinaryIndexTree(n, A);
        BinaryIndexTree bit_B = new BinaryIndexTree(n, B);
        for (int i = 0; i < q; ++i) {
            ios.getToken();
            int u, v;
            u = ios.getInt();
            if (u == 1) {
                u = ios.getInt();
                v = ios.getInt();
                bit_A.add(u, v);
                bit_B.add(u, v);
            } else {
                u = ios.getInt();
                v = bit_B.get(u - 1) + bit_A.get(n) - bit_A.get(u + k - 1);
                ios.write(v + "\n");
            }
        }
    }

    class BinaryIndexTree {
        public int n = 0;
        public int C = 0;
        public int[] tree, d;
        public BinaryIndexTree(int _n, int _C) {
            n = _n;
            C = _C;
            tree = new int[n+1];
            d =  new int[n+1];
        }
        public int get(int u) throws Throwable {
            int sum = 0;
            while (u > 0) {
                sum += tree[u];
                u -= u & -u;
            }
            return sum;
        }
        public void add(int u, int v) {
            if (d[u] + v > C) {
                v = C - d[u];
            }
            d[u] += v; int r = u;
            while (u <= n) {
                tree[u] += v;
                u += u & -u;
            }
        }
    }

}

class IOS {
    public BufferedReader inp;
    public BufferedWriter out;
    public String cur;
    public StringTokenizer tok;
    public IOS(String INP, String OUT) throws Throwable {
        inp = new BufferedReader( (INP == "")? (new InputStreamReader(System.in)) : (new FileReader(INP)) );
        out = new BufferedWriter( (OUT == "")? (new OutputStreamWriter(System.out)) : (new FileWriter(OUT)) );
    }
    public void close() throws Throwable {
        out.flush();
        if (inp != null) inp.close();
        if (out != null) out.close();
    }
    public String getLine() throws Throwable {
        return inp.readLine();
    }
    public void getToken() throws Throwable {
        cur = getLine();
        tok = new StringTokenizer(cur);
    }
    public int getInt() throws Throwable {
        return Integer.parseInt(tok.nextToken());
    }
    public long getLong() throws Throwable {
        return Long.parseLong(tok.nextToken());
    }
    public void write(String mess) throws Throwable {
        out.write(mess);
    }
}