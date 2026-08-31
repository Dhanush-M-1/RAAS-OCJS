import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Collections.*;

import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.math.BigInteger.*;
import static java.lang.Character.*;

public class Main {

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    void run(){
        Locale.setDefault(Locale.US);
        boolean oj = System.getProperty("ONLINE_JUDGE")!=null;
//        boolean oj = true;
        String fileName = oj? "curiosity" : "dwarf";
        try {
            if( oj ){
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
            else{
                br  = new BufferedReader(new FileReader(fileName+".in" ));
                out = new PrintWriter   (new FileWriter(fileName+".out"));
            }
        } catch (Exception e) {
            MLE();
        }
        long tb = System.currentTimeMillis();
        solve();
//        if( !oj )
//            out.println("TIME: " + (System.currentTimeMillis() - tb) / 1e3) ;
        exit(0);
    }

    String next(){
        while( st==null || !st.hasMoreElements() ){
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                return null;
            }
        }
        return st.nextToken();
    }
    String nextLine(){
        try {
            return br.readLine();
        } catch (Exception e) {
            return null;
        }
    }
    int nextInt(){ return Integer.parseInt(next()); }
    double nextDouble(){ return Double.parseDouble(next()); }
    long nextLong(){ return Long.parseLong(next()); }

    void exit( int val ){
        out.flush();
        System.exit(val);
    }

    void MLE(){
        int[][] arr = new int[1024*1024][];
        for( int i = 0; i < 1024*1024; ++i )
            arr[i] = new int[1024*1024];
    }

    public static void main(String[] args) {
        new Main().run();
    }









    final long inf = (long)1e9;
    int n, m;
    long[] arr;
    int[] op, l, r, dm;

    boolean f(){
        arr = new long[n+1];
        fill( arr, inf );
        for( int j = 1; j <= m; ++j ){
            if( op[j]==1 )
                for( int i = l[j]; i <= r[j]; ++i )
                    arr[i] += dm[j];
            else
                for( int i = l[j]; i <= r[j]; ++i )
                    arr[i] = min( arr[i], dm[j] );
        }

        for( int j = m; 1 <= j; --j ){
            if( op[j]==1 )
                for( int i = l[j]; i <= r[j]; ++i )
                    arr[i] -= dm[j];
            else{
                long val = -10*inf;
                for( int i = l[j]; i <= r[j]; ++i )
                    val = max( val, arr[i] );
                if( val != dm[j] ) return false;
            }
        }

        return true;
    }

    void solve(){
        n = nextInt();
        m = nextInt();

        op  = new int[m+1];
        l  = new int[m+1];
        r  = new int[m+1];
        dm  = new int[m+1];
        for( int i = 1; i <= m; ++i ){
            op[i] = nextInt();
             l[i] = nextInt();
             r[i] = nextInt();
            dm[i] = nextInt();
        }

        if( f() ){
            out.println("YES");
            for( int i = 1; i <= n; ++i )
                out.print( " " + arr[i] );
            out.println();
        }
        else{
            out.println("NO");
        }
    }
}
