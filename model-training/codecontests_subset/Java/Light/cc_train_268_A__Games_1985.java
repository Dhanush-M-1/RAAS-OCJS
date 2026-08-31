import java.util.*;
import java.lang.*;

import java.util.regex.Pattern;

public class Example {
    public static int Max(int[] p)
    {
        int Max=0;
        int j=0;
        for(int i=0;i<p.length;i++)
        {
            if(p[i]>Max)
            {
                Max = p[i];
                j=i;
            }
        }
        return j;
    }
    public static int Min(int[] p)
    {
        int Min=100;
        int j=0;
        for(int i=0;i<p.length;i++)
        {
            if(p[i]<=Min)
            {
                Min = p[i];
                j=i;
            }
        }
        return j;
    }
    public static void main(String[] args) {
     int n;
     int count=0;
     Scanner sc = new Scanner(System.in);
     n=sc.nextInt();
     int[] h = new int[n];
     int[] a = new int[n];
     for(int i=0;i<n;i++)
     {
         h[i]=sc.nextInt();
         a[i]=sc.nextInt();
     }
     for(int i=0;i<n;i++)
     {
         for (int j=0;j<n;j++)
         {
             if(h[i]==a[j]) count++;
         }
     }
     System.out.print(count);
    }
}
