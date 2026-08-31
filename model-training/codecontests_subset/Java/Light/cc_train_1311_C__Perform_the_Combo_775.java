import java.util.*;
import static java.lang.System.*;
// Euler functions
public class Main {
	public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
    	int numCase = input.nextInt();
    	for (int ks = 0 ;ks < numCase; ks++) {
          int n = input.nextInt(), m = input.nextInt(), p[] = new int[m + 1];
          long res[] = new long[26], dp[][] = new long[n + 1][26];
          String s = input.next();
          for (int i = 0; i < m; i++) {
            p[i] = input.nextInt();
          }
          p[m] = n;
          for (int i = 1; i <= n; i++) {
            int ord = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (ord == j) {
                    dp[i][ord] = dp[i - 1][ord] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j]; 
                }
            }
          }
          // out.println(dp[1][0] + " dp10");
          // out.println(dp[3][0] + " dp10");
          // out.println(dp[4][0] + " dp10");
          for (int ord = 0; ord < 26; ord++) {
                res[ord] =0;
          }
          for (int i = 0; i <= m; i++) {
            // int ord = s.charAt(p[i] - 1) - 'a';
            for (int ord = 0; ord < 26; ord++) {
                res[ord] += dp[p[i]][ord];
            }
          }
          for (long e : res) {
            out.print(e + " ");
          }
          out.println();
        }
    }
}

