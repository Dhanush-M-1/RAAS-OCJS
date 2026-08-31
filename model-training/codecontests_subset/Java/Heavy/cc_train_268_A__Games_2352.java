import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class MainTwo {
    static FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    static boolean file = false;
    static final int maxn = (int)1e5 + 11;
    static int inf = (int)1e9;
    static int n,k,m,cnt;
    static ArrayList<Pair> list = new ArrayList<>();
    static int a[][] = new int[maxn][5];
    
    private static void solve() throws Exception {
        int n = in.nextInt();
        for (int i=1; i<=n; i++) {
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) 
                if (a[i][1]==a[j][2]) cnt++;
        }
        
        out.println(cnt);
        
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