import java.io.*;
import java.math.BigInteger;
import java.util.*;

// written by luchy0120

public class Main {
    public static void main(String[] args) throws Exception {

        new Main().run();
    }


    int color[],dfn[],low[],stack[],cnt[];
    boolean vis[];
    boolean iscut[];
    int deep,top,n,m,sum,ans;
    List<Integer> g[];

    void tarjan(int u,int fa)
    {
        int child = 0;
        dfn[u]=++deep;
        low[u]=deep;
        vis[u]=true;
        stack[++top]=u;
        int sz=g[u].size();
        for(int i=0;i<sz;i++)
        {
            int v =g[u].get(i);
            if(v==fa) continue;
            if(dfn[v]==0)
            {
                child++;
                tarjan(v,u);
                low[u]=Math.min(low[u],low[v]);

            }
            else
            {
                if(vis[v])
                {
                    low[u]=Math.min(low[u],low[v]);
                }
            }
        }
        if(fa<0&&child==1){
            iscut[u] =true;
        }

        if(dfn[u]==low[u])
        {
            iscut[u] = true;
            color[u]=++sum;
            vis[u]=false;
            while(stack[top]!=u)
            {
                color[stack[top]]=sum;
                vis[stack[top--]]=false;
            }
            top--;
        }
    }
    boolean hasV  = false;
    boolean hasU  = false;
    long ct = 0;
    void dfs(int u,int fa,int a,int b){
        ct++;
        vis[u] = true;
        int sz=g[u].size();
        for(int i=0;i<sz;i++) {
            int v = g[u].get(i);
            if (v == fa) continue;
            if(vis[v]) continue;
            if(v==a){
                hasV = true;
                continue;
            }
            if(v==b){
                hasU = true;
                continue;
            }
            dfs(v,u,a,b);


        }
    }

    void solve(){
        int t = ni();
        for(int i=0;i<t;++i){
            int n = ni();
            int m = ni();
            int a = ni()-1;
            int b = ni()-1;
            g = new ArrayList[n];
            for(int j=0;j<n;++j){
                g[j] = new ArrayList<>();
            }

            for(int j=0;j<m;++j){
                int u  = ni()-1;
                int v  = ni()-1;
                g[u].add(v);
                g[v].add(u);

            }

                vis = new boolean[n];
                long c =1;
                long suan[] = new long[2];
                for(int j=0;j<n;++j){
                    if(j==a||j==b||vis[j]) continue;
                    ct = 0;
                    hasV  = false;
                    hasU  = false;
                    dfs(j,-1,a,b);

                    if(hasV&&hasU){

                    }else if(hasV){
                        suan[0]+=ct;
                    }else if(hasU) {
                        suan[1] += ct;
                    }
                }
                println(suan[0]*suan[1]);



        }

    }



//    int get_room(int i,int j){
//        return i/3*3 + j/3;
//    }

//    int a[][] = new int[9][9];
//    int space = 0;
//
//    boolean vis_row[][] = new boolean[9][10];
//    boolean vis_col[][] = new boolean[9][10];
//    boolean vis_room[][] = new boolean[9][10];
//    int val[][][] =new int[9][9][];
//    int prepare[][];
//
//    void dfs(int rt){
//
//    }


//    int gt(char v){
//        if(v=='('){
//            return 4;
//        }else if(v=='+'||v=='-'){
//            return 1;
//        }else if(v=='8'){
//            return 2;
//        }
//        return 3;
//    }

    //    void solve(){
//            String s = ns();
//            int n = ni();
//            // '(' 4  '+' 1  '-' 1  '*' 2  '^' 3
//
//            long mod = 100007;
//            ot:for(int i=0;i<n;++i){
//                char[] p = ns().toCharArray();
//                int len = p.length;
//                int op = 0;
//                for(int j=0;j<len;++j){
//                    if(p[j]=='('){
//                        op++;
//                    }else if(p[j]==')'){
//                        op--;
//                    }
//                    if(op<0){
//                        continue ot;
//                    }
//                }
//                char stop[] = new char[len];
//                int p1 = 0;
//                long stnum[] = new long[len];
//                int p2 = 0;
//                long cur = 0;
//                for(int j=0;j<len;){
//                    if(p[j]=='('){
//                        stop[p1++] = p[j];j++;
//                    }else if(p[j]==')'){
//                        j++;
//                    }else if(p[j]>='0'&&p[j]<='9'){
//                        while(j<len&&p[j]>='0'&&p[j]<='9') {
//                            cur = cur * 10 + (p[j] - '0');
//                            j++;
//                        }
//                        stnum[p2++] = cur;
//                    }else if(p[j]=='+'){
//                        int me = gt(p[j]);
//                        if(p1>0&&gt(stop[p1-1])>=me){
//                            p1--;
//                            char c = stop[p1];
//                            long op1 = stnum[--p2];
//                            long op2 = stnum[--p2];
//                            if(c=='+'){
//                                stnum[p2++] = (op1+op2)%mod;
//                            }else if(c=='-'){
//                                stnum[p2++] = (op2-op1)%mod;
//                            }else if(c=='*'){
//                                stnum[p2++] = (op2*op1)%mod;
//                            }else if(c=='^'){
//                                stnum[p2++] = mod_pow(op2,op1,mod);
//                            }
//                        }
//                    }
//
//                }
//
//
//            }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }

