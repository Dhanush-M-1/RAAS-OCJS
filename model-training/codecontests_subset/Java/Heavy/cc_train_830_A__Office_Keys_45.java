import java.util.Arrays;
import java.util.Scanner;
public class Main {
	 
	static int[][] dp=new int[1005][2005];
	 static int[] a=new int[1005];
	 static int[] b=new int[2005];
public static void main(String[] args){
Scanner input=new Scanner(System.in);
    int n=input.nextInt();
    int k=input.nextInt();
    int s=input.nextInt();   	 
    for(int i=1;i<=n;i++) a[i]=input.nextInt();
    for(int i=1;i<=k;i++) b[i]=input.nextInt();
    Arrays.sort(a,1,n+1);
    Arrays.sort(b,1,k+1);
    for(int i=0; i<=n; i++){
        for(int j=0; j<=k; j++){
            dp[i][j] =2147483647;
        }
    }
    for(int i=0; i<=k; i++){ 
    	dp[0][i]=0;
    }
    for(int i=1; i<=n; i++)
        for(int j=i; j<=k; j++){
            dp[i][j] = Math.min(dp[i][j-1],Math.max(dp[i-1][j-1],Math.abs(a[i]-b[j])+Math.abs(b[j]-s)));
        }
    System.out.printf("%d\n", dp[n][k]);
}
}
 	 		  						 	  	  	     	 	 	