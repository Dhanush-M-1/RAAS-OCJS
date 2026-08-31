import java.util.*;
import java.io.*;
public class C {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      long n = sc.nextLong();
      ArrayList<Long> list = new ArrayList<Long>();
      for(long i = 1; i <= (long)Math.sqrt(n); i++) {
         if(n % i == 0) list.add(i);
      }
      
      Collections.sort(list);
      Collections.reverse(list);
      
      for(long x : list) {
         long g = gcd(n / x, x);
         
         if(g == 1) {
            System.out.println(x + " " + (n / x));
            return;
         }
      }
   }
   
   public static long gcd(long a, long b) {
      if(b == 0) return a;
      return gcd(b, a % b);
   }
}