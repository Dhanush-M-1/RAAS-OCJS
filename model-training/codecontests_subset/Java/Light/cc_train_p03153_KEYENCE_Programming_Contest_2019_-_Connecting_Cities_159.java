import java.io.*;
import java.util.*;
import java.math.*;
// import java.awt.Point;
 
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
 
    static int mod = 1_000_000_007;
    long inf = Long.MAX_VALUE;

    void solve(){
        int n = ni();
        long d = nl();
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = nl();
        }
        long[][] p = new long[n][2];
        for(int i = 0; i < n; i++){
            p[i][0] = a[i];
            p[i][1] = i;
        }
        Arrays.sort(p, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                return Long.compare(a[0],b[0]);
            }
        });
        SegmentTree seg1 = new SegmentTree(n);
        SegmentTree seg2 = new SegmentTree(n);
        ArrayList<int[]> edge = new ArrayList<>();
        for(int i = 0; i < n; i++){
            seg1.update((int)p[i][1], a[(int)p[i][1]]+(int)p[i][1]*d, (int)p[i][1]);
            seg2.update((int)p[i][1], a[(int)p[i][1]]+(n-1-(int)p[i][1])*d, (int)p[i][1]);
            long[] l = seg1.query((int)p[i][1]+1, n);
            long[] r = seg2.query(0, (int)p[i][1]);
            if(l[0]!=inf) edge.add(new int[]{(int)p[i][1], (int)l[1]});
            if(r[0]!=inf) edge.add(new int[]{(int)p[i][1], (int)r[1]});
            // out.println(l[0]+" "+r[0]);
        }
        long[][] e = new long[edge.size()][3];
        for(int i = 0; i < edge.size(); i++){
            e[i][0] = edge.get(i)[0];
            e[i][1] = edge.get(i)[1];
            e[i][2] = Math.abs(e[i][0]-e[i][1])*d + a[(int)e[i][0]] + a[(int)e[i][1]];
        }
        Arrays.sort(e, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                return Long.compare(a[2],b[2]);
            }
        });
        UnionFind uf = new UnionFind(n);
        long ans = 0;
        int size = 0;
        for(int i = 0; i < edge.size(); i++){
            if(uf.same((int)e[i][0], (int)e[i][1])) continue;
            ans += e[i][2];
            uf.union((int)e[i][0], (int)e[i][1]);
            size++;
            if(size==n-1) break;
        }
        out.println(ans);
    }

    class SegmentTree {
        int n;
        long[][] seg;
        SegmentTree(int n) {
            this.n = Integer.highestOneBit(n) << 1;
            this.seg = new long[this.n<<1][2];
            for(int i=0;i<(this.n<<1);++i){
                seg[i][0] = inf;
                seg[i][1] = -1;
            }
        }
        long[] comb(long[] ans1, long[] ans2){
            if(ans1[0]<=ans2[0]){
                return new long[]{ans1[0], ans1[1]};
            }
            return new long[]{ans2[0], ans2[1]};
        }
        void update(int x, long value, int id) {
            x += n - 1;
            this.seg[x][0] = value;
            this.seg[x][1] = id;
            while (x > 0) {
                x = (x - 1) / 2;
                this.seg[x] = comb(this.seg[2 * x + 1], this.seg[2 * x + 2]);
            }
        }
        long[] query(int a,int b,int l,int r,int k){
            if(a<=l&&r<=b) return seg[k];
            if(b<=l||r<=a) return new long[]{inf, -1};
            long[] ans1=query(a,b,l,(l+r)/2,2*k+1);
            long[] ans2=query(a,b,(l+r)/2,r,2*k+2);
            return comb(ans1, ans2);
        }
        long[] query(int l, int r) {
            return query(l,r,0,n,0);
        }
    }

    public static class UnionFind{  
        int parent[];
        int rank[];
        
        public UnionFind(int n){
            parent = new int[n];
            rank   = new int[n];
            
            for(int i = 0;i < n;i++){
                parent[i] = i;
                rank[i]   = 0;
            }        
        }
        
        boolean same(int x,int y){
            return find(x) == find(y);
        }
        
        public int find(int x){
            if(parent[x] == x){
               return x;
            }else{
               return parent[x] = find(parent[x]);   
            }        
        }
          
        public void union(int x,int y){
            x = find(x);
            y = find(y);
            
            if(x != y){
                if(rank[x] > rank[y]){
                   parent[y] = x; 
                }else{
                   parent[x] = y;
                   if(rank[x] == rank[y]){
                       rank[y]++;
                   }
                }            
            }
            
            return;
        }
        
        public int count(int n){
            int ret = 0;
            for(int i = 0;i < n;i++){
                if(i == find(i)){
                    ret++;
                }
            }
            return ret;
        }
          
      } 

    void run() throws Exception
    {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    
    public static void main(String[] args) throws Exception { new Main().run(); }
    
    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;
    
    private int readByte()
    {
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
    
    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b) && b != ' ')){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    
    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    
    private int ni()
    {
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
    
    private long nl()
    {
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
    
    private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
 
}
