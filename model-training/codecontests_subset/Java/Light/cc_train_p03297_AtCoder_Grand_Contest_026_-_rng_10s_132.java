import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();
      long d = sc.nextLong();
      String ans = "Yes";
      if(b > a) {
        ans = "No";
      } else {
        if(b > d) {
          ans = "No";
        } else {
          if(c >= b) {
            ans = "Yes";
          } else {
            long g = gcd(b, d);
            long a1 = (a % g);
            long e = b - g + a1;
            if(e > c) ans = "No"; 
          }
        }
      }

      System.out.println(ans);
    }
  }

  public static long gcd(long x, long y) {
    if(y == 0) return x;
    return gcd(y, (x % y));
  }
}