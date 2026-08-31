import java.io.*;
import java.util.*;

public class ProblemA
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      
      int r1 = in.nextInt();
      int r2 = in.nextInt();
      int c1 = in.nextInt();
      int c2 = in.nextInt();
      int d1 = in.nextInt();
      int d2 = in.nextInt();
      boolean solved = false; 
      int s1,s2,s3,s4;
          
      for (int i = 1; i < 10; i++){
          s1 = i;
          s2 = r1 - s1;
          s3 = c1 - s1;
          s4 = r2 - s3;

          if ((d1 == s1 + s4) && (d2 == s2 + s3))
              if ((s1 != s2) && (s1 != s3) && (s1 != s4) && (s4 != s2) && (s4 != s3) && (s2 != s3))
                  if ((s1 <= 9) && (s2 <= 9) && (s3 <=9) && (s4 <= 9) && (s1 > 0) && (s2 > 0) && (s3 > 0) && (s4 > 0)){
                      out.println(s1 + " " + s2);
                      out.println(s3 + " " + s4);
                      solved = true;
                      break;
          }
      }
      if (!solved) out.print("-1");
      out.flush();
   }
}