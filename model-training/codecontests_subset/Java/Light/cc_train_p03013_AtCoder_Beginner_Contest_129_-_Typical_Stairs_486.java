
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        Set<Integer> brokensteps = new HashSet<Integer>();
        for(int i = 0;i < m;i++){
            brokensteps.add(scanner.nextInt());
        }
        scanner.close();

        long[] dp;
        dp = new long[n+1];
        dp[0] = 1;

        for(int i = 1;i < n+1;i++){
            if(brokensteps.contains(i)){
                dp[i] = 0;
                continue;
            }

            if(i == 1){
                dp[i] = 1;
                continue;
            }

            dp[i] = (dp[i-1] + dp[i-2]) % ((long)(Math.pow(10,9)) + 7);

        }

        System.out.println(dp[n]);




    }
}