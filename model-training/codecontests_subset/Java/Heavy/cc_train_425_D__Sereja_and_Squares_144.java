import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.Calendar.*;
import static java.lang.Math.*;
import static java.lang.Math.min;
import static java.util.Arrays.*;
import static java.math.BigInteger.*;

import java.util.jar.*;

public class Main{

    void run(){
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
//        boolean oj = true;
        Locale.setDefault(Locale.US);
        try{
            err = new PrintWriter(new OutputStreamWriter(System.err));
            try{
                sc  = new FastScanner(new BufferedReader(new FileReader("input.txt" )));
                out = new PrintWriter   (new FileWriter("output.txt"));
                oj = false;
            }
            catch ( Exception e ){
                sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
                out = new PrintWriter(new OutputStreamWriter(System.out));
                oj = true;
            }
        }catch(Exception e){
            MLE();
        }
        tBeg = System.currentTimeMillis();
        solve();
        if( !oj )
            err.println( "TIME: " + (System.currentTimeMillis() - tBeg ) / 1e3 );
        exit(0);
    }

    void exit( int val ){
        err.flush();
        out.flush();
        System.exit(val);
    }

    double tBeg;
    FastScanner sc;
    PrintWriter err, out;

    class FastScanner{

        StringTokenizer st;
        BufferedReader br;

        FastScanner( BufferedReader _br ){
            br = _br;
        }

        String readLine(){
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next(){
            while( st==null || !st.hasMoreElements() )
                st = new StringTokenizer(readLine());
            return st.nextToken();
        }

        int nextInt(){ return Integer.parseInt(next()); }
        long nextLong(){ return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
    }

    void MLE(){
        int[][] arr = new int[1024*1024][]; for( int i = 0; i < 1024*1024; ++i ) arr[i] = new int[1024*1024];
    }

    void TLE(){
        for(;;);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    ////////////////////////////////////////////////////////////////

    int n;
    HashMap<Integer,HashSet<Integer>> gr;

    void ff(){
        HashMap<Integer,HashSet<Integer>> g = new HashMap<>();
        for( int x : gr.keySet() ){
            for( int y : gr.get(x) ){
                if( !g.containsKey(y) )
                    g.put( y, new HashSet<>() );
                g.get(y).add(x);
            }
        }
        gr = g;
    }

    boolean have( int x, int y ){
        return gr.containsKey(x) && gr.get(x).contains(y);
    }

    int f( int sqrtN ){
        int ans = 0;
        for( int x : gr.keySet() ){
            if( gr.get(x).size() <= sqrtN ){
                Integer[] arr = gr.get(x).toArray(new Integer[0]);
                for( int i = 0; i < arr.length; ++i ){
                    for( int j = i+1; j < arr.length; ++j ){
                        int y0 = arr[i];
                        int y1 = arr[j];
                        int sz = y1 - y0;
                        if( have( x-sz, y0 ) && have( x-sz, y1 ) ) ++ans;
                        if( have( x+sz, y0 ) && have( x+sz, y1 ) ) ++ans;
                    }
                }
                gr.get(x).clear();
            }
        }
        return ans;
    }

    void solve(){
        n = sc.nextInt();
        gr = new HashMap<>();
        for( int i = 0; i < n; ++i ){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if( !gr.containsKey(x) )
                gr.put( x, new HashSet<>() );
            gr.get(x).add(y);
        }

        int ans = 0;
        ans += f( (int)sqrt(n) );
        ff();
        ans += f( n );
        out.println( ans );
    }
}