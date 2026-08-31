import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        int k = sc.nextInt();
        int[] a = new int[n.length+1];
        for (int i = 0; i < n.length; i++) {
            a[i+1] = (int)(n[i] - '0');
        }
        long[][] dp1 = new long[a.length][k+1];
        long[][] dp2 = new long[a.length][k+1];
        dp2[0][0] = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i] == 0){
                for (int j = 0; j <= k; j++) {
                    dp1[i][j] += dp1[i-1][j];
                    dp2[i][j] += dp2[i-1][j];
                    if(0<j){
                        // set any
                        dp1[i][j] += dp1[i-1][j-1] * 9;
                    }
                }
            }else{
                for (int j = 0; j <= k; j++) {
                    // set 0
                    dp1[i][j] += dp1[i-1][j] + dp2[i-1][j];
                    if(0 < j){
                        // set max
                        dp2[i][j] += dp2[i-1][j-1];
                        // set any
                        dp1[i][j] += dp1[i-1][j-1] * 9 + dp2[i-1][j-1] * (a[i]-1);
                    }
                }
            }
        }
        System.out.println(dp1[a.length-1][k] + dp2[a.length-1][k]);
        sc.close();

    }

}

