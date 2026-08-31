
//package que_a;

import java.io.*;
import java.util.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    long inf = (long) (1e15);
    boolean SHOW_TIME;
    
    void solve() {
        //Enter code here utkarsh
        //SHOW_TIME = true;
        double x1 = nd(), y1 = nd();
        double x2 = nd(), y2 = nd();
        double x3 = nd(), y3 = nd();
        double m1 = inf;
        if(x1 != x2) m1 = (y2 - y1) / (x2 - x1);
        double m2 = inf;
        if(x2 != x3) m2 = (y3 - y2) / (x3 - x2);
        long d1 = (long)((y2 - y1) * (y2 - y1)) + (long)((x2 - x1) * (x2 - x1));
        long d2 = (long)((y3 - y2) * (y3 - y2)) + (long)((x3 - x2) * (x3 - x2));
        //out.println(d1 +" "+ d2);
        if(m1 == m2 || d1 != d2) {
            out.println("No");
        } else {
            out.println("Yes");
        }
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