import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    String next() throws IOException {
        while( in==null || !in.hasMoreTokens() )
            in = new StringTokenizer( br.readLine() );
        return in.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }





    void run() throws IOException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) :
                new FileReader("input.txt");
        br = new BufferedReader(reader);
        out = new PrintWriter(
                oj ? new OutputStreamWriter(System.out) :
                        new FileWriter("output.txt"));
        solve();
        //deb();
        out.flush();
    }

    int n, x;
    int[] a, cntIn;
    int posX = -1;
    Vector<Integer> val = new Vector<Integer>();
    boolean[] can;

    void solve() throws IOException {
        n = nextInt();
        x = nextInt()-1;
        a     = new int[n];
        cntIn = new int[n];
        for( int v = 0; v < n; ++v ){
            a[v] = nextInt()-1;
            if( a[v]!=-1 ) ++cntIn[a[v]];
        }
        for( int v = 0; v < n; ++v ){
            if( cntIn[v]==0 ){
                Vector<Integer> path = new Vector<Integer>();
                for( int k = v; k != -1; k = a[k] )
                    path.add(k);
                Collections.reverse(path);
                boolean find = false;
                for( int i = 0; i < path.size(); ++i ){
                    if( path.get(i).equals(x) ){
                        posX = i+1;
                        find = true;
                    }
                }
                if( !find )
                    val.add( path.size() );
            }
        }
        if( posX == -1 ) posX = 1;
//        out.println(posX);

        can = new boolean[n+1];
        can[0] = true;
        for( int add : val ){
            for( int i = n; 0 <= i-add; --i )
                if( can[i-add] )
                    can[i] = true;
        }
        boolean[] ans = new boolean[n+1];
        for( int i = n; 0 <= i-posX; --i )
            if( can[i-posX] )
                ans[i] = true;
        for( int i = 1; i <= n; ++i )
            if( ans[i] )
                out.println(i);
        out.println();
    }


}
