import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Main {
    void solve(){

        n=ni();
        s=new char[n][];
       String prev="";
       int sz=0;
       int g=0;


       for(int i=0;i<n;i++){
            String ss=ns();

           s[i]=ss.toCharArray();
           if(prev.equals(ss)){
               sz++;
           }else {
             g=gcd(g,sz);
               sz=1;

           }
           prev=ss;
       }
       g=gcd(g,sz);
       sz=0;
       prev="";
       StringBuilder sb=new StringBuilder("");
       for(int j=0;j<n;j++){
           sb.setLength(0);
           for(int i=0;i<n;i++){
               int jj=j/4;
               int b=j-jj*4;
               b=3-b;
               if(Character.isDigit(s[i][jj])){
                   int d=s[i][jj]-'0';
                   if(((d>>b)&1)==1) sb.append("1");else sb.append("0");
               }else {
                   int d=10+s[i][jj]-'A';
                   if(((d>>b)&1)==1) sb.append("1");else sb.append("0");
               }
           }
           String curr=sb.toString();
           if(curr.equals(prev)){
               sz++;
           }else {
               g=gcd(g,sz);
               sz=1;
           }
           prev=curr;
       }

       pw.println(g);

    }
    char s[][];
    int n;
    boolean check(int j){
        for(int i=0;i<n;i++) {
            if(s[i][j]!=s[i][j-1]) return false;
        }
        return true;
    }
    int gcd(int a,int b){
        if(b==0) return a;
        int r;
        while(b!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }

    static String hexToBin(String s) {
        String s1=new BigInteger(s, 16).toString(2);
        if(s1.length()==4) return s1;
        else if(s1.length()==3) return "0"+s1;
        else if(s1.length()==2) return "00"+s1;
        else return "000"+s1;
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