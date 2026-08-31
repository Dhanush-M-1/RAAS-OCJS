import java.util.*;
import java.lang.*;
import java.io.*;
public class Wat
{   
   public static void main(String args[])  
  {
    int i,j=0,k,n;
    Scanner sc=new Scanner(System.in);
     n=sc.nextInt();
     k=sc.nextInt();
     int a[]=new int[n];
     for(i=0;i<n;i++)
     a[i]=sc.nextInt();
     //Arrays.sort(a);
     int prev=0;
     for(i=0;i<n;i++)
      if(k%a[i]==0 && a[i]>prev)
        prev=a[i];
     int ans=k/prev;
    System.out.println(ans);
   }
}