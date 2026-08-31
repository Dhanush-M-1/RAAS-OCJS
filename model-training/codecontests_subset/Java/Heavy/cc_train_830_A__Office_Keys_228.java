import java.util.*;
import java.lang.*;

public class officeKey{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int p = scan.nextInt();

		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = scan.nextInt();
		}

		int[] b = new int[k];
		for(int i=0;i<k;i++){
			b[i] = scan.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

        Integer[][] dp = new Integer[n+1][k+1];
        int ans = dpSearch(a, b, dp, p, n-1, k-1);
        System.out.println(ans);

	}


	public static int dpSearch(int[] a, int[] b, Integer[][] dp, int key, int i, int j){
		 if(i<0){
		 	return 0;
		 }
         if(i>j){
         	return Integer.MAX_VALUE;
         }

         if(dp[i][j]!=null){
         	return dp[i][j];
         }


         if(i==j){
         	 dp[i][j] = Math.max(dpSearch(a,b,dp,key,i-1,j-1), Math.abs(key-b[j])+Math.abs(a[i]-b[j]));
         }else{
         	 dp[i][j] = Math.min(dpSearch(a,b,dp,key,i,j-1), Math.max(dpSearch(a,b,dp,key,i-1,j-1), Math.abs(key-b[j])+Math.abs(a[i]-b[j])));
         }

         return dp[i][j];

	}
}