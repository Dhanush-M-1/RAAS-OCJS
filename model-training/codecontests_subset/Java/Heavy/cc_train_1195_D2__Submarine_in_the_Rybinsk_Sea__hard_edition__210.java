import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Main {
    void solve() {
        int n=ni();
        long a[]=new long[n+1];
        for(int i=1;i<=n;i++) a[i]=nl();
        Arrays.sort(a,1,n+1);
        int cnt[]= new int[11];
        for(int i=1;i<=n;i++){
            cnt[getLength(a[i])]++;
        }
        long ans=0;
        for(int i=1;i<=n;i++){
            for(int l=1;l<=10;l++){
                ans=add(ans,mul(cnt[l],getAns1(a[i],l)));
                ans=add(ans,mul(cnt[l],getAns2(a[i],l)));
            }
        }
        pw.println(ans);
    }
    long getAns1(long n,int l){
        long d=10;
        long ans=0;
        while(l>0 && n>0){
            ans=add(ans,mul(d,n%10));
            l--;
            n/=10;
            if(l==0) d=mul(d,10);
            else
                d=mul(d,100);

        }
        while(n>0){
            ans=add(ans,mul(d,n%10));
            d=mul(d,10);
            n/=10;
        }

        return ans;
    }
    long getAns2(long n,int l){
        long d=1;
        long ans=0;
        while(l>0 && n>0){
            ans=add(ans,mul(d,n%10));
            l--;
            n/=10;
            d=mul(d,100);

        }
        while(n>0){
            ans=add(ans,mul(d,n%10));
            d=mul(d,10);
            n/=10;
        }

        return ans;
    }

    int getLength(long n){
        int ans=0;
        while(n>0){
            n/=10;
            ans++;
        }
        return ans;
    }
    long add(long x,long y){
        x+=y;
        if(x>=M) x-=M;
        return x;
    }
    long mul(long x,long y){
        x*=y;
        if(x>=M) x%=M;
        return x;
    }


    long M =998244353;


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