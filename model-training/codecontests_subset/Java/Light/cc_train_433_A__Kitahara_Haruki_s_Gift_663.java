import java.util.*;
public class R248_2_A {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int a;
      int sum = 0, num100 = 0, num200 = 0;    
      for (int i = 1; i <= n; i++) {
          a = in.nextInt();              
          if (a==100) num100++;
          else num200++;
          sum+=a;
      }
      if (num100 == 0 || num200 == 0) {
         if((num100%2 == 0 && num200 == 0) ||
            (num200%2 == 0 && num100 == 0))
            System.out.println("YES");
         else
            System.out.println("NO");
      }              
      else
          if ((sum / 100)%2 == 0)
             System.out.println("YES");
          else
             System.out.println("NO");
   }
}
