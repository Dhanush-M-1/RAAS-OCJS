
import java.io.*;
import java.util.*;
import java.math.BigInteger.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// https://netbeans.org/kb/73/java/editor-codereference_ru.html#display
//<editor-fold defaultstate="collapsed" desc="Main">
public class Main {

    private void run() {
        Locale.setDefault(Locale.US);
        boolean oj = true;
        try {
            oj = System.getProperty("MYLOCAL") == null;
        } catch (Exception e) {
        }

        if (oj) {
            sc = new FastScanner(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            try {
                sc = new FastScanner(new FileReader("input.txt"));
                out = new PrintWriter(new FileWriter("output.txt"));
            } catch (IOException e) {
                MLE();
            }
        }
        Solver s = new Solver();
        s.sc = sc;
        s.out = out;
        s.solve();
        if (!oj) {
            err.println("Time: " + (System.currentTimeMillis() - timeBegin) / 1e3);
            err.printf("Mem: %d\n", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 20);
        }
        out.flush();
    }

    private void show(int[] arr) {
        for (int v : arr) {
            err.print(" " + v);
        }
        err.println();
    }

    public static void MLE() {
        int[][] arr = new int[1024 * 1024][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[1024 * 1024];
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    long timeBegin = System.currentTimeMillis();
    FastScanner sc;
    PrintWriter out;
    PrintStream err = System.err;
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FastScanner">
class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStreamReader reader) {
        br = new BufferedReader(reader);
        st = new StringTokenizer("");
    }

    String next() {
        while (!st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ex) {
                Main.MLE();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}
//</editor-fold>

class Solver {

    FastScanner sc;
    PrintWriter out;
    PrintStream err = System.err;

    int n, m, q;
    ArrayList<Integer>[] gr;
    DSU dsu;
    
    class DSU{
        int[] paret, ans;

        DSU( int n ){
            paret = new int[n+1];
            for (int i = 0; i < paret.length; i++) {
                paret[i] = i;
            }
            
            ans = new int[n+1];
        }
        
        int getParet( int v ){
            if( paret[v] == v )
                return v;
            return paret[v] = getParet( paret[v] );
        }

        void unit( int a, int b ){
            a = getParet( a );
            b = getParet( b );
            if( a == b ){
                return;
            }
            paret[a] = b;
            ans[b] = max( (ans[b]+1)/2 + (ans[a]+1)/2 + 1, max( ans[b], ans[a] ) ); 
        }
        
        int getAns( int v ){
            return ans[getParet(v)];
        }
        
        void setAns( int v, int val ){
            ans[getParet(v)] = val;
        }
    }
    
    int timer;
    int[] used;
    int dfs_v, dfs_h;
    void dfs( int v, int curH ){
        if( used[v] == timer )
            return;
        used[v] = timer;
        if( dfs_h < curH ){
            dfs_h = curH;
            dfs_v = v;
        }
        for (Integer to : gr[v]) {
            dfs( to, curH + 1 );
        }
    }
    
    void solve() {
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        
        gr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            gr[i] = new ArrayList<>();
        
        dsu = new DSU(n+1);
        
        for (int iter = 0; iter < m; iter++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            gr[a].add(b);
            gr[b].add(a);
            dsu.unit( a, b );
        }

        used = new int[n+1];
        fill( used, -1 );
        for( int v = 1; v <= n; ++v ){
            if( used[v] == -1 ){
                int start;
                
                timer++;
                start = v;
                dfs_v = -1;
                dfs_h = -1;
                dfs( start, 0 );
                
                timer++;
                start = dfs_v;
                dfs_v = -1;
                dfs_h = -1;
                dfs( start, 0 );
                
                //err.println( ":: " + v +" "+ dfs_h );
                dsu.setAns( v, dfs_h );
            }
        }
        
        //for( int v = 1; v <= n; ++v ) err.println( v +" "+ dsu.getAns(v) );
        
        for (int iter = 0; iter < q; iter++) {
            int op = sc.nextInt();
            if( op == 1 ){
                int x = sc.nextInt();
                out.println( dsu.getAns(x) );
            }
            else if( op == 2 ){
                int x = sc.nextInt();
                int y = sc.nextInt();
                dsu.unit(x, y);
            }
            else Main.MLE();
        }
    }

}
