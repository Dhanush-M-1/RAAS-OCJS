import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


public class Solution
{
   
   public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i=0; i<q ;i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int d = sc.nextInt();
            if(d<l)
            System.out.println(d);
            else
            {
               int k  = (r/d)+1;
               System.out.println((int)k*d);
            }
        }
      
        
    }
}


