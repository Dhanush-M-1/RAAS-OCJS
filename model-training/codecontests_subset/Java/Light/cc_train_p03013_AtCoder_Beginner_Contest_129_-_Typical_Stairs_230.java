import java.util.*;
public class Main{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
 
   int N = sc.nextInt();
   int M = sc.nextInt();
   int[] a = new int[M+1];
   for(int i=0;i<M;i++) a[i] = sc.nextInt();
   long[] dp = new long[N+1];
   int count =0;
   if(N==1) System.out.println(1);
   else
   {

   dp[1]=1;
   if(a[count]==1)
   {
     dp[1]=0;
     count++;
   }
   dp[2]=1+dp[1];
   if(a[count]==2)
   {
     dp[2]=0;
     count++;
   }
   for(int i=3;i<=N;i++)
   {
     if(a[count]==i) 
     {
       dp[i]=0;
       count++;
     }
     else dp[i]=(dp[i-1]+dp[i-2])%1000000007;
   }
   System.out.println(dp[N]);
   }
 }
}