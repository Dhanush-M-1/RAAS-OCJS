import java.io.*;
import java.util.*;
public class file
{ 
   public static void main(String args[])throws IOException
   {
      BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
      long n = Long.parseLong(reader.readLine());
      StringTokenizer tk= new StringTokenizer(reader.readLine());
      StringTokenizer tk1= new StringTokenizer(reader.readLine());
      StringTokenizer tk2= new StringTokenizer(reader.readLine());
      long sum1 = 0;
      for(int i=0;i<n;i++)
      {
        sum1+=Long.parseLong(tk.nextToken());  
      }
      long sum2 = 0;
      for(int i=0;i<n-1;i++)
      {
         sum2+=Long.parseLong(tk1.nextToken()); 
      }
      long sum3 = 0;
      System.out.println(sum1-sum2);
      for(int i=0;i<n-2;i++)
      {
        sum3+=Long.parseLong(tk2.nextToken());
      }
      System.out.println(sum2-sum3);
   }
}