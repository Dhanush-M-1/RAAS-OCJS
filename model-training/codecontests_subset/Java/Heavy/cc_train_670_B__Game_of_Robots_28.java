import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); long k = in.nextLong();
     long ans=0,sol=0; boolean r =true;
     int a[] = new int[n];
     for(long i=0;i<n;i++)
         {
         a[(int)i] = in.nextInt();
         ans = (long)((i+1)*(i+2))/2;
         if(ans==k)
         {sol = a[(int)i]; r=false;}
         else if(ans>k&&r)
         {
             ans = (long)((i+1)*(i))/2;
             r = false;
             sol = a[(int)(k-ans)-1];}
         
     }
     System.out.println(sol);
        }
}
