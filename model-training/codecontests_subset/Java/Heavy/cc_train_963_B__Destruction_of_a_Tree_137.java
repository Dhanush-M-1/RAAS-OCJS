import java.util.*;
import java.io.*;
public class Main {

    void solve(){
        int n=ni();
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++) graph[i]=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int x=ni();
            if(x!=0){
//                deg[x]++; deg[i]++;
                graph[x].add(i); graph[i].add(x);
            }
        }
        if(n%2==0){
            pw.println("NO");
            return;
        }
        pw.println("YES");
        sz=new int[n+1];
        vis=new boolean[n+1];

        dfs1(1,-1);
        Arrays.fill(vis,false);
        dfs(1,-1);
        pw.println(ans);

    }
    ArrayList<Integer> graph[];
    StringBuilder ans=new StringBuilder();

    int sz[];
    boolean vis[];
    void dfs(int v,int pr){
        vis[v]=true;
        for(int u : graph[v]){
            if(!vis[u] && sz[u]%2==0) dfs(u,v);
        }
        ans.append(v+"\n");
        for(int u : graph[v]){
            if(!vis[u] && sz[u]%2==1) dfs(u,v);
        }
    }
    int dfs1(int v,int pr) {
        vis[v]=true;
        int cc=0;
        for (int u : graph[v]) {
            if (!vis[u]) {
                cc+=dfs1(u,v);
            }

        }
        sz[v]=cc+1;
        return cc+1;

    }
    long M=(long)1e9+9;
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

    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}