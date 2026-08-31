import java.util.*;
import java.io.*;

public class File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long total = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            total += num;
            max = Math.max(max, num);
        }
        
        // The answer is x games.
        // In x games, each player, A, is supervisor for at most
        // x-A games.
        // this is because, for the player A to reduce to 0,
        // there must be A games the player is not the supervisor.

        /*
        (x - a1) + (x - a2) + ... + (x - an)
        = x*n - S(a)
        This must be >= x.
        x <= n*x - S(a)
        S(a) <= x (n - 1)
        x = ceil(S(a) / (n-1))
        */

        long x = (long)Math.ceil((double)(total) / (double)(n-1));

        System.out.println(Math.max(x, max));
    }
}