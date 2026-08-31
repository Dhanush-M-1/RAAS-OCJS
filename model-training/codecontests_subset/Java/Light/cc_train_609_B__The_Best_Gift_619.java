import java.util.*;
public class BestGift
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int N = scan.nextInt();
      int M = scan.nextInt();
      
      int[] counts = new int[M];
      
      for(int i = 0; i<N; i++)
      {
         counts[scan.nextInt() - 1]++;
      }
      
      int total = 0;
      for(int i = 0; i<M; i++)
      {
         int cur = 0;
         for(int j = i+1; j<M; j++)
         {
            cur+=counts[i] * counts[j];
         }
         total+=cur;
      }
      
      System.out.println(total);
   }
}