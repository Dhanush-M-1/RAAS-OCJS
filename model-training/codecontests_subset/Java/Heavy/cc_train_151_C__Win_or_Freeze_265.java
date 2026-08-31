import java.util.Scanner;

public class Main {
   private static long move = 0;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      long n = Long.parseLong(sc.nextLine());
      int winner = play(n);
      System.out.println(winner);
      if (winner == 1) {
         System.out.println(move);
      }
   }

   private static int play(long num) {
      int count = 0;
      int partner = 0;
      long sqrt = (long) Math.sqrt(num);
      for (long i = 2; i <= sqrt; i++)
         if (num % i == 0) {
            long times = num;
            while (times % i == 0) {
               count++;
               if (count == 1)
                  move = i;
               else if (count == 2) {
                  move *= i;
                  if (partner > 0)
                     return 1;
               }
               else
                  return 1;
               times /= i;
               if (times > sqrt)
                  partner++;
            }
         }
      if (count == 0)
         return 1;
      else
         return 2;
   }
}