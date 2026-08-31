import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            if(n==1 || n==2)
             System.out.println(n);
            else
            {
                  if(n%2==1)
                   System.out.println((long)n*(n-1)*(n-2));
                  else
                  {
                        long l1=(long)(n-1)*(n-2)*(n-3);
                        long l2=(long)(n)*(n-1)*(n-3);
                        if(n%3!=0)
                         System.out.println(l2);
                        else
                         System.out.println(l1);
                  }
            }
      }
}