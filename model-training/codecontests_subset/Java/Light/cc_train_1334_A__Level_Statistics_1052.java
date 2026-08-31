import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int plays[] = new int[n], clears[] = new int[n];
            for (int i = 0; i < n; i++) {
                plays[i] = in.nextInt();
                clears[i] = in.nextInt();
            }
            pw.println(solve(n, plays, clears) ? "YES" : "NO");
        }

        pw.close();
    }

    static boolean solve(int n, int[] plays, int[] clears) {
        if(plays[0] < clears[0]) return false;
        for (int i = 1; i < n; i++) {
            int d = clears[i] - clears[i - 1];
            if(plays[i] < clears[i]) return false;
            if (plays[i] < plays[i - 1]) return false;
            if (clears[i] < clears[i - 1]) return false;
            if (clears[i] > clears[i - 1] && plays[i] < plays[i - 1] + d) return false;
        }
        return true;
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}