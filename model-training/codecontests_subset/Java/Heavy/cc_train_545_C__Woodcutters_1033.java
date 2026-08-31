import java.io.*;
import java.util.*;

public class main{
    
    public static void main(String[] args){
        
        Scanner s  = new Scanner(System.in);
        int  n = s.nextInt();
       long[] arr= new long[n];
       long[] ht=  new long[n];
       long[][] dp = new long[n+1][3];
       for(int i=0;i<n;i++){
           arr[i]=s.nextLong();
           ht[i]=s.nextLong();
       }
       dp[0][0]=0;
       dp[0][1]=1;
         if(n>1 && arr[0]+ht[0]<arr[1]){
             dp[0][2]=1;
         }
      
       for(int j=1;j<n;j++){
           dp[j][0]=Math.max(dp[j-1][0],dp[j-1][1]);
            //dp[j][0]=Math.max(dp[j-1][0],dp[j-1][1]);
           if(arr[j-1]+ht[j-1]<arr[j]){
               dp[j][0]=Math.max(dp[j-1][2],dp[j][0]);
           }
            if(arr[j]-ht[j]>arr[j-1]){
                dp[j][1]=Math.max(dp[j-1][0]+1,dp[j-1][1]+1);
              //  System.out.println("Left");
            }
            if(arr[j]-ht[j]>arr[j-1]+ht[j-1]){
                dp[j][1]=Math.max(dp[j-1][2]+1,dp[j][1]);
            }
            
           if(j!=n-1){
          long xxx= arr[j]+ht[j];
                            //        System.out.println(j +"  here"+ " "+xxx);

           if(xxx<arr[j+1]){
                // System.out.println("Right");
            dp[j][2]=Math.max(dp[j-1][0]+1,Math.max(dp[j-1][1]+1,dp[j-1][2]+1));
           }
           }else{
            dp[j][2]=Math.max(dp[j-1][0]+1,Math.max(dp[j-1][1]+1,dp[j-1][2]+1));
           }
          
           }
       
       
    //   for(int k=0;k<n;k++){
    //       System.out.println(dp[k][0]+" "+dp[k][1]+" "+dp[k][2]);
    //   }
      long max= Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
      System.out.println(max);
      
    }
}