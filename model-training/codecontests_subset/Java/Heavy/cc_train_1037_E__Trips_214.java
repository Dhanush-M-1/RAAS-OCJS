//package que_a;

import java.io.*;
import java.util.*;
import java.math.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7);
    boolean SHOW_TIME;
    
    class pair implements Comparator {
        int F, S;
        pair(int f, int s) {
            F = f;  S = s;
        }

        @Override
        public int compare(Object U, Object V) {
            pair u = (pair)U;
            pair v = (pair)V;
            if(u.F != v.F)  return u.F - v.F;
            return u.S - v.S;
        }
    }
    
    void solve() {
        //Enter code here utkarsh
        //SHOW_TIME = true;
        int n = ni(), m = ni(), k = ni();
        HashSet <pair> h[] = new HashSet[n];
        for(int i = 0; i < n; i++) h[i] = new HashSet<>();
        int deg[] = new int[n];
        int ans[] = new int[m];
        boolean vst[] = new boolean[m];
        pair mp[] = new pair[m];
        
        for(int i = 0; i < m; i++) {
            int u = ni()-1, v = ni()-1;
            h[u].add(new pair(v, i));    h[v].add(new pair(u, i));
            deg[u]++;
            deg[v]++;
            mp[i] = new pair(u, v);
        }
        ArrayDeque <Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(deg[i] < k)  q.add(i);
        }
        
        int s = n;
        for(int i = m-1; i >= 0; i--) {
            while(!q.isEmpty()) {
                s--;
                int y = q.poll();
                for(pair p : h[y]) {
                    if(vst[p.S])    continue;
                    if(deg[p.F] == k)   q.add(p.F);
                    deg[p.F]--;
                    vst[p.S] = true;
                    h[p.F].remove(new pair(y, p.S));
                }
            }
            ans[i] = s;
            if(!vst[i]) {
                vst[i] = true;
                if(deg[mp[i].F] == k) {
                    q.add(mp[i].F);
                }
                if(deg[mp[i].S] == k) {
                    q.add(mp[i].S);
                }
                deg[mp[i].F]--;     deg[mp[i].S]--;
                h[mp[i].F].remove(new pair(mp[i].S, i));
                h[mp[i].S].remove(new pair(mp[i].F, i));
            }
        }
        for(int x : ans)    out.println(x);
    }
    
    //---------- I/O Template ----------
    
    public static void main(String[] args) { new utkarsh().run(); }
    void run() { 
        is = System.in; 
        out = new PrintWriter(System.out);
        long start = System.currentTimeMillis(); 
        solve(); 
        long end = System.currentTimeMillis();
        if(SHOW_TIME) out.println("\n" + (end - start) + " ms");
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