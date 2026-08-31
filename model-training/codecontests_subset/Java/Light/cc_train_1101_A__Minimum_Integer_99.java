import java.util.*;

public class Solve {

    static Scanner scan = new Scanner(System.in);

    public static void solve(long l,long r,long d){

        if( d < l){
            System.out.println(d);
            return;
        }
        long var = r/d;
        System.out.println((var+1)*d);

    }

    public static void main(String[] args) {

        int q = scan.nextInt();

        while (q-->0){
            long a = scan.nextLong();
            long b = scan.nextLong();
            long d = scan.nextLong();
            solve(a,b,d);
        }
    }
}