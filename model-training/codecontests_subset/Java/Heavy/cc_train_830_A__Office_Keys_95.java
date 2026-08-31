import java.io.*;
import java.util.*;

/**
 *
 * @author True
 */

public class Main {
    static Integer[] a = new Integer [1010];
    static Integer[] b = new Integer [2020];
    static int[][] dp = new int [1010][2020];
    public static void main(String args[]) {
        Scanner in;
        PrintStream out;
        in = new Scanner (new BufferedInputStream(System.in));
        out = System.out;
        try{
            in = new Scanner(new FileInputStream("java.in"));
            out = new PrintStream("java.out");
        } catch (FileNotFoundException e) {
        }
        int n = in.nextInt(), k = in.nextInt(), p = in.nextInt();
        for(int i=1; i<=n; i++) a[i] = in.nextInt();
        for(int i=1; i<=k; i++) b[i] = in.nextInt();
        Arrays.sort(a, 1, n+1, new MyCom());
        Arrays.sort(b, 1, k+1, new MyCom());
        dp[0][0] = 0;
        for(int i=1; i<=n; i++) {
            for(int j=i; j<=k; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], Math.abs(a[i]-b[j]) + Math.abs(b[j] - p));
                if(j>i) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
            }
        }
        out.println(dp[n][k]);
    }
    static class MyCom implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }
}
         