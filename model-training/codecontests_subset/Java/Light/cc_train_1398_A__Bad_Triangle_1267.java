import java.util.*;
import java.io.*;

public class Sol
{
   public static void main(String ags[])
   {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      while(n>0)
      {
         int l=sc.nextInt();
         int a[]=new int[l];
         int i=0;
         for(i=0;i<l;i++)
         {
            a[i]=sc.nextInt();
         }
         if(a[0]+a[1]>a[l-1])
            System.out.println("-1");
         else
            System.out.println("1 2 "+(l));
         n--;
      }
   }
}