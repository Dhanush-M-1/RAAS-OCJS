import sun.misc.Compare;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import java.math.BigInteger;

import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;


public class Main{

    void run(){
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
//        boolean oj = true;
        try{
            if( oj ){
                sc  = new FastScanner( new InputStreamReader(System.in  ) );
                out = new PrintWriter(   new OutputStreamWriter(System.out) );
            } else{
                sc  = new FastScanner(new FileReader("in.txt") );
//                sc  = new FastScanner(new FileReader("D:\\JavaOlymp\\FatalError\\output.txt") );
                out = new PrintWriter(   new FileWriter("out.txt") );
            }
        } catch (Exception e) {
            System.exit(-1);
        }
        long tB = System.currentTimeMillis();
        solve();
        if( !oj ) System.err.println( "Time: " + (System.currentTimeMillis()-tB)/1e3 );
        out.flush();
    }

    class FastScanner{
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");
        FastScanner( InputStreamReader a ){
            br = new BufferedReader(a);
        }
        FastScanner( FileReader a ){
            br = new BufferedReader(a);
        }
        String next(){
            while( !st.hasMoreTokens() )
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            return st.nextToken();
        }
        String readLine(){
            try {
                return br.readLine();
            } catch (Exception e) {
                return null;
            }
        }
        int nextInt(){ return Integer.parseInt(next()); }
    }

    FastScanner sc;
    PrintWriter out;



    public static void main(String[] args){
//        new Main().run();
        new Thread( null, new Runnable() {
            @Override
            public void run() {
                new Main().run();
            }
            //}, "LOL", 256L * 1024 * 1024 / 2 ).run();
        }, "LOL", 2000 * 1024 * 1024 ).run();
    }



    void TLE(){ for(;;); }

    void MLE(){
        int[][] adj = new int[1024*1024][];
        for( int i = 0; i < adj.length; ++i )
            adj[i] = new int[1024*1024];
    }

    void exit( int val ){
        out.flush();
        System.exit(val);
    }
    //////////////////////////////////////////////////////////////////////////////////////////


    int n, c;
    int[] x;

    void solve(){
        n = sc.nextInt();
        c = sc.nextInt();
        x = new int[n];
        for( int i = 0; i < n; ++i )
            x[i] = sc.nextInt();
        int ans = 0;
        for( int i = 0; i+1 < n; ++i ){
            int cur = x[i] - x[i+1] - c;
            ans = max(ans,cur);
        }
        out.println(ans);
    }


}