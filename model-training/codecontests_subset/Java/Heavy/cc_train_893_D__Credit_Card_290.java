import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static Reader in = new Reader();
    public static void main(String[] args) throws IOException {
        Main solver = new Main();
        solver.solve();
        out.flush();
        out.close();
 
    }
 
    static int INF = (int)1e9;
    static int maxn = (int)1e5+5;
    static int mod  = 998244353;
    static int n,m,q,k,t;
    
    static ArrayList<Integer> adj[];
    static int[] c;
    static boolean[] vis;
    
    void solve() throws IOException{
        n = in.nextInt();
        int d = in.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        
        long[] pre = new long[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i-1]+arr[i];
        
        long[] max = new long[n];
        max[n-1] = 0;
        TreeSet<Long> set = new TreeSet<Long>();
        
        long tmp = 0;
        for (int i = n-1; i > 0; i--) {
            set.add(-pre[i]);
            tmp = -set.first();
            max[i] = tmp-pre[i-1];
        }
        set.add(-pre[0]);
        max[0] = -set.first();
        
        long cur = 0;
        boolean flag = true;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cur+max[i] > d) flag = false;
            if (arr[i] == 0 && cur < 0) {
                tmp = d-(cur+max[i]);
                cur+= tmp;
                ans++;
                if (cur < 0) flag = false;
            }
            cur+=arr[i];
        }
        
        if (flag) out.println(ans);
        else out.println(-1);
    }
    
    //<>
    static int tmp;
    static void dfs(int s) {
        vis[s] = true;
        tmp = Math.min(tmp, c[s]);
        for (int e:adj[s]) {
            if (!vis[e]) {
                dfs(e);
            }
        }
    }
    
    static class Reader {
 
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
 
    public Reader() {
        this(System.in);
    }
 
    public Reader(InputStream is) {
        mIs = is;
    }
 
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
 
    }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }
 
    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
 
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
 
    }
}