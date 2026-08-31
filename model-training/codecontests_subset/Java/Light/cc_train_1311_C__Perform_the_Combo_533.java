
import java.util.*;

public class C {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int tc = 0; tc < t; tc++) {
            
            int n = in.nextInt();
            int m = in.nextInt();
            
            String c = in.next();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }
            int[] ans = new int[26];
            
            int[] dp; //lol
            dp = new int[n];
            for (int i = 0; i < m; i++) {
                dp[a[i]-1]++;
            }
            
            for (int i = n - 2; i >= 0; i--) {
                dp[i] = dp[i] + dp[i + 1];
            }
            
            for (int i = 0; i < dp.length; i++) {
                dp[i]++;
            }
//            System.out.println(Arrays.toString(dp));
            for (int i = 0; i < dp.length; i++) {
                ans[c.charAt(i) - 'a'] += dp[i];
            }
            
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                s.append(ans[i]).append(" ");
            }
            s.append(ans[25]);
            System.out.println(s);
        }
        
    }
    
}
