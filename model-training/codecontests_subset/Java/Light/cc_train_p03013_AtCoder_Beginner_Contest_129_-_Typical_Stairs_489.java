import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int dp[] = new int[n+2];
        boolean stairs[] = new boolean[n+1];
        dp[0] = 0;
        dp[1] = 1;


        int a[] = new int[m];

        for (int i=0; i<m; i++){
            a[i] = sc.nextInt();
            stairs[a[i]] = true;
        }

        for (int j=0; j<n; j++) {
            if (stairs[j+1]) {
                dp[j]=0;
                continue;
            }
            else{
                dp[j + 2] = (dp[j + 1] + dp[j]) % 1000000007;
            }
        }

        System.out.println(dp[n+1]);

    }
}

