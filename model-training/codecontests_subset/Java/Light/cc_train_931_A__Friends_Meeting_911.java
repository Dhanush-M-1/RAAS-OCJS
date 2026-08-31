import java.io.*;
import java.util.*;
public class file
{ 
   public static void main(String args[])throws IOException
   {
      BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
      long a = Long.parseLong(reader.readLine());
      long b = Long.parseLong(reader.readLine());
      long m = (a+b)/2;
      a=Math.abs(m-a);
      b=Math.abs(b-m);
      a=(a*(a+1))/2;
      b=(b*(b+1))/2;
      System.out.println(a+b);
    }
}