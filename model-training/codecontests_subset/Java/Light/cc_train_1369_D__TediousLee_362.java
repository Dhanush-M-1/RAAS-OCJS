import java.io.*;
import java.util.*;
public class Solution{
    
    private static BufferedReader re;
    private static int input()throws IOException{
        return Integer.parseInt(re.readLine());
    }
    
    public static void main(String args[])throws IOException{
        re = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = input(), input[] = new int[t], max = 0;
        for(int i=0; i<t; i++){
            input[i] = input();
            max = Math.max(max, input[i]);
        }
        
        long dp[] = new long[max+1], mod = (long)1e9 + 7;
        for(int i=1; i<=max; i++){
            if(i <= 2) dp[2] = 0;
            else{
                dp[i] = ((2 * dp[i-2]%mod)%mod + dp[i-1]%mod)%mod;
                if(i % 3 == 0)
                    dp[i] = (dp[i] + 4)%mod;
            }
        }
        
        for(int i=0; i<t; i++)
            pw.println(+dp[input[i]]);
        
        pw.flush();
        pw.close();
    }
}