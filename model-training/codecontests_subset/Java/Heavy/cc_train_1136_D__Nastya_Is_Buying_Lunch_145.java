import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve(){
       int n=ni(),m=ni();
       int a[]=new int[n+1];
       for(int i=1;i<=n;i++) a[i]=ni();
       int from[]=new int[m];
       int to[]=new int[m];
        boolean imp[]=new boolean[n+1];
       for(int i=0;i<m;i++){
           from[i]=ni(); to[i]=ni();
           if(to[i]==a[n]) imp[from[i]]=true;
       }
       g=packD(n,from,to);
        for(int i=1;i<=n;i++) Arrays.sort(g[i]);
        PriorityQueue<Integer> q=new PriorityQueue<>();
        Queue<Integer> q2=new LinkedList<>();


        int ans=0;
         out :for(int i=n-1;i>=1;i--){
            if(imp[a[i]]){
              //  pw.println(a[i]);
                int j=0;
                while(!q.isEmpty()){
                    int v=q.poll();
                    while(j<g[a[i]].length && g[a[i]][j]!=v) j++;
                    if(j>=g[a[i]].length) {
                            q.add(a[i]);
                            q2.add(v);
                        while(!q2.isEmpty()) q.add(q2.poll());
                            continue out;
                    }
                    j++;
                    q2.offer(v);
                }
                while(!q2.isEmpty()) q.add(q2.poll());

                ans++;
            }else {
                q.offer(a[i]);
            }
        }
        pw.println(ans);

    }
    int g[][];
    static int[][] packD(int n, int[] from, int[] to) {
        int[][] g = new int[n+1][];
        int[] p = new int[n+1];
        for (int f : from)
            p[f]++;
        for (int i = 1; i <= n; i++)
            g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) {
            g[from[i]][--p[from[i]]] = to[i];
        }
        return g;
    }


    long M = (long)1e9+7;
    InputStream is;
    PrintWriter pw;
    String INPUT = "";

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
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

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }

}