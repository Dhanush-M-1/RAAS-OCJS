
import java.util.*;


public class B
{
   public static void main(String[] args)
   {
      new B(new Scanner(System.in));  
   }

   public B(Scanner in)
   {
      int A = in.nextInt();
      int B = in.nextInt();
      int C = in.nextInt();

      if (A == 0)
      {
         if (B == 0)
         {
            if (C == 0)
            {
               System.out.println("-1");
               return;
            }

            System.out.println("0");
            return;
         }

         double res = (-1.0*C)/B;
         System.out.printf("%d%n%.9f%n", 1, res);
         return;
      }

      if ((B == 0)&&(C == 0))
      {
         System.out.printf("1%n0.000000000%n");
         return;
      }

      TreeSet<Double> res = quad(A, B, C);
      System.out.printf("%d%n", res.size());
      for (double d : res)
         System.out.printf("%.9f%n", d);
   }

   double EPS = 1e-9;

   TreeSet<Double> quad(long A, long B, long C)
   {
      long r = B*1L*B-A*4L*C;
      if (r < 0)
         return new TreeSet<Double>();
      double rr = Math.sqrt(r);
      double t1 = -B+rr;
      double t2 = -B-rr;
      double r1 = (0.5*t1)/A;
      double r2 = (0.5*t2)/A;
      TreeSet<Double> res = new TreeSet<Double>();
      res.add(r1);
      if (Math.abs(r1-r2) > 1e-9)
         res.add(r2);
      return res;
   }
}

