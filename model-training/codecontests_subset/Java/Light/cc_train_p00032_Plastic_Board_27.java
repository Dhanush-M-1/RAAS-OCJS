import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int rect = 0;
      int diam = 0;
      while(sc.hasNext()) {
         //get information from the user
         String[] input = sc.nextLine().split(",");
         int a = Integer.parseInt(input[0]);
         int b = Integer.parseInt(input[1]);
         int c = Integer.parseInt(input[2]);
         
         if(a == b) {
            diam ++;
         } else if (c * c == a * a + b * b) {
            rect ++;
         }
      }
      System.out.println(rect + "\n" + diam);
   }
}
