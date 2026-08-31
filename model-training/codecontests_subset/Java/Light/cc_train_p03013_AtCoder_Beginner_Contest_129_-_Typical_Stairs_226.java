import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // input
        final int NUM = scan.nextInt();
        int[] dp = new int[NUM+1];
        boolean[] broken = new boolean[NUM+1];
        int brokenNum = scan.nextInt();
        for(int i = 0; i < brokenNum; i++){
            broken[scan.nextInt()] = true;
        }

        // search
        dp[0] = 1;
        for(int i = 1; i <= NUM; i++){
            if(broken[i]){
               dp[i] = 0;
            } else {
                if(i == 1){
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] % 1000000007+ dp[i - 2] % 1000000007;
                }
            }
        }

        // answer
        System.out.println(dp[NUM] % 1000000007);

    }
}