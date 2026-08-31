

import java.io.*;
import java.util.*;

public class Main {

	static final int N=2005;
	static int a[]=new int[N];
	static int key[]=new int[N];
	static long dp[][]=new long[N][N];
	static final long inf=(long)2e12+10;
    public static void main(String[] args){
        Scanner sc=new Scanner(new InputStreamReader(System.in));
        while(sc.hasNext()) {
              int n=sc.nextInt(),m=sc.nextInt(),p=sc.nextInt();
              for(int i=1;i<=n;i++) a[i]=sc.nextInt();
              for(int i=1;i<=m;i++) key[i]=sc.nextInt();
              Arrays.sort(a,1,n+1);
              Arrays.sort(key,1,m+1);
              for(int i=0;i<=n;i++) {
            	   for(int j=0;j<=m;j++) {
            		   if(i==0) dp[i][j]=0;
            		   else dp[i][j]=inf;
            	   }
              }
              for(int i=1;i<=n;i++) {
            	  for(int j=i;j<=m;j++) {
            		  dp[i][j]=Math.min(dp[i][j-1], 
            				  Math.max(dp[i-1][j-1],(long)Math.abs(a[i]-key[j])+Math.abs(key[j]-p)));
            	  }
              }
              System.out.println(dp[n][m]);
        }
        sc.close();
    }
}