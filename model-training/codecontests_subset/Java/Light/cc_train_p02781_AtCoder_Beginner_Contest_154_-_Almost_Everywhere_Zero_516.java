import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int digit = s.length();

        String[] arr = new String[digit];
        for (int i=0; i<digit; i++) arr[i] = s.substring(i, i+1);

        int[] arrInt = new int[digit];
        for (int i=0; i<digit; i++) arrInt[i] = Integer.parseInt(arr[i]);

        int[][][] dp = new int[digit][4][2];

        for (int i=0; i<digit; i++){
            dp[i][0][0] = 1;
        }

        dp[0][1][0] = arrInt[0]-1;
        dp[0][1][1] = 1;


        for (int i=1; i<digit; i++){
            // true

            // k==1
            dp[i][1][0] = dp[i-1][0][0]*9 + dp[i-1][1][0] + ((arrInt[i]==0) ? 0 : dp[i-1][1][1]);
            // k==2
            dp[i][2][0] = dp[i-1][1][0]*9 + dp[i-1][2][0] + ((arrInt[i]==0) ? 0 : dp[i-1][1][1]*(arrInt[i]-1) + dp[i-1][2][1]);
            // k==3
            dp[i][3][0] = dp[i-1][2][0]*9 + dp[i-1][3][0] + ((arrInt[i]==0) ? 0 : dp[i-1][2][1]*(arrInt[i]-1) + dp[i-1][3][1]);



            // false

            // k==1
            dp[i][1][1] = (arrInt[i]==0 ? dp[i-1][1][1] : 0);
            // k==2
            dp[i][2][1] = (arrInt[i]==0 ? (dp[i-1][2][1]) : (dp[i-1][1][1]) );
            // k==3
            dp[i][3][1] = (arrInt[i]==0 ? (dp[i-1][3][1]) : (dp[i-1][2][1]) );
        }


        System.out.println(dp[digit-1][k][0]+dp[digit-1][k][1]);
//        System.out.println(dp[digit-1][k][0]);

//        System.out.println(dp[1][1][0]);
//        System.out.println(dp[2][1][0]);
//        System.out.println(dp[1][1][1]);
//        System.out.println(dp[2][1][1]);

    }
}
