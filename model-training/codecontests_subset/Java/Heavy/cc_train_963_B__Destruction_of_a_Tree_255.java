import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader fi = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, fi, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader fi, PrintWriter out) {
            int i, j, n, a, b, k,m,root;
            n=fi.nextInt();
            m=n-1;
            root=1;
            Graph g=new Graph(n,m);
            for (i=1;i<=n;i++){
                int x=fi.nextInt();
                if (x!=0){
                    g.addEdge(i,x);
                }
                    else {
                        root=i;
                        //g.degree[i]++;
                    }
                }

            g.dfs(root,-1);


            if (g.ans.size()==n) {
                out.println("YES");
                for (int u : g.ans) out.println(u);
            }
            else out.println("NO");
        }
    }
}


class Graph{
    int n,m;
    ArrayList<Integer> adj[];
    int degree[];
    boolean del[];
    ArrayList<Integer> ans;
    Graph(int n,int m){
        this.n=n;
        this.m=m;
        adj=new ArrayList[n+1];
        for (int i=0;i<=n ;i++ ) {
            adj[i]=new ArrayList<>();
        }
        ans=new ArrayList<>();
        degree=new int[n+1];
        del=new boolean[n+1];
    }

    void addEdge(int i,int j){
        adj[i].add(j);
        adj[j].add(i);
        degree[i]++;
        degree[j]++;
    }

    void dfs(int u,int pr){
       // System.out.println(" u = " + u + " pr " +pr);
        for (int v : adj[u]){
            if (v!=pr)
                dfs(v,u);
        }
        if (degree[u]%2==0)
            del(u,pr);
        }

    void del(int u,int par){
        //System.out.println(" del u = " + u + " pr " +par);

        if (degree[u]%2!=0) return;

        //now delete u
        del[u]=true;
        ans.add(u);
        for (int v : adj[u]) degree[v]--;   //deleting all its edges

        for (int v : adj[u]){
            if (v!=par && !del[v]) del(v,u);    //now delete its subtree
        }
    }





}



class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int snext() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = snext();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = snext();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n+1];
        for (int i = 1; i <= n; i++)
            a[i] = nextInt();
        return a;
    }

    public String readString() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = snext();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}