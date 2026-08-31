import java.util.Scanner;

public class App {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      String exp1 = sc.nextLine();
      int count[] = { 0, 0, 0 };
      int counter = 0;
      for (int i = 0; i < exp1.length(); i++) {
         if (exp1.charAt(i) <= '3' && exp1.charAt(i) >= '1') {
            count[(int) exp1.charAt(i) - 49]++;
            counter++;
         }
      }
      for (int i = 0; i < count.length; i++) {
         while (count[i] > 0) {
            System.out.print((i + 1));
            if (--counter > 0)
               System.out.print("+");
            count[i]--;
         }
      }
      sc.close();
   }
}
