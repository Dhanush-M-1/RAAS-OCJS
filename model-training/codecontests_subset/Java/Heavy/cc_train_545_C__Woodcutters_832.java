import java.util.*;
public class problem545C {
    public static int max(int a, int b){
        return a<b?b:a;
    }
    public static int min(int a, int b){
        return a>b?b:a;
    }
    public static void main(String args[]){
        Scanner q = new Scanner(System.in);
        int m,i,j=0,n,p;
        n = q.nextInt();
        long a[] = new long[n];
        long b[] = new long[n];
        int dp[][] = new int[n][2];
        for(i=0;i<n;i++){
            a[i] = q.nextLong();
            b[i] = q.nextLong();
        }
        dp[0][0] = 1;
        dp[0][1] = 1;
        j=1;
        for(i=1;i<n;i++){
            p = max(dp[i-1][0], dp[i-1][1]);
            //System.out.println(p);
            if(j==0){
                if(a[i-1] + b[i] < a[i])
                    dp[i][0] = p + 1;
                else
                    dp[i][0] = p;
            } else {
                if(a[i-1] + b[i-1] + b[i] < a[i]){
                    dp[i][0] = p + 1;
                    //System.out.println(a[i-1]+b[i-1]+b[i]);
                } else {
                    if(a[i-1] + b[i] < a[i]){
                        dp[i][0] = dp[i-1][0] + 1;
                        
                    }
                    else
                        dp[i][0] = p;
                }
            }
            if(i<n-1){
                if(a[i]+b[i]<a[i+1])
                    j=1;
                else
                    j=0;
                    dp[i][1] = p + j;
            } else {
                dp[i][1] = p + 1;
            }
            //System.out.println(i+" : "+dp[i][0]+" , "+dp[i][1]);
        }
        System.out.println(max(dp[n-1][0], dp[n-1][1]));
    }
}

