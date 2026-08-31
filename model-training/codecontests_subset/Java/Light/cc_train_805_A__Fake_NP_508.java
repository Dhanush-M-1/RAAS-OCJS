import java.util.*;
import java.io.*;
public class NP
{
   public static void main(String[] args)
   {
   
      Scanner dank = new Scanner(System.in);
      int x = dank.nextInt();
      int y = dank.nextInt();
      if(x == y)
      {
         System.out.print(x);
      }
      else
      {
         int count = 2;
         System.out.print(count);
      }
   }
}