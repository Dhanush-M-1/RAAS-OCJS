import java.io.*;
import java.util.*;
import java.math.*;
// import java.awt.Point;
 
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
 
    long mod = 1_000_000_007;
    long inf = Long.MAX_VALUE;

    void solve(){
        int n = ni();
        int k = ni();
        int q = ni();
        int[] a = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++){
            a[i] = ni();
            set.add(a[i]);
        }
        long ans = inf;
        for(int y : set){
            for(int i = 0; i < n; i++){
                if(a[i]<y) a[i] = -1;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int s = 0;
            int t = 0;
            while(true){
                // System.err.println(s+" "+t+" "+y);
                if(t>=n) break;
                if(a[t]!=-1) t++;
                else{
                    if(s==t){
                        s++;
                        t++;
                        continue;
                    }
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i = s; i < t; i++){
                        list.add(a[i]);
                    }
                    Collections.sort(list);
                    // System.err.println(s+" "+t+" "+y);
                    for(int i = 0; i < t-s+1-k; i++){
                        map.merge(list.get(i), 1, (e,f)->e+f);
                    }
                    s = t;
                }
            }
            if(s!=t){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = s; i < t; i++){
                    list.add(a[i]);
                }
                Collections.sort(list);
                // System.err.println(s+" "+t+" "+y);
                for(int i = 0; i < t-s+1-k; i++){
                    map.merge(list.get(i), 1, (e,f)->e+f);
                }
            }
            int p = 0;
            int x = -1;
            for(int i : map.keySet()){
                // out.println(i+" "+map.get(i));
                x = i;
                p += map.get(i);
                // out.println(x+" "+p);
                if(p>=q) break;
            }
            // out.println(x+" "+p+" "+1);
            if(x==-1||p<q) continue;
            ans = Math.min(ans, x-y);
        }
        out.println(ans);
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
