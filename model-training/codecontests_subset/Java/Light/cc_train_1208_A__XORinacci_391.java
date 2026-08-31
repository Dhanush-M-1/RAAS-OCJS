import java.util.*;

public class Solution {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int t = sc.nextInt();
    while (t-- > 0) {
      int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
      if (n % 3 == 0) {
        System.out.println(a);
      } else if (n % 3 == 1) {
        System.out.println(b);
      } else {
        System.out.println(a ^ b);
      }
    }
  }
}