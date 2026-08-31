import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Math.*;

public class B {

    int INF = 1 << 28;
    //long INF = 1L << 62;
    double EPS = 1e-10;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int in=0, all=0, fold=0;
        for(int i=0;i<n;i++) {
            if( s.charAt(i) == 'A' ) all++;
            else if( s.charAt(i) == 'F' ) fold++;
            else in++;
        }
        
        System.out.println( ( in >= 2? 0: (in == 1? 1: all) ) );
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}


