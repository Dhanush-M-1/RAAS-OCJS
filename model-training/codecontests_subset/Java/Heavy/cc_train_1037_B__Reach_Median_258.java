import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        long arr[] = new long[n];
        for(int i=0; i<n ;i++)
        arr[i] = sc.nextLong();
        Arrays.sort(arr);
        // for(int i=0; i<n ;i++)
        //  System.out.print(arr[i]+" ");
        //  System.out.println();
         int mid = (n)/2;
        // System.out.println(mid);
         long ans = 0;
         if(arr[mid]<s)
         {
             ans = ans + (s-arr[mid]);
             arr[mid] = s;
             for(int i=mid+1 ; i<n ;i++)
             {
                 if(arr[i]<arr[i-1])
                 {
                     ans =  ans + (arr[i-1]-arr[i]);
                     arr[i] = arr[i-1];
                     
                 }
                 else  
                 break;
             }
         }
         
        else
         {
            ans = ans + (arr[mid]-s);
            arr[mid] = s;
             for(int i=mid-1 ; i>=0 ;i--)
             {
                 if(arr[i]>arr[i+1])
                 {
                     ans =  ans + (arr[i]-arr[i+1]);
                     arr[i] = arr[i+1];
                     
                 }
             }
         }
         
        //   for(int i=0; i<n ;i++)
        //  System.out.print(arr[i]+" ");
        //  System.out.println();
         System.out.println(ans);
    }
}