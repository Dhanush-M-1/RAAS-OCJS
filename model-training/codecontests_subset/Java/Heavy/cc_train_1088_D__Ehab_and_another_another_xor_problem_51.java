/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
https://www.a2oj.com/Ladder16.html
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class D
   {
      public static void main(String omkar[]) throws Exception
      {
         infile = new BufferedReader(new InputStreamReader(System.in));  
         int curr = query(0,0);
         int x = 0;
         int y = 0;
         for(int b=29; b >= 0; b--)
         {
            int first = query(x+(1<<b),y);
            int second = query(x, y+(1<<b));
            if(first != second)
            {
               if(first == -1)
               {
                  x += (1 << b);
                  y += (1 << b);
               }
            }
            else
            {
               if(curr == -1)
               {
                  y += (1 << b);
                  curr = first;
               }
               else
               {
                  x += (1 << b);
                  curr = first;
               }
            }
         }
         System.out.println("! "+x+" "+y);
         System.out.flush();
      }
      static BufferedReader infile;
      public static int query(int a, int b) throws Exception
      {
         System.out.println("? "+a+" "+b);
         System.out.flush();
         return Integer.parseInt(infile.readLine());
      }
   }