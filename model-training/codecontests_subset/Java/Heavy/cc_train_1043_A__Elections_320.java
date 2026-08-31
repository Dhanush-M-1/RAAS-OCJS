import java.io.*;
import java.util.*;
public class HelloWorld{

     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
         a[i]=sc.nextInt();
         int pos=0;
         int neg=0;
         int max=0;
         for(int i=0;i<n;i++)
          max=Math.max(a[i],max);
          for(int i=0;i<n;i++)
          {
              neg+=a[i];
              pos+=max-a[i];
          }
          if(pos>neg)
          System.out.println(max);
         
          else
          {
              double z=(double)(neg-pos+1)/n;
              int k=(int)Math.ceil(z);
              System.out.println(k+max);
          }
     }
}