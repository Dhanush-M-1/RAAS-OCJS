import java.util.*;

public class mtwodsix
{

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int tt = 0; tt < T; tt++)
      {
         int n = sc.nextInt();
         if (n == 1)
         {
            System.out.println(0);
            continue;
         }
         int num_two = num_two(n);
         int num_three = num_three(n);
         if (num_two > num_three || otherfact(num_two, num_three, n))
         {
            System.out.println(-1);
         }
         else if (num_two == num_three)
         {
            System.out.println(num_three);
         }
         else
         {
            int ret = (num_three - num_two) + num_three;
            System.out.println(ret);
         }

      }

   }

   public static int num_two(int n)
   {
      int i = 0;
      while (n % 2 == 0)
      {

         i++;
         n /= 2;

      }
      return i;
   }

   public static int num_three(int n)
   {
      int i = 0;
      while (n % 3 == 0)
      {
         n /= 3;
         i++;
      }
      return i;

   }
   public static boolean otherfact(int n2, int n3, int n) 
   {
      while(n2-->0)
         n/=2;
      while(n3-->0)
         n/=3;
      return n>1;
   }

}
