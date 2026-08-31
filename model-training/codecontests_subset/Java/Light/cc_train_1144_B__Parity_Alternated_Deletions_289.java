import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int count = s.nextInt();
      
      List<Integer> even = new ArrayList<Integer>();
      List<Integer> odd = new ArrayList<Integer>();
      int num;
      for (int i = 0; i < count; i++) {
         num = s.nextInt();
         if (num % 2 == 0) {
            even.add(num);
         } else {
            odd.add(num);
         }
      }
      
      Collections.sort(even);
      Collections.sort(odd);
      
            
      // best case
      if (Math.abs(even.size() - odd.size()) <= 1) {
         System.out.println(0);
      } else {
         // get rid of evens
         int sum = 0;
         if (even.size() > odd.size()) {
            for (int i = 0; i <= even.size() - odd.size() - 2; i++) {
               sum += even.get(i);
            }
         } else {
            for (int i = 0; i <= odd.size() - even.size() - 2; i++) {
               sum += odd.get(i);
            }
         }
         System.out.println(sum);
      }
      
   }
}