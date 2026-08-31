import java.io.PrintWriter;
import java.util.*;

public class Test {

    static Scanner sc;
    static long[] dp;
    static long mod = (long)(1e9 + 7);
    static PrintWriter pw;
     
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        dp = new long[200025];
    
        for(int i = 0; i < dp.length; i++){
            if(i <= 9){
                dp[i] = 1;
            } else {
                dp[i] = add(dp[i-10], dp[i-9]);
            }
        }

        int t = Integer.parseInt(sc.next());
        while(t-->0) solve();
        pw.close(); sc.close();;
    }

    static void solve(){    

        int n = sc.nextInt();
        int m = sc.nextInt();

        long ans = 0;
        int step = 0;
        while(n > 0){
            step = m + n%10;
            ans = add(ans, dp[step]);
            n /= 10;
        }
        
        pw.println(ans);
       
    }
    
    static long add(long a, long b){
        if(a+b >= mod)
            return a+b-mod;
        return a+b;
    }
    
}