    static int groups = 0;
    static int[] fa;
    static int[] sz;

    static void init(int n) {
        groups = n;
        fa = new int[n];
        for (int i = 1; i < n; ++i) {
            fa[i] = i;
        }
        sz = new int[n];
        Arrays.fill(sz, 1);
    }

    static int root(int p) {
        while (p != fa[p]) {
            fa[p] = fa[fa[p]];
            p = fa[p];
        }
        return p;
    }

    static void combine(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            fa[i] = j;
            sz[j] += sz[i];
        } else {
            fa[j] = i;
            sz[i] += sz[j];
        }
        groups--;
    }


    static long mul(long a, long b, long p)
    {
        long res=0,base=a;
        while(b>0)
        {
            if((b&1L)>0)
                res=(res+base)%p;
            base=(base+base)%p;
            b>>=1;
        }
        return res;
    }


    static long mod_pow(long k,long n,long p){
        long res = 1L;
        long temp = k%p;
        while(n!=0L){
            if((n&1L)==1L){
                res = mul(res,temp,p);
            }
            temp = mul(temp,temp,p);
            n = n>>1L;
        }
        return res%p;
    }
    public static String roundS(double result, int scale){
        String fmt = String.format("%%.%df", scale);
        return String.format(fmt, result);
    }








//    void solve() {
//
//        for(int i=0;i<9;++i) {
//            for (int j = 0; j < 9; ++j) {
//                int v = ni();
//                a[i][j] = v;
//                if(v>0) {
//                    vis_row[i][v] = true;
//                    vis_col[j][v] = true;
//                    vis_room[get_room(i, j)][v] = true;
//                }else{
//                    space++;
//                }
//            }
//        }
//
//
//        prepare = new int[space][2];
//
//        int p = 0;
//
//        for(int i=0;i<9;++i) {
//            for (int j = 0; j < 9; ++j) {
//                if(a[i][j]==0){
//                    prepare[p][0] = i;
//                    prepare[p][1]= j;p++;
//                    List<Integer> temp =new ArrayList<>();
//                    for(int k=1;k<=9;++k){
//                        if(!vis_col[j][k]&&!vis_row[i][k]&&!vis_room[get_room(i,j)][k]){
//                            temp.add(k);
//                        }
//                    }
//                    int sz = temp.size();
//                    val[i][j] = new int[sz];
//                    for(int k=0;k<sz;++k){
//                        val[i][j][k] = temp.get(k);
//                    }
//                }
//            }
//        }
//        Arrays.sort(prepare,(x,y)->{
//           return Integer.compare(val[x[0]][x[1]].length,val[y[0]][y[1]].length);
//        });
//        dfs(0);
//
//
//
//
//
//
//
//
//
//
//    }




    InputStream is;
    PrintWriter out;

    void run() throws Exception {
        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private char ncc() {
        int b = readByte();
        return (char) b;
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private String nline() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b) || b == ' ') {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[][] nm(int n, int m) {
        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) a[i] = ns(m);
        return a;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private long[] nal(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
        }
        ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') num = (num << 3) + (num << 1) + (b - '0');
            else return minus ? -num : num;
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
        }
        ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') num = num * 10 + (b - '0');
            else return minus ? -num : num;
            b = readByte();
        }
    }

    void print(Object obj) {
        out.print(obj);
    }

    void println(Object obj) {
        out.println(obj);
    }

    void println() {
        out.println();
    }

    void printArray(int a[],int from){
        int l = a.length;
        for(int i=from;i<l;++i){
            print(a[i]);
            if(i!=l-1){
                print(" ");
            }
        }
        println();
    }

    void printArray(long a[],int from){
        int l = a.length;
        for(int i=from;i<l;++i){
            print(a[i]);
            if(i!=l-1){
                print(" ");
            }
        }
        println();
    }
}