import java.util.*;
 
public class Main{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      
      int[] countPerGenre = new int[m + 1];
      Arrays.fill(countPerGenre, 0);
      for (int i = 0; i < n; ++i) {
        int a = sc.nextInt();
        ++countPerGenre[a];
      }
      
      int res = 0;
      int sum = 0;
      for (int i = 1; i <= m; ++i) {
        res += countPerGenre[i] * sum;
        sum += countPerGenre[i];
      }
      System.out.println(res);
    }
}