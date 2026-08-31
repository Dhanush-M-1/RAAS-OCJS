import java.util.*;
public class Vasily
{
   public static void main(String[] args)
   {
      Scanner p = new Scanner(System.in);
      int a = p.nextInt();
      int b = p.nextInt();
      int burntOut = 0;
      int total = 0;
      while (a > 0)
      {
         //System.out.println("run");
         //System.out.println("a: " + a + ", b: " + b + ", burntOut: " + burntOut + ", total: " + total);
         a--;
         total++;
         burntOut++;
         if (burntOut == b)
         {
            a++;
            burntOut-=b;
         }
      }
      System.out.println(total);
   }
}