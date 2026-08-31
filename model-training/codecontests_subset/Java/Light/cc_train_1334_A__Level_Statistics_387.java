import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class Solution {

private static boolean isValid(int arr[][], int n)
    {
        if (n==0)
            return true;
        if(arr[1][0]>arr[0][0])
            return false;
        for(int i=1;i<n;i++)
        {
            int c_diff = arr[1][i] - arr[1][i-1];
            int p_diff = arr[0][i] - arr[0][i-1];
            if(p_diff < c_diff || arr[1][i]>arr[0][i] || p_diff<0 || c_diff<0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),n, num;
        int arr[][];
        int nums[];
        while(t>0)
        {
            t--;
            n=sc.nextInt();
               arr = new int[2][n];
            for(int i=0;i<n;i++)
            {
                arr[0][i] = sc.nextInt();
                arr[1][i] = sc.nextInt();
            }
            boolean ans = isValid(arr,n);
            if(ans) 
                System.out.println("YES");
            else      
                System.out.println("NO");
        }
        sc.close();   
    }
}
