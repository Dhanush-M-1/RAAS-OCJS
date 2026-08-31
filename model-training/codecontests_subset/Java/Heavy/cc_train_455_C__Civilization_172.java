//package que_a;

import java.io.*;
import java.util.*;
import java.math.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    ArrayList <Integer> a[];
    int pt[], ans[], vst[];
    HashMap <Integer, Integer> d;
    
    int root(int x) {
        while(x != pt[x]) {
            pt[x] = pt[ pt[x] ];
            x = pt[x];
        }   return x;
    }
    
    boolean union(int x, int y) {
        int rx = root(x);
        int ry = root(y);
        if(rx == ry)    return false;
        pt[rx] = ry;
        return true;
    }
    
    void dfs(int s, int dist) {
        vst[s]++;
        d.put(s, dist);
        for(int x : a[s]) {
            if(vst[x]+1 == vst[s])    dfs(x, dist+1);
        }
    }
    
    int play(int s) {
        d.clear();
        dfs(s, 0);
        int x = s, m = 0;
        for(int k : d.keySet()) {
            int v = d.get(k);
            if(v > m) {
                m = v;  x = k;
            }
        }
        //d.clear();
        dfs(x, 0);
        for(int k : d.keySet()) {
            int v = d.get(k);
            if(v > m) {
                m = v;
            }
        }   return m;
    }
    
    void solve() {
        int n = ni(), m = ni(), q = ni();
        a = new ArrayList[n];
        pt = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
            pt[i] = i;
        }
        for(int i = 0; i < m; i++) {
            int u = ni()-1, v = ni()-1;
            a[u].add(v);    a[v].add(u);
            union(u, v);
        }
        ans = new int[n];
        vst = new int[n];
        d = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(vst[i] == 2)  continue;
            int x = root(i);
            ans[x] = play(i);
        }
        while(q-- > 0) {
            if(ni() == 1) {
                out.println(ans[ root(ni()-1) ]);
            } else {
                int x = root(ni() - 1);
                int y = root(ni() - 1);
                if(x != y) {
                    pt[x] = y;
                    //out.println("### " + ans[x] +" "+ ans[y]);
                    ans[y] = Math.max(Math.max(ans[x], ans[y]), (ans[x]+1)/2 + (ans[y]+1)/2 + 1);
                    //out.println(x +" "+ y +" "+ ans[y]);
                }
            }
        }
    }
    
    long mp(long b, long e) {
        long r = 1;
        while(e > 0) {
            if((e&1) == 1)  r = (r * b) % mod;
            b = (b * b) % mod;
            e >>= 1;
        }
        return r;
    }

    //---------- I/O Template ----------
    
    public static void main(String[] args) { new utkarsh().run(); }
    void run() { 
        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte() { 
        if(ptr >= len) { ptr = 0; 
            try { len = is.read(input); } 
            catch(IOException e) { throw new InputMismatchException(); } 
            if(len <= 0) { return -1; } 
        } return input[ptr++];
    }
    boolean isSpaceChar(int c) { return !( c >= 33 && c <= 126 ); }
    int skip() { 
        int b = readByte(); 
        while(b != -1 && isSpaceChar(b)) { b = readByte(); } 
        return b;
    }
    
    char nc() { return (char)skip(); }
    String ns() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while(!isSpaceChar(b)) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    String nLine() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while( !(isSpaceChar(b) && b != ' ') ) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    int ni() { 
        int n = 0, b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        if(b == -1) { return -1; }  //no input 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }
    long nl() { 
        long n = 0L;    int b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }

    double nd() { return Double.parseDouble(ns()); }
    float nf() { return Float.parseFloat(ns()); }
    int[] na(int n) { 
        int a[] = new int[n]; 
        for(int i = 0; i < n; i++) { a[i] = ni(); } 
        return a;
    }
    char[] ns(int n) { 
        char c[] = new char[n]; 
        int i, b = skip(); 
        for(i = 0; i < n; i++) { 
            if(isSpaceChar(b)) { break; } 
            c[i] = (char)b; b = readByte(); 
        } return i == n ? c : Arrays.copyOf(c,i);
    }
}