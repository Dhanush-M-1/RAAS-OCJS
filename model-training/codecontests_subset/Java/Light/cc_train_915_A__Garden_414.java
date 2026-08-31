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
        int k = sc.nextInt();
       // int ans = 0;
        int arr[] = new int[n];
        for(int i=0; i<n ;i++)
        arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int i=n-1; i>=0; i--)
        {
           if(k%arr[i]==0)
           {
           System.out.println(k/arr[i]);
           break;
           }
        }
        
    }
}