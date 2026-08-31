import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class P168E {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            long A = in.nextLong();
            long B = in.nextLong();
            System.out.println(f(A,B) ? "First" : "Second");
        }
    }
    public static boolean f(long A, long B) {
        if(A > B) return f(B,A);
        if(A == 0) return false;
        if(A == 1) return true;

        if( (B/A % (A+1)) % 2 == 0) return true;
        if(!f(B%A,A)) return true;
        return false;
    }
}
