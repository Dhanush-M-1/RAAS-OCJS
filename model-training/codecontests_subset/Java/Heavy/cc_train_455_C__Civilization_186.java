import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
class Node implements Comparable<Node>{
    int i;
    int j;

    int cnt;
    public Node(int i,int j,int cnt){
        this.i=i;
        this.j=j;
        this.cnt=cnt;
    }
    public int compareTo(Node c){
        int t=Integer.compare(c.cnt,this.cnt);
        if(t!=0) return t;
        t=Integer.compare(this.i,c.i);
        if(t!=0) return t;
        t=Integer.compare(this.j,c.j);

        return t;
    }
}

    void solve() {
        int n=ni(),m=ni(),q=ni();
        g=new ArrayList[n+1];
        F=new int[n+1];
        sz=new int[n+1];
        dia=new int[n+1];

        for(int i=1;i<=n;i++){
            g[i]=new ArrayList<>();
            F[i]=i;
            sz[i]=1;

        }
        while(m-->0){
            int x=ni(),y=ni();
            g[x].add(y);
            g[y].add(x);
            union(x,y);
        }
        vis=new boolean[n+1];
        vis2=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                mx=-1;
                dfs(i,0);
                mx=-1;
                dfs2(r,0);
                dia[root(i)]=mx;
            }
        }
        while(q-->0){
            int type=ni();
            if(type==1){
                int x=ni();
                pw.println(dia[root(x)]);
            }else {
                int x=ni(),y=ni();
                union(x,y);
            }
        }

    }
    int mx=-1;
    int r=-1;
    boolean vis[];
    boolean vis2[];
    ArrayList<Integer> g[];
    int F[];
    int sz[];
    int dia[];

    void dfs(int v,int l){
        if(l>mx) {
            mx=l;
            r=v;
        }
        vis[v]=true;
        for(int u : g[v]){
            if(!vis[u]) dfs(u,l+1);
        }
    }
    void dfs2(int v,int l){
        if(l>mx){
            mx=l;
        }
        vis2[v]=true;
        for(int u : g[v]){
            if(!vis2[u])dfs2(u,l+1);
        }
    }

    int root(int a){
        while(a!=F[a]){
            F[a]=F[F[a]];
            a=F[a];
        }
        return a;
    }
    void union(int a,int b){
        int rootA=root(a),rootB=root(b);
        if(rootA==rootB) return;
        if(sz[rootA]>sz[rootB]){
            int tmp=a; a=b; b=tmp;
            tmp=rootA; rootA=rootB; rootB=tmp;
        }
        F[rootA]=rootB;
        sz[rootB]+=sz[rootA];
        dia[rootB]=Math.max(dia[rootB],Math.max(dia[rootA],dia[rootB]/2+dia[rootB]%2+dia[rootA]/2+dia[rootA]%2+1));

    }


    long M= (long)1e9+7;
    InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");

    }
    public static void main(String[] args) throws Exception { new Main().run(); }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }

}