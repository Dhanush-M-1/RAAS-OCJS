import java.util.Arrays;
import java.util.Scanner;


public class Giaibai {           
    
    public static long min(long a,long b){
        if(a>b) return b;
        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        long[] a=new long[n+3];
        for(int i=1;i<=n;i++) a[i]=sc.nextLong();
        Arrays.sort(a,1,n+1);
        int to=n%k,nho=k-n%k;
        long [][] dp=new long [to+2][nho+2];
        for(int i=0;i<=to;i++) for(int j=0;j<=nho;j++) dp[i][j]=10000000000000006L;
        dp[0][0]=0;
        for(int i=0;i<=to;i++)
            for(int j=0;j<=nho;j++)
                if(dp[i][j]<=10000000000000000L){
                    int len=i*(n/k+1)+j*(n/k);
                    if(i<to) dp[i+1][j]=(long) min(dp[i+1][j],dp[i][j]+a[len+n/k+1]-a[len+1]);
                    if(j<nho) dp[i][j+1]=(long) min(dp[i][j+1],dp[i][j]+a[len+n/k]-a[len+1]);
                }
        System.out.println(dp[to][nho]);
    }
    
}
