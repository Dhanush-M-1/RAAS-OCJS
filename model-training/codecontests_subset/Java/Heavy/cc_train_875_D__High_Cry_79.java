
import java.math.*;
import java.util.*;
import java.io.*;

public class Main{
class Node {
    int l;
    int r;
    public Node(int l,int r){
        this.l=l;
        this.r=r;
    }
    public boolean equals(Object o){
        Node c=(Node)o;
        return l==c.l && r==c.r;
    }
    public int hashCode(){
        return l+r;
    }
}
    void solve() {
       int n=ni();
       int a[]=new int[n+1];

       for(int i=1;i<=n;i++){
           a[i]=ni();

       }
        int ed1[][]=new int[n+1][30];
        int ed2[][]=new int[n+1][30];

        for(int b=0;b<30;b++){
            for(int i=1;i<=n;i++){
                if(((a[i]>>b)&1)==1) continue;
                int r=i;
                while(r+1<=n && ((a[r+1]>>b)&1)==0) r++;
                for(int j=i;j<=r;j++){
                    ed1[j][b]=i;
                    ed2[j][b]=r;
                }

                i=r;
            }

        }

        for(int b=0;b<30;b++){
            for(int i=1;i<=n;i++){
                if(((a[i]>>b)&1)==1){
                    ed1[i][b]=1; ed2[i][b]=n;
                }
            }
        }

        long ans=(n*1L*(n+1))/2;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int l[]=new int[n+1];
        int r[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int i1=1,i2=n;
            for(int b=0;b<30;b++){
                i1=Math.max(ed1[i][b],i1);
                i2=Math.min(ed2[i][b],i2);
            }

            l[i]=i1; r[i]=i2;
            if(mp.containsKey(a[i])) {
                int id=mp.get(a[i]);
                if(l[id]==i1 && r[id]==i2)  i1=id+1;
               // pw.println(id);
                ans -= (i - i1 + 1) * 1L * (i2 - i + 1);
                mp.replace(a[i],i);
            }else {
                ans -= (i - i1 + 1) * 1L * (i2 - i + 1);
                mp.put(a[i],i);
            }

          // pw.println(ans);

        }
        pw.println(ans);

    }
    static int randInt(int min,int max){
        Random rand=new Random();
        int randInt=rand.nextInt((max-min)+1)+min;
        return randInt;
    }





    long M=(long)1e9+7;
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
