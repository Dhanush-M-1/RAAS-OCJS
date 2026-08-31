import java.util.*;
import java.math.BigInteger; 
public class asd
{static Scanner s=new Scanner(System.in);
             
      public static void main(String args[]) throws Exception
         {
             int t=1;
             while(t-->0)
                  {
               solve();
                  }
         }
         
         public static void solve() {
         int n=s.nextInt();
         int y=s.nextInt();
         long arr[]=new long[n];
         for(int i=0;i<n;i++)
             arr[i]=s.nextLong();
         Arrays.sort(arr);
         long med=arr[n/2];
         if(med<y)
         {
         long sum=(long)(y-med);arr[n/2]=y;
         for(int i=n/2+1;i<n;i++)
         {
             if(arr[i]<y)
             {
                 sum+=(y-arr[i]);
             }
             else
                 break;
         }
         System.out.println(sum);
         }
         else
         {
             long sum=med-y;
             arr[n/2]=y;
              for(int i=n/2-1;i>=0;i--)
              {
                  if(arr[i]>y)
                  {
                      sum+=(arr[i]-y);
                  }
                  else
                      break;
              }
              System.out.println(sum);
         }
    } 
}