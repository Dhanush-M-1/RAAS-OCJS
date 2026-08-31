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

    void run(){
//        boolean oj = true;
//        boolean oj = false;


        Locale.setDefault(Locale.US);
        boolean oj = System.getProperty("ONLINE_JUDGE")!=null;

        String fileName = oj? "castle" : "dwarf";
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

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

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




    final int powMax = 18;
    int n, row, col;
    String[] word;
    int[][] toPos;

    void solve(){
        n = nextInt();
        row = nextInt();
        col = nextInt();
        word = new String[n];
        for( int i = 0; i < n; ++i ) word[i] = next();

        toPos = new int[n+1][powMax+1];
        for( int[] i : toPos ) fill(i,-1);
        for( int p = 0; p <= powMax; ++p )
            toPos[n][p] = n;

        int r = 0;
        int sumLength = 0;
        for( int l = 0; l < n; ++l ){
            while( r < n &&
                sumLength + word[r].length() + r - l <= col ){
                sumLength += word[r].length();
                ++r;
            }
            //
            sumLength -= word[l].length();
//            out.printf( "%d %d\n", l, r );
            toPos[l][0] = r;
        }

        for( int p = 1; p <= powMax; ++p )
        for( int v = 0; v < n; ++v )
            toPos[v][p] = toPos [toPos[v][p-1]] [p-1];

        int ansL=-1, ansR=-1;
        for( int v = 0; v < n; ++v ){
            int rem = row;
            int to = v;
            for( int p = powMax; 0 < rem; --p ){
                if( (1<<p) <= rem ){
                    rem -= (1<<p);
                    to = toPos[to][p];
                }
            }
            if( ansR - ansL < to - v ){
                ansR = to;
                ansL = v;
            }
//            out.printf( "%d %d   %d\n", v, to, to - v );
        }
        for( int v = ansL; v < ansR;  ){
            int to = toPos[v][0];
            for( int i = v; i < to; ++i ){
                if( i!=v ) out.print( ' ' );
                out.print( word[i] );
            }
            out.println();
            //
            v = to;
        }
    }




    void deb(){
    }


}