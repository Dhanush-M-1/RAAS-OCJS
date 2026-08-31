import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int p=in.nextInt();
        int [] a=new int[n+1];
        int [] b=new int[k+1];
        for(int i=1;i<n+1;i++){
            a[i]=in.nextInt();
        }
        for(int i=1;i<k+1;i++){
            b[i]=in.nextInt();
        }
        int[][] dp=new int[n+1][k+1];
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=1;i<n+1;i++){
            for(int j=i;j<k+1;j++){
                if(i==j){
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.abs(a[i]-b[j])+Math.abs(b[j]-p));
                }else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.max(dp[i - 1][j - 1], Math.abs(a[i] - b[j]) + Math.abs(b[j] - p)));
                }
            }
        }
         int output=Integer.MAX_VALUE;
        for(int i=n;i<=k;i++)
        {
            output=Math.min(output,dp[n][i]);
        }
        System.out.println(output);
    }
}

	 		     	   	   	 		  		  		