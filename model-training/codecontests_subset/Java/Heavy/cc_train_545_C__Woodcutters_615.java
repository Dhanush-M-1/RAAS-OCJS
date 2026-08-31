import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    static boolean file = false;
    static final int maxn = (int)1e5+111;
    static int inf = (int)1e9;
    static int n;
    static Pair a[] = new Pair[maxn];
    
    private static void solve() throws Exception {
        n = in.nextInt();
        
        for (int i=1; i<=n; i++) {
            a[i] = new Pair (in.nextInt(), in.nextInt());
        }
        
        int last = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i=1; i<n; i++) {
            if (a[i].x-a[i].y>last) {
                last = a[i].x;
                cnt++;
            } else {
                if (a[i].x+a[i].y<a[i+1].x) {
                    last = a[i].x+a[i].y;
                    cnt++;
                }
            }
            last = Math.max(last,a[i].x);
        }
        
        out.println(cnt+1);
    }   

    public static void main (String [] args) throws Exception {
        
        if (file) {
            in = new FastReader(new BufferedReader(new FileReader("input.txt")));
            out = new PrintWriter ("output.txt");
        }
        
        solve();
        out.close();
    }

}

class Pair implements Comparable<Pair> {
    int x,y;
    Point q;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        Pair p = (Pair)obj;
        if (p.x == x && p.y==y) return true;
        return false;
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return x;
    }
    @Override
    public int compareTo(Pair p) {
        if (x<p.x)return 1;
        else if (x==p.x) return 0;
        else return -1;
    }
    
    
    
    
    
}

class FastReader {
    BufferedReader bf;
    StringTokenizer tk = null;

    public FastReader(BufferedReader bf) {
        this.bf = bf;
    }
    
    public String nextToken () throws Exception {
        if (tk==null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(bf.readLine());
        }
        return tk.nextToken();
    }
    
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}