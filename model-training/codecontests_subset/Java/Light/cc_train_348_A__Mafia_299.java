import java.util.*;
import java.io.*;

public class File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*
        There is some number of games that is our answer, x.
        
        We know that for each person, Ai,
        x - Ai games can have person Ai as the supervisor.

        Number of games that each can be supervisor is:
        (x - A1) + (x - A2) + ... + (x - An)
        = x*n - S(A)
        This is the number of games players can be supervisor each.

        This might be more than needed, >= x.
        x <= x*n - S(A)
        =
        S(A) <= x*n - x
        =
        S(A) <= x(n-1)

        S(A) / (n-1) <= x

        The min answer = ceil(S(A) / (n-1))
        However, this might be less than the max element.
        Must be Math.max(answer, max)
        */

        int n = sc.nextInt();

        long total = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            total += val;
            max = Math.max(max, val);
        }

        long result = (long)Math.ceil((double)(total) / (double)(n-1));

        System.out.println(Math.max(result, max));
    }
}